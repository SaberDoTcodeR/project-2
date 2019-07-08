package DuelystClient.Controller;

import DuelystClient.Client;
import DuelystClient.Messages.AccountMessage;
import DuelystClient.Messages.helloMessage;
import DuelystClient.View.View;
import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class LoginController {
    private static LoginController loginController;

    public static LoginController getInstance() {
        return loginController;
    }

    @FXML
    GridPane gridPane;
    @FXML
    Button exitButton;
    @FXML
    Button loginBtn;
    @FXML
    Button signUpBtn;
    @FXML
    Button scoreBoardButton;
    @FXML
    TextField userField;
    @FXML
    TextField passField;

    public void initialize() {
        loginController = this;
        Gson gson = new Gson();
        Client.connectionToServer.sendPacket(gson.toJson(new helloMessage()));

    }

    public void handleOnKeyPressedExit(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            this.exitGameBtn();
        } else if (event.getCode().equals(KeyCode.DOWN)) {
            userField.requestFocus();
        }
    }

    public void handleOnKeyPressedLogin(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            this.loginBtnAct();
        } else if (event.getCode().equals(KeyCode.UP)) {
            passField.requestFocus();
        }

    }

    public void handleOnKeyPressedSignUp(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            this.signUpBtnAct();
        }

    }

    public void handleOnKeyPressedPass(KeyEvent event) {
        if (event.getCode().equals(KeyCode.DOWN)) {
            loginBtn.requestFocus();
        } else if (event.getCode().equals(KeyCode.UP)) {
            userField.requestFocus();
        }
    }

    public void handleOnKeyPressedUser(KeyEvent event) {
        if (event.getCode().equals(KeyCode.DOWN)) {
            passField.requestFocus();
        } else if (event.getCode().equals(KeyCode.UP)) {
            exitButton.requestFocus();
        }
    }

    public void handleOnKeyPressedScoreBoard(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            this.scoreBoardBtn();
        }
    }

    public void exitGameBtn() {
        playSound();
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void loginBtnAct() {
        playSound();
        userField.getStyleClass().remove("wrongPassword");
        passField.getStyleClass().remove("wrongPassword");
        if (!userField.getText().equals("") && !passField.getText().equals("")) {
            Gson gson = new Gson();
            AccountMessage accountMessage = new AccountMessage(false, userField.getText(), passField.getText(), "AccountMessage", 0);
            Client.connectionToServer.sendPacket(gson.toJson(accountMessage));
        } else {
            if (userField.getText().equals("")) {
                wrongUserStyle();
            }
            if (passField.getText().equals("")) {
                wrongPassStyle();
            }
        }
    }

    public void wrongPassStyle() {
        passField.getStyleClass().add("wrongPassword");
    }

    public void wrongUserStyle() {
        userField.getStyleClass().add("wrongPassword");
    }

    public void loginBtnActFocus() {
        loginBtn.requestFocus();
    }

    public void signUpBtnActFocus() {
        signUpBtn.requestFocus();
    }

    public void exitBtnActFocus() {
        exitButton.requestFocus();
    }

    public void scoreBoardBtnActFocus() {
        scoreBoardButton.requestFocus();
    }

    public void signUpBtnAct() {
        playSound();
        passField.getStyleClass().remove("wrongPassword");
        userField.getStyleClass().remove("wrongPassword");
        if (!userField.getText().equals("") && !passField.getText().equals("")) {
            Gson gson = new Gson();
            AccountMessage accountMessage = new AccountMessage(true, userField.getText(), passField.getText(), "AccountMessage", 0);
            Client.connectionToServer.sendPacket(gson.toJson(accountMessage));
        } else {
            if (userField.getText().equals("")) {
                wrongUserStyle();
            }
            if (passField.getText().equals("")) {
                wrongPassStyle();
            }
        }
    }

    public void scoreBoardBtn() {
        playSound();
        View.makeScoreBoardScene();
    }

    private void playSound() {
        MainMenuController.playSound();
    }
}
