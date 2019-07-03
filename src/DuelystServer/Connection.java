package DuelystServer;

import DuelystServer.messages.AccountMessage;
import DuelystServer.messages.ShopMessage;
import DuelystServer.model.Account;
import DuelystServer.model.ErrorType;
import DuelystServer.model.Shop;
import com.google.gson.Gson;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Random;

public class Connection implements Runnable {
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private Socket socket;
    private boolean running;

    public Connection(Socket socket) {
        for (Account account : Account.getAllUser()) {
            System.out.println(account.getCollection().getHeroes().get(0).getClass().getSimpleName());
        }
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
                if (packet.getNameOfClass().equals("AccountMessage")) {
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
                            account.setAuthToken(new Random().nextLong());
                            sendPacket(gson.toJson(account));
                        } else {
                            //login Error
                            sendPacket(gson.toJson(ErrorType.WRONG_PASSWORD));
                        }
                    } else if (!flag && accountMessage.isSignUpOrLogIn()) {
                        //sign up
                        Account account = new Account(accountMessage.getUser(), accountMessage.getPass());
                        account.setAuthToken(new Random().nextLong());
                        sendPacket(gson.toJson(account));
                    } else {
                        //login error
                        sendPacket(gson.toJson(ErrorType.NO_SUCH_USER_EXIST));
                    }
                } else if (packet.getNameOfClass().equals("ShopMessage")) {
                    System.out.println(str);
                    ShopMessage shopMessage = gson.fromJson(str, ShopMessage.class);
                    Account account = Account.getAccount(shopMessage.getAuthToken());
                    if (account == null)
                        throw new Exception();

                    Shop shop = new Shop();
                    System.out.println("shopMessage: " + shopMessage.isSignUpOrLogIn());
                    if (!shopMessage.isSignUpOrLogIn()) {
                        ShopMessage.buyAction(account, shopMessage, shop);
                        sendPacket(gson.toJson(shopMessage));
                    } else {
                        ShopMessage.sellAction(shop, shopMessage, account);
                        sendPacket(gson.toJson(shopMessage));
                    }
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
