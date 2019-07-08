package DuelystClient.Controller;

import DuelystClient.Client;
import DuelystClient.Messages.TextMessage;
import DuelystClient.View.View;
import DuelystClient.model.Account;
import DuelystServer.Connection;
import DuelystServer.Server;
import com.google.gson.Gson;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Pair;
import org.w3c.dom.Text;

import java.io.File;

public class SingleOrMultiController {
    private static SingleOrMultiController singleOrMultiController;

    public static SingleOrMultiController getInstance() {
        return singleOrMultiController;
    }

    public static boolean singleOrMulti = true;
    @FXML
    public Button singleGameButton;
    @FXML
    public Button multiGameButton;
    @FXML
    public Button mainMenuGameButton;
    public TextField textBox;
    public JFXTextArea textArea;

    public void initialize() {
        singleOrMultiController = this;


    }

    public void singleGameBtnActFocus() {
        singleGameButton.requestFocus();
    }

    public void multiGameBtnActFocus() {
        multiGameButton.requestFocus();
    }

    public void mainMenuActFocus() {
        mainMenuGameButton.requestFocus();
    }

    public void singleGameBtnAct() {
        singleOrMulti = true;
        String musicFile = "out/production/project-2(Phase-3)/DuelystClient/View/button_clicked.wav";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer;
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.3);
        mediaPlayer.play();
        View.makeModeMenuMenu();
    }

    public void multiGameBtnAct() {
        String musicFile = "out/production/project-2(Phase-3)/DuelystClient/View/button_clicked.wav";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer;
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.3);
        mediaPlayer.play();
        singleOrMulti = false;
        View.makeModeMenuMenu();
    }

    public void mainMenuAct() {
        String musicFile = "out/production/project-2(Phase-3)/DuelystClient/View/button_clicked.wav";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer;
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.3);
        mediaPlayer.play();
        View.makeMainMenu();
    }

    public void handleOnKeyPressedMainMenu(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            mainMenuAct();
        }
    }

    public void handleOnKeyPressedSingleGame(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            singleGameBtnAct();
        }
    }

    public void handleOnKeyPressedMultiGame(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            multiGameBtnAct();
        }
    }

    public void sendMessageAction(ActionEvent actionEvent) {
        try {
            Gson gson = new Gson();
            TextMessage textMessage = new TextMessage();
            if (textBox.getText().equals(""))
                return;
            textMessage.setText(new Pair<>(Account.getLoginAccount().getUserName(), textBox.getText()));

            Client.connectionToServer.sendPacket(gson.toJson(textMessage));
            textBox.clear();
        } catch (Exception e) {
            textArea.appendText("Failed to send\n");
        }
    }

    public void addText(TextMessage textMessage) {
        textArea.appendText(textMessage.getText().getKey() + ":" + textMessage.getText().getValue() + "\n");
    }
}
