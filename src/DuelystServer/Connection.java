package DuelystServer;

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
                            sendPacket(gson.toJson(account));
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
                        sendPacket(gson.toJson(account));
                    } else {
                        //login error
                        sendPacket(gson.toJson(ErrorType.NO_SUCH_USER_EXIST));
                    }
                } else if (str.contains("43123")) {
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
                                 customMessage.getCoolDownTime(), customMessage.getMana());
                        ShopMessage.getNumberOfHeroesInShop().add(5);
                        for (Connection connection : Server.getConnections()){
                            if (!connection.equals(this)){
                                connection.sendPacket(customMessage);
                            }
                        }
                    } else {
                        new CustomMinion(customMessage.getName(), customMessage.getAp()
                                , customMessage.getHp(), customMessage.getCost(), customMessage.getTypeOfRange(), customMessage.getRange(),
                                 customMessage.getMana(), customMessage.getActiveTime());
                        ShopMessage.getNumberOfMinionsInShop().add(5);
                        for (Connection connection : Server.getConnections()){
                            if (!connection.equals(this)){
                                connection.sendPacket(customMessage);
                            }
                        }
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
                    int x = 0;
                    for (Connection connection : Server.getConnections()) {
                        connection.sendPacket(gson.toJson(bidMessageMax));
                    }

                } else if (str.contains("53645")) {
                    AuctionStartMessage auctionMessage = new Gson().fromJson(str, AuctionStartMessage.class);
                    auctionMessage.time = new Date().getTime();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
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
                                    for (Hero hero : Hero.getHeroes()) {
                                        if (hero.getName().equals(cardName)) {
                                            Hero hero1 = hero.duplicate();
                                            account.getCollection().getHeroes().remove(hero1);
                                            return;
                                        }
                                    }
                                    for (Spell spell : Spell.getSpells()) {
                                        if (spell.getName().equals(cardName)) {
                                            Spell spell1 = spell.duplicate();
                                            account.getCollection().getSpells().remove(spell1);
                                            return;
                                        }
                                    }
                                    for (Minion minion : Minion.getMinions()) {
                                        if (minion.getName().equals(cardName)) {
                                            Minion minion1 = minion.duplicate();
                                            account.getCollection().getMinions().remove(minion1);
                                            return;
                                        }
                                    }
                                    for (UsableItem usableItem : UsableItem.getUsableItems()) {
                                        if (usableItem.getName().equals(cardName)) {
                                            UsableItem usableItem1 = usableItem.duplicate();
                                            account.getCollection().getUsableItems().remove(usableItem1);
                                            return;
                                        }
                                    }
                                    long time = new Date().getTime();
                                    while (new Date().getTime() - time < 1000) ;
                                    account.setMoney(account.getMoney() + max);
                                    auctionMessageSeller.setAccount(account);
                                    account.connection.sendPacket(new Gson().toJson(auctionMessageSeller));
                                }
                                if (account.getAuthToken() == bidMessageMax.getText().getKey()) {
                                    String cardName = auctionMessage.getCardData().split("\\n")[0];
                                    for (Hero hero : Hero.getHeroes()) {
                                        if (hero.getName().equals(cardName)) {
                                            Hero hero1 = hero.duplicate();
                                            account.getCollection().getHeroes().add(hero1);
                                            return;
                                        }
                                    }
                                    for (Spell spell : Spell.getSpells()) {
                                        if (spell.getName().equals(cardName)) {
                                            Spell spell1 = spell.duplicate();
                                            account.getCollection().getSpells().add(spell1);
                                            return;
                                        }
                                    }
                                    for (Minion minion : Minion.getMinions()) {
                                        if (minion.getName().equals(cardName)) {
                                            Minion minion1 = minion.duplicate();
                                            account.getCollection().getMinions().add(minion1);
                                            return;
                                        }
                                    }
                                    for (UsableItem usableItem : UsableItem.getUsableItems()) {
                                        if (usableItem.getName().equals(cardName)) {
                                            UsableItem usableItem1 = usableItem.duplicate();
                                            account.getCollection().getUsableItems().add(usableItem1);
                                            return;
                                        }
                                    }
                                    long time = new Date().getTime();
                                    while (new Date().getTime() - time < 1000) ;
                                    account.setMoney(account.getMoney() - max);
                                    auctionMessageBuyer.setAccount(account);

                                    account.connection.sendPacket(new Gson().toJson(auctionMessageBuyer));

                                }
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
            } catch (IOException e) {
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
            Account.getAccount(user).setOnOff(false);
            Server.getConnections().remove(this);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
