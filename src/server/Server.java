package server;

import java.io.File;
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
        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(new File("D:\\associated to com\\javapractices\\FirstPractice\\project-2(Phase-3)\\src\\config.properties"));
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
        while (true){
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
        try{
            return Integer.parseInt(port);
        } catch (Exception e){
            return 0;
        }
    }

    public static ArrayList<Connection> getConnections() {
        return connections;
    }

}
