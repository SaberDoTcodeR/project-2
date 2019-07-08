package DuelystClient.Controller;

import DuelystClient.Client;
import DuelystClient.Messages.GameRequest;
import DuelystClient.View.View;
import DuelystClient.model.Account;
import com.google.gson.Gson;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.events.JFXDialogEvent;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.Date;

public class GameModeController {
    private static GameModeController gameModeController;
    public Account opponentAccount;

    public static GameModeController getInstance() {
        return gameModeController;
    }

    public static int MODE = 0;// 0 for HeroMode 1 for OneFlag 2 for SeveralFlag
    @FXML
    public Button mode1Button;
    @FXML
    public Button mode2Button;
    @FXML
    public Button mode3Button;
    @FXML
    public Button mainMenuGameButton;
    public StackPane stackPane;
    public GridPane gridPane;

    public void initialize() {
        if (gameModeController == null)
            gameModeController = this;
    }

    public void mode1BtnActFocus() {
        mode1Button.requestFocus();
    }

    public void mode2BtnActFocus() {
        mode2Button.requestFocus();
    }

    public void mode3BtnActFocus() {
        mode3Button.requestFocus();
    }

    public void mainMenuActFocus() {
        mainMenuGameButton.requestFocus();
    }

    public void mode1BtnAct() {
        if (SingleOrMultiController.singleOrMulti) {
            String musicFile = "out/production/project-2(Phase-3)/DuelystClient/View/button_clicked.wav";
            Media sound = new Media(new File(musicFile).toURI().toString());
            MediaPlayer mediaPlayer;
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setVolume(0.3);
            mediaPlayer.play();
            View.makeBattle();
        } else {
            GameRequest gameRequest = new GameRequest();
            gameRequest.setAuthToken(Account.getLoginAccount().getAuthToken());
            gameRequest.setCancel(false);
            showDialog("WAIT TO FIND SOMEONE TO PLAY :)");
            long time = new Date().getTime();
            while (new Date().getTime() - time < 2000) ;
            Client.connectionToServer.sendPacket(new Gson().toJson(gameRequest));

        }
    }

    public void mode2BtnAct() {
        String musicFile = "out/production/project-2(Phase-3)/DuelystClient/View/button_clicked.wav";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer;
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.3);
        mediaPlayer.play();
    }

    public void mode3BtnAct() {

        String musicFile = "out/production/project-2(Phase-3)/DuelystClient/View/button_clicked.wav";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer;
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.3);
        mediaPlayer.play();
    }

    public void mainMenuAct() {
        View.makeMainMenu();
    }

    public void handleOnKeyPressedMainMenu(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            mainMenuAct();
        }
    }

    public void handleOnKeyPressedMode1(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            MODE = 0;
            mode1BtnAct();
        }
    }

    public void handleOnKeyPressedMode2(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            MODE = 1;
            mode2BtnAct();
        }
    }

    public void handleOnKeyPressedMode3(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            MODE = 2;
            mode3BtnAct();
        }
    }

    public JFXDialog jfxDialog;

    public void showDialog(String string) {
        Platform.runLater(() -> {
            BoxBlur blur = new BoxBlur(5, 5, 10);
            JFXDialogLayout jfxDialogLayout = new JFXDialogLayout();
            JFXButton jfxButton = new JFXButton("CANCEL");
            jfxDialogLayout.setStyle(" -fx-background-color: rgba(0, 0, 0, 0.3);");
            jfxDialog = new JFXDialog(stackPane, jfxDialogLayout, JFXDialog.DialogTransition.TOP);
            jfxButton.getStyleClass().add("dialog-button");
            jfxButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> {
                        GameRequest gameRequest = new GameRequest();
                        gameRequest.setAuthToken(Account.getLoginAccount().getAuthToken());
                        gameRequest.setCancel(true);
                        Client.connectionToServer.sendPacket(new Gson().toJson(gameRequest));
                        jfxDialog.close();
                    }
            );
            jfxDialog.setOnDialogClosed((JFXDialogEvent jfxEvent) -> {

                gridPane.setEffect(null);
            });
            Label label = new Label(string);
            label.setStyle("-fx-font-size: 20px; -fx-text-fill: black");
            jfxDialogLayout.setBody(label);
            jfxDialogLayout.setActions(jfxButton);
            jfxDialogLayout.setActions(jfxButton);
            String musicFile = "out/production/project-2(Phase-3)/DuelystClient/View/error.mp3";
            Media sound = new Media(new File(musicFile).toURI().toString());
            MediaPlayer mediaPlayer;
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setVolume(0.3);
            mediaPlayer.play();
            jfxDialog.show();
            gridPane.setEffect(blur);
        });
    }

    public void showError(String string) {
        Platform.runLater(() -> {
            if (jfxDialog != null)
                jfxDialog.close();
            BoxBlur blur = new BoxBlur(5, 5, 10);
            JFXDialogLayout jfxDialogLayout = new JFXDialogLayout();
            JFXButton jfxButton = new JFXButton("CANCEL");
            jfxDialogLayout.setStyle(" -fx-background-color: rgba(0, 0, 0, 0.3);");
            JFXDialog jfxDialog1 = new JFXDialog(stackPane, jfxDialogLayout, JFXDialog.DialogTransition.TOP);
            jfxButton.getStyleClass().add("dialog-button");
            jfxButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> {
                        jfxDialog1.close();
                    }
            );
            jfxDialog1.setOnDialogClosed((JFXDialogEvent jfxEvent) -> {
                gridPane.setEffect(null);
            });
            Label label = new Label(string);
            label.setStyle("-fx-font-size: 20px; -fx-text-fill: black");
            jfxDialogLayout.setBody(label);
            jfxDialogLayout.setActions(jfxButton);
            jfxDialogLayout.setActions(jfxButton);
            jfxDialog1.show();
            gridPane.setEffect(blur);
        });
    }
}
