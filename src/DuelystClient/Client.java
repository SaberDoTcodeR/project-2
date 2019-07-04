package DuelystClient;

import DuelystClient.View.View;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.util.Properties;

public class Client extends Application {

    public static Stage primaryStage;
    public static Connection connectionToServer;

    public static Properties getProperties() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/DuelystClient/config.properties"));
        return properties;
    }

    public static int getPort(String port) {
        try {
            return Integer.parseInt(port);
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public void start(Stage primaryStage1) throws Exception {
        Properties properties = getProperties();
        int port = getPort(properties.getProperty("port"));
        int defaultPort = 8000;
        Socket socket = null;
        primaryStage = primaryStage1;
        primaryStage.setFullScreen(true);
        primaryStage.setResizable(false);
        String host = "localhost";
        try {
            socket = new Socket(host, port);
            View.makeLoginScene();
            primaryStage.show();
            connectionToServer = new Connection(socket);
        } catch (IOException e) {
            try {
                socket = new Socket(host, defaultPort);
                View.makeLoginScene();
                primaryStage.show();
                connectionToServer = new Connection(socket);
            }catch (IOException e1){
                this.start(primaryStage1);
            }

        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
