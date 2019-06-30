package DuelystServer;

import DuelystServer.messages.AccountMessage;
import DuelystServer.messages.ShopMessage;
import DuelystServer.model.Account;
import DuelystServer.model.ErrorType;
import com.google.gson.Gson;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

public class Connection implements Runnable {
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private Socket socket;
    private boolean running;

    public Connection(Socket socket) {
        this.socket = socket;
        try {
            outputStream = new ObjectOutputStream(this.socket.getOutputStream());
            inputStream = new ObjectInputStream(this.socket.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(this).start();
    }

    @Override
    public void run() {
        running = true;
        while (running) {
            try {
                String str = ((String) receivePacket());
                if (str == null) {
                    break;
                }
                System.out.println("received");
                outputStream.reset();
                Gson gson = new Gson();
                AccountMessage packet = gson.fromJson(str, AccountMessage.class);
                if (packet.getClass().getSimpleName().equals("AccountMessage")) {
                    AccountMessage accountMessage = packet;
                    boolean flag = Account.existThisUser(accountMessage.getUser());
                    if (flag && accountMessage.isSignUpOrLogIn()) {
                        //signUp error
                        sendPacket(gson.toJson(ErrorType.USER_ALREADY_CREATED));
                    } else if (flag && !accountMessage.isSignUpOrLogIn()) {
                        //login
                        boolean f = Account.authorize(accountMessage.getUser(), accountMessage.getPass());
                        if (f) {
                            Account account = Account.getAccount(accountMessage.getUser());
                            sendPacket(gson.toJson(account));
                        } else {
                            //login Error
                            sendPacket(gson.toJson(ErrorType.WRONG_PASSWORD));
                        }
                    } else if (!flag && accountMessage.isSignUpOrLogIn()) {
                        //sign up
                        Account account = new Account(accountMessage.getUser(), accountMessage.getPass());
                        sendPacket(gson.toJson(account));
                    } else {
                        //login error
                        sendPacket(gson.toJson(ErrorType.NO_SUCH_USER_EXIST));
                    }
                } else if (packet.getClass().getSimpleName().equals("ShopMessage")){
                    ShopMessage shopMessage = (ShopMessage) packet;
                    Account account = Account.getAccount(shopMessage.getUser());
                    ShopMessage.buyAction(shopMessage,account);
                    sendPacket(gson.toJson(shopMessage));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void sendPacket(Object object) {
        try {
            outputStream.reset();
            outputStream.writeObject(object);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object receivePacket() {
        try {
            return inputStream.readObject();
        } catch (EOFException | SocketException e) {
            running = false;
            Server.getConnections().remove(this);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
