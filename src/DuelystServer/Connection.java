package DuelystServer;

import DuelystServer.messages.AccountMessage;
import DuelystServer.model.Account;
import DuelystServer.model.ErrorType;
import com.gilecode.yagson.YaGson;
import com.gilecode.yagson.YaGsonBuilder;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection implements Runnable {
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private Socket socket;

    public Connection(Socket socket) {
        this.socket = socket;
        try {
            inputStream = new ObjectInputStream(this.socket.getInputStream());
            outputStream = new ObjectOutputStream(this.socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true){
            try {
                String str = (String) receivePacket();
                YaGson yaGson = new YaGsonBuilder().create();
                Object packet = yaGson.fromJson(str, Object.class);
                if (packet instanceof AccountMessage) {
                    AccountMessage accountMessage = (AccountMessage) packet;
                    boolean flag = Account.existThisUser(accountMessage.getUser());
                    if (flag && accountMessage.isSignUpOrLogIn()){
                        //signUp error
                        yaGson.toJson(ErrorType.USER_ALREADY_CREATED);
                    } else if (flag && !accountMessage.isSignUpOrLogIn()){
                        //loginK
                        boolean f = Account.authorize(accountMessage.getUser(),accountMessage.getPass());
                        if (f){
                            Account account = Account.getAccount(accountMessage.getUser());
                            yaGson.toJson(account);
                        } else {
                            yaGson.toJson(ErrorType.WRONG_PASSWORD);
                        }
                    } else if (!flag && accountMessage.isSignUpOrLogIn()){
                        //sign up
                        Account account = new Account(accountMessage.getUser(),accountMessage.getPass());
                        yaGson.toJson(account);
                    } else {
                        //login error
                        yaGson.toJson(ErrorType.NO_SUCH_USER_EXIST);
                    }
                    sendPacket(yaGson);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void sendPacket(Object object) {
        try {
            outputStream.writeObject(object);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object receivePacket() {
        try {
            return inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
