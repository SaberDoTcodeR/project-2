package client;

import server.Connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Properties;

public class Client {

    public static void main(String[] args) throws IOException {
        Properties properties = getProperties();
        int port = getPort(properties.getProperty("port"));
        int defaultPort = 8000;
        Socket socket = null;
        String host = "127.0.0.1";
        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            socket = new Socket(host, defaultPort);
        } finally {
            Connection connection = new Connection(socket);
        }
    }

    private static Properties getProperties() throws IOException {
        Properties properties = new Properties();
        FileInputStream inputStream;
        File file = new File("D:\\associated to com\\javapractices\\FirstPractice" +
                "\\project-2(Phase-3)\\src\\config.properties");
        inputStream = new FileInputStream(file);
        properties.load(inputStream);
        return properties;
    }

    private static int getPort(String port) {
        try {
            return Integer.parseInt(port);
        } catch (Exception e) {
            return 0;
        }
    }
}
