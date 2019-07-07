package DuelystServer;

import DuelystServer.Controller.ShopController;
import DuelystServer.messages.*;
import DuelystServer.model.Card.Hero.CustomHero;
import DuelystServer.messages.AccountMessage;
import DuelystServer.messages.CustomMessage;
import DuelystServer.messages.SaveAccountMessage;
import DuelystServer.messages.ShopInitializeMessage;
import DuelystServer.messages.ShopMessage;
import DuelystServer.model.Account;
import DuelystServer.model.Card.Hero.Hero;
import DuelystServer.model.Card.Minion.CustomMinion;
import DuelystServer.model.Card.Minion.Minion;
import DuelystServer.model.Card.Spell.Spell;
import DuelystServer.model.Deck;
import DuelystServer.model.ErrorType;
import DuelystServer.model.Item.UsableItem.UsableItem;
import DuelystServer.model.Shop;
import com.google.gson.Gson;
import javafx.scene.image.Image;
import javafx.util.Pair;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Date;
import java.util.Random;

import static DuelystServer.messages.AuctionStartMessage.bids;

public class Connection implements Runnable {
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private Socket socket;
    private boolean running;
    private String user;

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

            String str = ((String) receivePacket());
            while (str == null) {
                str = ((String) receivePacket());
            }
            System.out.println("received");
            Gson gson = new Gson();
            System.out.println(str);
            if (str.contains("65432")) {
                sendPacket(gson.toJson(new helloMessage()));
            }
            if (str.contains("14123")) {
                SaveAccountMessage saveAccountMessage = gson.fromJson(str, SaveAccountMessage.class);
                for (Account account : Account.getAllUser()) {
                    if (account.getUserName().equals(saveAccountMessage.getAccount().getUserName())) {
                        Account.getAllUser().remove(account);
                        saveAccountMessage.getAccount().connection = this;
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
                        user = accountMessage.getUser();
                        account.setOnOff(true);
                        account.setAuthToken(new Random().nextLong());
                        account.connection = this;
                        AccountPacket accountPacket = new AccountPacket();
                        accountPacket.setAccount(account);
                        sendPacket(gson.toJson(accountPacket));
                    } else {
                        //login Error
                        sendPacket(gson.toJson(ErrorType.WRONG_PASSWORD));
                    }
                } else if (!flag && accountMessage.isSignUpOrLogIn()) {
                    //sign up
                    Account account = new Account(accountMessage.getUser(), accountMessage.getPass());
                    user = accountMessage.getUser();
                    account.setOnOff(true);
                    account.setAuthToken(new Random().nextLong());
                    account.connection = this;
                    AccountPacket accountPacket = new AccountPacket();
                    accountPacket.setAccount(account);
                    sendPacket(gson.toJson(accountPacket));
                } else {
                    //login error
                    sendPacket(gson.toJson(ErrorType.NO_SUCH_USER_EXIST));
                }
            } else if (str.contains("43123") || str.contains("64532")) {
                System.out.println(str);
                ShopMessage shopMessage = gson.fromJson(str, ShopMessage.class);
                Account account = Account.getAccount(shopMessage.getAuthToken());
                if (account == null)
                    throw new NullPointerException();
                Shop shop = new Shop();
                if (!shopMessage.isSignUpOrLogIn()) {
                    ShopMessage.buyAction(account, shopMessage, shop);
                    sendPacket(gson.toJson(shopMessage));
                } else {
                    System.out.println("sellll");
                    ShopMessage.sellAction(shop, shopMessage, account);
                    sendPacket(gson.toJson(shopMessage));
                }
                ShopController.getInstance().updateShop();
            } else if (str.contains("41543")) {
                for (Connection connection : Server.getConnections()) {
                    connection.sendPacket(str);
                }
            } else if (str.contains("21432")) {
                System.out.println(str);
                CustomMessage customMessage = gson.fromJson(str, CustomMessage.class);
                if (customMessage.isType()) {
                    CustomHero customHero = new CustomHero(customMessage.getName(), customMessage.getAp()
                            , customMessage.getHp(), customMessage.getCost(), customMessage.getTypeOfRange(), customMessage.getRange(),
                            customMessage.getCoolDownTime(), customMessage.getMana());
                    ShopMessage.getNumberOfHeroesInShop().add(5);
                    for (Connection connection : Server.getConnections()) {
                        if (!connection.equals(this)) {
                            connection.sendPacket(str);
                        }
                    }
                    ShopController.getInstance().createCard(customMessage, customHero);
                } else {
                    CustomMinion customMinion = new CustomMinion(customMessage.getName(), customMessage.getAp()
                            , customMessage.getHp(), customMessage.getCost(), customMessage.getTypeOfRange(), customMessage.getRange(),
                            customMessage.getMana(), customMessage.getActiveTime());
                    ShopMessage.getNumberOfMinionsInShop().add(5);
                    for (Connection connection : Server.getConnections()) {
                        if (!connection.equals(this)) {
                            connection.sendPacket(str);
                        }
                    }
                    ShopController.getInstance().createCard(customMessage, customMinion);
                }
            } else if (str.contains("34121")) {
                System.out.println(str);
                ShopInitializeMessage message = gson.fromJson(str, ShopInitializeMessage.class);
                message.setHeroesInShop(ShopMessage.getNumberOfHeroesInShop());
                message.setMinionsInShop(ShopMessage.getNumberOfMinionsInShop());
                message.setSpellInShop(ShopMessage.getNumberOfSpellInShop());
                message.setItemsInShop(ShopMessage.getNumberOfItemsInShop());
                sendPacket(gson.toJson(message));
            } else if (str.contains("53412")) {
                BidMessage bidMessage = gson.fromJson(str, BidMessage.class);
                AuctionStartMessage.addBid(bidMessage);
                int max = 0;
                BidMessage bidMessageMax = new BidMessage();
                for (BidMessage bidMessage1 : bids) {
                    if (max <= Integer.parseInt(bidMessage1.getText().getValue())) {
                        max = Integer.parseInt(bidMessage1.getText().getValue());

                        bidMessageMax.setText(new Pair<>(bidMessage1.getText().getKey(), bidMessage1.getText().getValue()));
                    }
                }

                for (Connection connection : Server.getConnections()) {
                    connection.sendPacket(gson.toJson(bidMessageMax));
                }

            } else if (str.contains("53645")) {
                System.out.println(str + "auction recieved");
                AuctionStartMessage auctionMessage = new Gson().fromJson(str, AuctionStartMessage.class);
                for (Connection connection : Server.getConnections()) {
                    connection.sendPacket(str);
                }
                auctionMessage.time = new Date().getTime();
                new Thread(() -> {
                    while (new Date().getTime() - auctionMessage.time < 1000 * 60) ;
                    int max = 0;
                    BidMessage bidMessageMax = new BidMessage();
                    System.out.println(bids.size());
                    for (BidMessage bidMessage : bids) {
                        if (max <= Integer.parseInt(bidMessage.getText().getValue())) {
                            max = Integer.parseInt(bidMessage.getText().getValue());
                            bidMessageMax.setText(new Pair<>(bidMessage.getText().getKey(), bidMessage.getText().getValue()));
                        }
                    }
                    AuctionMessage auctionMessageSeller = new AuctionMessage();
                    AuctionMessage auctionMessageBuyer = new AuctionMessage();
                    for (Account account : Account.getAllUser()) {
                        if (account.getAuthToken() == auctionMessage.getStarterAuthToken()) {
                            String cardName = auctionMessage.getCardData().split("\\n")[0];
                            for (Deck deck : account.getCollection().getDecks()) {
                                deck.getHero().removeIf(hero -> hero.getName().equals(cardName));
                                deck.getUsableItem().removeIf(item -> item.getName().equals(cardName));
                                deck.getSpells().removeIf(spell -> spell.getName().equals(cardName));
                                deck.getMinions().removeIf(minion -> minion.getName().equals(cardName));
                                account.getCollection().removeFromDeck(cardName, deck.getName());
                            }
                            System.out.println(cardName);
                            for (Hero hero : Hero.getHeroes()) {
                                System.out.println(hero.getName());
                                if (hero.getName().toLowerCase().equals(cardName.toLowerCase())) {
                                    System.out.println(account.getCollection().getHeroes().size());
                                    account.getCollection().getHeroes().remove(hero);
                                    System.out.println(account.getCollection().getHeroes().size());
                                    System.out.println("yeahh");
                                }
                            }
                            for (Spell spell : Spell.getSpells()) {
                                if (spell.getName().equals(cardName)) {
                                    account.getCollection().getSpells().remove(spell);
                                }
                            }
                            for (Minion minion : Minion.getMinions()) {
                                if (minion.getName().equals(cardName)) {
                                    account.getCollection().getMinions().remove(minion);
                                }
                            }
                            for (UsableItem usableItem : UsableItem.getUsableItems()) {
                                if (usableItem.getName().equals(cardName)) {
                                    account.getCollection().getUsableItems().remove(usableItem);
                                }
                            }
                            long time = new Date().getTime();
                            while (new Date().getTime() - time < 2000) ;
                            account.setMoney(account.getMoney() + max);
                            auctionMessageSeller.setAccount(account);
                            System.out.println(auctionMessageSeller.getAccount().getCollection().getHeroes().size() + "seller");
                            account.connection.sendPacket(new Gson().toJson(auctionMessageSeller));
                        }
                        if (account.getAuthToken() == bidMessageMax.getText().getKey()) {
                            String cardName = auctionMessage.getCardData().split("\\n")[0];
                            for (Hero hero : Hero.getHeroes()) {
                                if (hero.getName().toLowerCase().equals(cardName.toLowerCase())) {
                                    account.getCollection().getHeroes().add(hero);
                                }
                            }
                            for (Spell spell : Spell.getSpells()) {
                                if (spell.getName().toLowerCase().equals(cardName.toLowerCase())) {
                                    account.getCollection().getSpells().add(spell);
                                }
                            }
                            for (Minion minion : Minion.getMinions()) {
                                if (minion.getName().toLowerCase().equals(cardName.toLowerCase())) {
                                    account.getCollection().getMinions().add(minion);
                                }
                            }
                            for (UsableItem usableItem : UsableItem.getUsableItems()) {
                                if (usableItem.getName().toLowerCase().equals(cardName.toLowerCase())) {
                                    account.getCollection().getUsableItems().add(usableItem);
                                }
                            }
                            long time = new Date().getTime();
                            while (new Date().getTime() - time < 2000) ;
                            account.setMoney(account.getMoney() - max);
                            auctionMessageBuyer.setAccount(account);

                            System.out.println(auctionMessageBuyer.getAccount().getCollection().getHeroes().size() + "buyer");
                            account.connection.sendPacket(new Gson().toJson(auctionMessageBuyer));

                        }
                    }
                }).start();
            } else if (str.contains("46723")) {
                ScoreBoardMessage message = gson.fromJson(str, ScoreBoardMessage.class);
                message.setAccounts(Account.getAllUser());
                sendPacket(gson.toJson(message));
            } else if (str.contains("42568")) {
                LogoutMessage logoutMessage = gson.fromJson(str, LogoutMessage.class);
                Account.getAccount(logoutMessage.getAccount().getUserName()).setOnOff(false);

            }


        }


    }


    public void sendPacket(Object object) {
        try {
            outputStream.reset();
            outputStream.writeObject(object);
            outputStream.flush();
        } catch (IOException e) {
            running = false;
            Account.getAccount(user).setOnOff(false);
            Server.getConnections().remove(this);
        }
    }

    public Object receivePacket() {
        try {
            return inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            running = false;
            Account.getAccount(user).setOnOff(false);
            Server.getConnections().remove(this);
        }

        return null;
    }
}
