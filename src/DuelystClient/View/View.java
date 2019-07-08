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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.IOException;

import static DuelystClient.Client.primaryStage;

public class View {
    static Scene scene = new Scene(new GridPane());

    static MediaPlayer mediaPlayer;
    public static void makeLoginScene() {
        Platform.runLater(() -> {
            String musicFile = "out/production/project-2(Phase-3)/DuelystClient/View/music_loginMenu.m4a";
            Media sound = new Media(new File(musicFile).toURI().toString());
            if (mediaPlayer != null)
                mediaPlayer.stop();
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setVolume(0.1);
            mediaPlayer.setAutoPlay(true);
            mediaPlayer.play();
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
            String musicFile = "out/production/project-2(Phase-3)/DuelystClient/View/music_mainMenu.m4a";
            Media sound = new Media(new File(musicFile).toURI().toString());
            if (mediaPlayer != null)
                mediaPlayer.stop();
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setAutoPlay(true);
            mediaPlayer.setVolume(0.05);
            mediaPlayer.play();
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
            Client.connectionToServer.first = true;
        });

    }

    public static void makeShopMenu() {
        Platform.runLater(() -> {
            String musicFile = "out/production/project-2(Phase-3)/DuelystClient/View/music_shopMenu.m4a";
            Media sound = new Media(new File(musicFile).toURI().toString());
            if (mediaPlayer != null)
                mediaPlayer.stop();
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setAutoPlay(true);
            mediaPlayer.setVolume(0.3);
            mediaPlayer.play();
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

        String musicFile = "out/production/project-2(Phase-3)/DuelystClient/View/music_collectionMenu.m4a";
        Media sound = new Media(new File(musicFile).toURI().toString());
        if (mediaPlayer != null)
            mediaPlayer.stop();
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(0.05);
        mediaPlayer.play();
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

        String musicFile = "out/production/project-2(Phase-3)/DuelystClient/View/music_playMode.m4a";
        Media sound = new Media(new File(musicFile).toURI().toString());
        if (mediaPlayer != null)
            mediaPlayer.stop();
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(0.05);
        mediaPlayer.play();
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

        String musicFile = "out/production/project-2(Phase-3)/DuelystClient/View/music_challengeMode.m4a";
        Media sound = new Media(new File(musicFile).toURI().toString());
        if (mediaPlayer != null)
            mediaPlayer.stop();
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(0.05);
        mediaPlayer.play();
        StackPane root = null;
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

        String musicFile = "out/production/project-2(Phase-3)/DuelystClient/View/music_battlemap_duskfall.m4a";
        Media sound = new Media(new File(musicFile).toURI().toString());
        if (mediaPlayer != null)
            mediaPlayer.stop();
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(0.05);
        mediaPlayer.play();
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

        String musicFile = "out/production/project-2(Phase-3)/DuelystClient/View/music_scoreBoard.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        if (mediaPlayer != null)
            mediaPlayer.stop();
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(0.2);
        mediaPlayer.play();
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

    public static void makeBattleOnline() {
        Platform.runLater(() -> {
            StackPane root = null;
            try {
                root = FXMLLoader.load(MainMenuController.class.getResource("battleOnline.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            scene.setRoot(root);

            scene.setCursor(new ImageCursor(new Image("DuelystClient/css/OzFOdVG.png")));
            scene.getStylesheets().clear();
            scene.getStylesheets().add(Client.class.getResource("css/css6.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setFullScreen(true);
            primaryStage.setResizable(true);
        });

    }
}
