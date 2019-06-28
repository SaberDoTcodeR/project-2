package DuelystServer;

import DuelystServer.model.Account;
import com.gilecode.yagson.YaGson;
import com.gilecode.yagson.YaGsonBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Properties;

public class Server {

    private static ArrayList<Connection> connections = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/DuelystServer/config.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int port = getPort(properties.getProperty("port"));
        int defaultPort = 8000;
        ServerSocket serverSocket;
//        try {
//            serverSocket = new ServerSocket(6000);
//        } catch (IOException e) {
//            serverSocket = new ServerSocket(defaultPort);
//        }
        serverSocket = new ServerSocket(6000);
        while (true) {
            System.out.println("ta ghable try");
            try {
                Socket socket = serverSocket.accept();
                System.out.println("connection created");
                Connection connection = new Connection(socket);
                System.out.println("connection created");
                connections.add(connection);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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

}
