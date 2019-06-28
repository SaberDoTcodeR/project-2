package server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;

public class Server {

    private static ArrayList<Connection> connections = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        FileInputStream inputStream;
        try {
            URL url = Server.class.getResource("server/config.properties");
            inputStream = new FileInputStream(new File(url.getPath()));
            properties.load(inputStream);
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
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                Connection connection = new Connection(socket);
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
