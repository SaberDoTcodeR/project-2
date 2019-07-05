package DuelystClient.View;

import DuelystClient.Client;
import DuelystClient.Controller.LoginController;
import DuelystClient.Controller.MainMenuController;
import DuelystClient.Controller.ScoreBoardController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.IOException;

import static DuelystClient.Client.primaryStage;

public class View {
    static Scene scene = new Scene(new GridPane());
    public static void makeLoginScene() {
        Platform.runLater(() -> {
            GridPane root = null;
            try {
                root = FXMLLoader.load(LoginController.class.getResource("loginMenu.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            scene.setRoot(root);
            scene.setCursor(new ImageCursor(new Image("DuelystClient/css/OzFOdVG.png")));
            scene.getStylesheets().clear();
            scene.getStylesheets().add(Client.class.getResource("css/css.css").toExternalForm());
            primaryStage.setScene(scene);
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
            scene.setRoot(root);

            scene.setCursor(new ImageCursor(new Image("DuelystClient/css/OzFOdVG.png")));
            scene.getStylesheets().clear();
            scene.getStylesheets().add(Client.class.getResource("css/css2.css").toExternalForm());
            primaryStage.setScene(scene);
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
            scene.setRoot(root);

            scene.setCursor(new ImageCursor(new Image("DuelystClient/css/OzFOdVG.png")));
            scene.getStylesheets().clear();
            scene.getStylesheets().add(Client.class.getResource("css/css3.css").toExternalForm());
            primaryStage.setScene(scene);
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
        scene.setRoot(root);

        scene.setCursor(new ImageCursor(new Image("DuelystClient/css/OzFOdVG.png")));
        scene.getStylesheets().clear();
        scene.getStylesheets().add(Client.class.getResource("css/css4.css").toExternalForm());
        primaryStage.setScene(scene);
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
        scene.setRoot(root);

        scene.setCursor(new ImageCursor(new Image("DuelystClient/css/OzFOdVG.png")));
        scene.getStylesheets().clear();
        scene.getStylesheets().add(Client.class.getResource("css/css5.css").toExternalForm());
        primaryStage.setScene(scene);
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
        scene.setRoot(root);

        scene.setCursor(new ImageCursor(new Image("DuelystClient/css/OzFOdVG.png")));
        scene.getStylesheets().clear();
        scene.getStylesheets().add(Client.class.getResource("css/css5.css").toExternalForm());
        primaryStage.setScene(scene);
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
        scene.setRoot(root);

        scene.setCursor(new ImageCursor(new Image("DuelystClient/css/OzFOdVG.png")));
        scene.getStylesheets().clear();
        scene.getStylesheets().add(Client.class.getResource("css/css6.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.setResizable(false);


    }

    public static void makeScoreBoardScene() {
        AnchorPane root = null;
        try {
            root = FXMLLoader.load(ScoreBoardController.class.getResource("scoreBoard.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scoreBoardScene = new Scene(root);

        scoreBoardScene.setCursor(new ImageCursor(new Image("DuelystClient/css/OzFOdVG.png")));
        scoreBoardScene.getStylesheets().add(Client.class.getResource("css/css7.css").toExternalForm());
        primaryStage.setScene(scoreBoardScene);
        primaryStage.setFullScreen(true);
        primaryStage.setResizable(false);
    }
}
