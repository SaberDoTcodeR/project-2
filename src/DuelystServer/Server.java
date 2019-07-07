package DuelystServer;

import DuelystServer.Controller.ShopController;
import DuelystServer.View.View;
import DuelystServer.messages.ShopMessage;
import DuelystServer.model.Account;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Queue;

public class Server extends Application {
    public static volatile Queue<Account> gameQueue = new ArrayDeque<>();
    private static ArrayList<Connection> connections = new ArrayList<>();
    public static Stage primaryStage1;

    public static void main(String[] args) {
        launch(args);
    }

    private static int getPort(String port) {
        try {
            return Integer.parseInt(port);
        } catch (Exception e) {
            return 0;
        }
    }

    public static ArrayList<Connection> getConnections() {
        return connections;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ShopMessage.setNumberOfCardsInShop();
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/DuelystServer/config.properties"));
            primaryStage1 = primaryStage;
            primaryStage1.setFullScreen(true);
            primaryStage1.setResizable(false);
            View.makeShopMenu();
            primaryStage1.show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int port = getPort(properties.getProperty("port"));
        int defaultPort = 8000;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            serverSocket = new ServerSocket(defaultPort);
        }
        ServerSocket finalServerSocket = serverSocket;
        new Thread(() -> {
            while (true) {
                try {
                    Socket socket = finalServerSocket.accept();
                    System.out.println("connection created");
                    Connection connection = new Connection(socket);
                    ShopController.getInstance().sendMessage(connection);
                    connections.add(connection);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}