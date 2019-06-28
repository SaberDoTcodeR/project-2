package DuelystClient.View;

import DuelystClient.Client;
import DuelystClient.Controller.LoginController;
import DuelystClient.Controller.MainMenuController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.IOException;

import static DuelystClient.Client.primaryStage;

public class View {
    public static void makeLoginScene() {
        Platform.runLater(() -> {
            GridPane root = null;
            try {
                root = FXMLLoader.load(LoginController.class.getResource("loginMenu.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            Scene loginScene = new Scene(root);
            loginScene.setCursor(new ImageCursor(new Image("DuelystClient/css/OzFOdVG.png")));
            loginScene.getStylesheets().add(Client.class.getResource("css/css.css").toExternalForm());
            primaryStage.setScene(loginScene);
            primaryStage.setFullScreen(true);
            primaryStage.setResizable(false);

        });

    }

    public static void makeMainMenu() {
        Platform.runLater(() -> {
            GridPane root = null;
            try {
                root = FXMLLoader.load(MainMenuController.class.getResource("mainMenu.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene mainMenuScene = new Scene(root);

            mainMenuScene.setCursor(new ImageCursor(new Image("DuelystClient/css/OzFOdVG.png")));
            mainMenuScene.getStylesheets().add(Client.class.getResource("css/css2.css").toExternalForm());
            primaryStage.setScene(mainMenuScene);
            primaryStage.setFullScreen(true);
            primaryStage.setResizable(false);

        });

    }

    public static void makeShopMenu() {
        Platform.runLater(() -> {
            StackPane root = null;
            try {
                root = FXMLLoader.load(MainMenuController.class.getResource("shopMenu.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene mainMenuScene = new Scene(root);

            mainMenuScene.setCursor(new ImageCursor(new Image("DuelystClient/css/OzFOdVG.png")));
            mainMenuScene.getStylesheets().add(Client.class.getResource("css/css3.css").toExternalForm());
            primaryStage.setScene(mainMenuScene);
            primaryStage.setFullScreen(true);
            primaryStage.setResizable(false);

        });

    }

    public static void makeCollectionMenu() {

        StackPane root = null;
        try {
            root = FXMLLoader.load(MainMenuController.class.getResource("collectionMenu.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene collectionScene = new Scene(root);

        collectionScene.setCursor(new ImageCursor(new Image("DuelystClient/css/OzFOdVG.png")));
        collectionScene.getStylesheets().add(Client.class.getResource("css/css4.css").toExternalForm());
        primaryStage.setScene(collectionScene);
        primaryStage.setFullScreen(true);
        primaryStage.setResizable(false);


    }

    public static void makeSingleOrMultiMenu() {

        GridPane root = null;
        try {
            root = FXMLLoader.load(MainMenuController.class.getResource("singleOrMultiMenu.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene singleOrMultiScene = new Scene(root);

        singleOrMultiScene.setCursor(new ImageCursor(new Image("DuelystClient/css/OzFOdVG.png")));
        singleOrMultiScene.getStylesheets().add(Client.class.getResource("css/css5.css").toExternalForm());
        primaryStage.setScene(singleOrMultiScene);
        primaryStage.setFullScreen(true);
        primaryStage.setResizable(false);


    }

    public static void makeModeMenuMenu() {

        GridPane root = null;
        try {
            root = FXMLLoader.load(MainMenuController.class.getResource("gameModeMenu.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene modeMenuScene = new Scene(root);

        modeMenuScene.setCursor(new ImageCursor(new Image("DuelystClient/css/OzFOdVG.png")));
        modeMenuScene.getStylesheets().add(Client.class.getResource("css/css5.css").toExternalForm());
        primaryStage.setScene(modeMenuScene);
        primaryStage.setFullScreen(true);
        primaryStage.setResizable(false);


    }

    public static void makeBattle() {

        StackPane root = null;
        try {
            root = FXMLLoader.load(MainMenuController.class.getResource("battle.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene modeMenuScene = new Scene(root);

        modeMenuScene.setCursor(new ImageCursor(new Image("DuelystClient/css/OzFOdVG.png")));
        modeMenuScene.getStylesheets().add(Client.class.getResource("css/css6.css").toExternalForm());
        primaryStage.setScene(modeMenuScene);
        primaryStage.setFullScreen(true);
        primaryStage.setResizable(false);


    }
}
