package DuelystClient.Controller;

import DuelystClient.Client;
import DuelystClient.Messages.AccountMessage;
import DuelystClient.View.View;
import DuelystClient.model.Account;
import DuelystClient.model.Card.Hero.Hero;
import DuelystClient.model.Card.Minion.Minion;
import DuelystClient.model.Card.Spell.Spell;
import DuelystClient.model.Item.UsableItem.UsableItem;
import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginController {
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
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void loginBtnAct() {
        userField.getStyleClass().remove("wrongPassword");
        passField.getStyleClass().remove("wrongPassword");
        if (!userField.getText().equals("") && !passField.getText().equals("")) {
            Gson gson = new Gson();
            AccountMessage accountMessage = new AccountMessage(false, userField.getText(), passField.getText(), "AccountMessage",0);
            Client.connectionToServer.sendPacket(gson.toJson(accountMessage));

            new Thread(() -> {
                Object object = null;
                while (object == null)
                    object = Client.connectionToServer.readPacket();
                if (((String) object).contains("WRONG_PASSWORD")) {
                    passField.getStyleClass().add("wrongPassword");
                } else if (((String) object).contains("No_SUCH_USER_EXIST")) {
                    userField.getStyleClass().add("wrongPassword");
                } else if (((String) object).contains("money")) {
                    Account.setLoginAccount(gson.fromJson((String) object, Account.class));
                    View.makeMainMenu();
                }
            }).start();
        } else {
            if (userField.getText().equals("")) {
                userField.getStyleClass().add("wrongPassword");
            }
            if (passField.getText().equals("")) {
                passField.getStyleClass().add("wrongPassword");
            }
        }
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
        passField.getStyleClass().remove("wrongPassword");
        userField.getStyleClass().remove("wrongPassword");
        if (!userField.getText().equals("") && !passField.getText().equals("")) {
            Gson gson = new Gson();
            AccountMessage accountMessage = new AccountMessage(true, userField.getText(), passField.getText(), "AccountMessage", 0);
            Client.connectionToServer.sendPacket(gson.toJson(accountMessage));

            new Thread(() -> {
                Object object = null;
                while (object == null)
                    object = Client.connectionToServer.readPacket();
                if (((String) object).contains("USER_ALREADY_CREATED")) {
                    userField.getStyleClass().add("wrongPassword");
                } else if (((String) object).contains("money")) {
                    Account.setLoginAccount(gson.fromJson((String) object, Account.class));
                    View.makeMainMenu();
                }
            }).start();
        } else {
            if (userField.getText().equals("")) {
                userField.getStyleClass().add("wrongPassword");
            }
            if (passField.getText().equals("")) {
                passField.getStyleClass().add("wrongPassword");
            }
        }
    }

    public void scoreBoardBtn() {
        View.makeScoreBoardScene();
    }
}
