package DuelystClient;

import DuelystClient.Controller.CollectionController;
import DuelystClient.Controller.LoginController;
import DuelystClient.Controller.ScoreBoardController;
import DuelystClient.Controller.ShopController;
import DuelystClient.Messages.*;
import DuelystClient.View.View;
import DuelystClient.model.Account;
import DuelystClient.model.Card.Card;
import DuelystClient.model.Card.Hero.CustomHero;
import DuelystClient.model.Card.Minion.CustomMinion;
import com.google.gson.Gson;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Collections;
import java.util.Date;
import java.util.Properties;

public class Connection implements Runnable {
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private Socket socket;
    private boolean running;
    private volatile boolean closedManual;

    public Connection(Socket socket) {
        this.socket = socket;
        try {

            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(this).start();
    }
    public  volatile boolean  first = true;
    @Override
    public void run() {
        running = true;
        Gson gson = new Gson();

        while (running && !closedManual) {
            String string = null;
            try {
                while (string == null)
                    string = (String) inputStream.readObject();
            } catch (IOException e) {
                while (!closedManual) {
                    Properties properties = null;
                    try {
                        properties = Client.getProperties();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    int port = Client.getPort(properties.getProperty("port"));
                    int defaultPort = 8000;
                    Socket socket = null;
                    String host = "localhost";
                    try {
                        socket = new Socket(host, port);
                        View.makeLoginScene();
                        Client.connectionToServer = new Connection(socket);
                    } catch (IOException e1) {
                        try {
                            socket = new Socket(host, defaultPort);
                        } catch (IOException e2) {
                            continue;
                        }
                        View.makeLoginScene();
                        Client.connectionToServer = new Connection(socket);
                    }
                    break;
                }
            } catch (ClassNotFoundException e) {

            }

            System.out.println(string + "recieved");
            if (string.contains("WRONG_PASSWORD")) {
                LoginController.getInstance().wrongPassStyle();
            } else if (string.contains("NO_SUCH_USER_EXIST")) {
                LoginController.getInstance().wrongUserStyle();
            } else if (string.contains("75453")) {
                Account.setLoginAccount(gson.fromJson(string, AccountPacket.class).getAccount());
                View.makeMainMenu();
            } else if (string.contains("USER_ALREADY_CREATED")) {
                LoginController.getInstance().wrongUserStyle();
            } else if (string.contains("53645")) {
                first=true;
                System.out.println("auction started");
                AuctionStartMessage auctionStartMessage = gson.fromJson(string, AuctionStartMessage.class);
                if (Account.getLoginAccount().getAuthToken() != auctionStartMessage.getStarterAuthToken())
                    CollectionController.getInstance().showAuctionDialog(auctionStartMessage.getCardData());
            } else if (string.contains("21432")) {
                CustomMessage customMessage = gson.fromJson(string, CustomMessage.class);
                System.out.println("heyeeeeee");
                if (Card.getCard(customMessage.getName()) == null) {
                    if (customMessage.isType()) {
                        CustomHero customHero = new CustomHero(customMessage.getName(), customMessage.getAp()
                                , customMessage.getHp(), customMessage.getCost(), customMessage.getTypeOfRange(), customMessage.getRange(),
                                new Image("DuelystClient/css/unit_gifs/boss_andromeda_breathing.gif"), customMessage.getCoolDownTime(), customMessage.getMana());
                        ShopController.getInstance().addCustomHero(customMessage, customHero);
                    } else {
                        CustomMinion customMinion = new CustomMinion(customMessage.getName(), customMessage.getAp()
                                , customMessage.getHp(), customMessage.getCost(), customMessage.getTypeOfRange(), customMessage.getRange(),
                                new Image("DuelystClient/css/unit_gifs/boss_andromeda_breathing.gif"), customMessage.getMana(), customMessage.getActiveTime());
                        ShopController.getInstance().addCustomMinion(customMessage, customMinion);
                    }
                }
            } else if (string.contains("43123")) {
                ShopMessage shopMessage1 = gson.fromJson(string, ShopMessage.class);
                ShopController.getInstance().errorOfNotOwned(shopMessage1);
            } else if (string.contains("64532")) {
                ShopMessage shopMessage1 = gson.fromJson(string, ShopMessage.class);
                ShopController.getInstance().errorOfBuy(shopMessage1);

            } else if (string.contains("34121")) {
                if (first) {
                    first = false;
                    ShopInitializeMessage initializeMessage = gson.fromJson(string, ShopInitializeMessage.class);
                    ShopController.getInstance().shopFirstInitialize(initializeMessage);

                } else {
                    ShopInitializeMessage initializeMessage2 = gson.fromJson(string, ShopInitializeMessage.class);
                    ShopController.getInstance().shopNotFirstInitialize(initializeMessage2);

                }
            } else if (string.contains("52341")) {
                AuctionMessage accountUpdated = gson.fromJson(string, AuctionMessage.class);
                Account.setLoginAccount(accountUpdated.getAccount());
                System.out.println(Account.getLoginAccount().getCollection().getHeroes().size());
                first=true;
                View.makeMainMenu();

            } else if (string.contains("53412")) {
                BidMessage bidMessage = gson.fromJson(string, BidMessage.class);
                CollectionController.getInstance().setMaxBet(bidMessage);
                first=true;
            } else if (string.contains("46723")) {
                ScoreBoardMessage message = gson.fromJson(string, ScoreBoardMessage.class);
                ScoreBoardController.getInstance().initTable(message);
                first=true;

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

    public Object readPacket() {
        try {
            return inputStream.readObject();
        } catch (EOFException | SocketException e) {
            while (!closedManual) {
                Properties properties = null;
                try {
                    properties = Client.getProperties();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                int port = Client.getPort(properties.getProperty("port"));
                int defaultPort = 8000;
                Socket socket = null;
                String host = "localhost";
                try {
                    socket = new Socket(host, port);
                    View.makeLoginScene();
                    Client.connectionToServer = new Connection(socket);
                } catch (IOException e1) {
                    try {
                        socket = new Socket(host, defaultPort);
                    } catch (IOException e2) {
                        continue;
                    }
                    View.makeLoginScene();
                    Client.connectionToServer = new Connection(socket);
                }
                break;
            }

        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }
        return null;
    }

    public void close() {
        try {
            inputStream.close();
            outputStream.close();
        } catch (EOFException | SocketException e) {
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}