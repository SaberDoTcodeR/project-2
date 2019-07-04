package DuelystServer;

import DuelystServer.model.Card.Hero.CustomHero;
import DuelystServer.messages.AccountMessage;
import DuelystServer.messages.CustomMessage;
import DuelystServer.messages.SaveAccountMessage;
import DuelystServer.messages.ShopInitializeMessage;
import DuelystServer.messages.ShopMessage;
import DuelystServer.messages.TextMessage;
import DuelystServer.model.Account;
import DuelystServer.model.Card.Minion.CustomMinion;
import DuelystServer.model.ErrorType;
import DuelystServer.model.Shop;
import com.google.gson.Gson;
import javafx.scene.image.Image;

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
                if (str.contains("14123")) {
                    SaveAccountMessage saveAccountMessage = gson.fromJson(str, SaveAccountMessage.class);
                    for (Account account : Account.getAllUser()) {
                        if (account.getUserName().equals(saveAccountMessage.getAccount().getUserName())) {
                            Account.getAllUser().remove(account);
                            Account.getAllUser().add(saveAccountMessage.getAccount());
                        }
                    }
                } else if (str.contains("42131")) {
                    AccountMessage accountMessage = gson.fromJson(str, AccountMessage.class);
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
                } else if (str.contains("43123")) {
                    ShopMessage shopMessage = gson.fromJson(str, ShopMessage.class);
                    Account account = Account.getAccount(shopMessage.getAuthToken());
                    if (account == null)
                        throw new Exception();
                    Shop shop = new Shop();
                    if (!shopMessage.isSignUpOrLogIn()) {
                        ShopMessage.buyAction(account, shopMessage, shop);
                        sendPacket(gson.toJson(shopMessage));
                    } else {
                        ShopMessage.sellAction(shop, shopMessage, account);
                        sendPacket(gson.toJson(shopMessage));
                    }
                } else if (str.contains("41543")) {
                    for (Connection connection : Server.getConnections()) {
                        connection.sendPacket(str);
                    }
                } else if (str.contains("21432")) {
                    System.out.println(str);
                    CustomMessage customMessage = gson.fromJson(str, CustomMessage.class);
                    if (customMessage.isType()) {
                        new CustomHero(customMessage.getName(), customMessage.getAp()
                                , customMessage.getHp(), customMessage.getCost(), customMessage.getTypeOfRange(), customMessage.getRange(),
                                customMessage.getImageURL(), customMessage.getCoolDownTime(), customMessage.getMana());
                    } else {
                        new CustomMinion(customMessage.getName(), customMessage.getAp()
                                , customMessage.getHp(), customMessage.getCost(), customMessage.getTypeOfRange(), customMessage.getRange(),
                                customMessage.getImageURL(), customMessage.getMana(), customMessage.getActiveTime());
                    }
                } else if (str.contains("34121")) {
                    System.out.println(str);
                    ShopInitializeMessage message = gson.fromJson(str, ShopInitializeMessage.class);
                    message.setHeroesInShop(ShopMessage.getNumberOfHeroesInShop());
                    message.setMinionsInShop(ShopMessage.getNumberOfMinionsInShop());
                    message.setSpellInShop(ShopMessage.getNumberOfSpellInShop());
                    message.setItemsInShop(ShopMessage.getNumberOfItemsInShop());
                    sendPacket(gson.toJson(message));
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
