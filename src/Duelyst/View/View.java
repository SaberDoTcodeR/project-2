package Duelyst.View;

import Duelyst.Controller.LoginController;
import Duelyst.Controller.MainMenuController;
import Duelyst.Main;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Screen;

import java.io.IOException;

import static Duelyst.Main.primaryStage;

public class View {
    public static void makeLoginScene() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                GridPane root = null;
                try {
                    root = FXMLLoader.load(LoginController.class.getResource("loginMenu.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene loginScene = new Scene(root);
                loginScene.setCursor(new ImageCursor(new Image("Duelyst/css/OzFOdVG.png")));
                loginScene.getStylesheets().add(Main.class.getResource("css/css.css").toExternalForm());
                primaryStage.setScene(loginScene);
                primaryStage.setFullScreen(true);
                primaryStage.setResizable(false);

            }
        });

    }

    public static void makeMainMenu() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                GridPane root = null;
                try {
                    root = FXMLLoader.load(MainMenuController.class.getResource("mainMenu.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene mainMenuScene = new Scene(root);

                mainMenuScene.setCursor(new ImageCursor(new Image("Duelyst/css/OzFOdVG.png")));
                mainMenuScene.getStylesheets().add(Main.class.getResource("css/css2.css").toExternalForm());
                primaryStage.setScene(mainMenuScene);
                primaryStage.setFullScreen(true);
                primaryStage.setResizable(false);

            }
        });

    }
}
