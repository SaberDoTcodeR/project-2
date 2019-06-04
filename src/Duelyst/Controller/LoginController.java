package Duelyst.Controller;

import Duelyst.Main;
import Duelyst.View.View;
import Duelyst.model.Account;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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


    public void exitGameBtn() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void loginBtnAct() {
        passField.getStyleClass().remove("wrongPassword");
        userField.getStyleClass().remove("wrongPassword");
        if (Account.authorize(userField.getText(), passField.getText())) {
            View.makeMainMenu();
        } else {
            userField.getStyleClass().add("wrongPassword");
            passField.getStyleClass().add("wrongPassword");
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
    public void signUpBtnAct() {

        passField.getStyleClass().remove("wrongPassword");
        userField.getStyleClass().remove("wrongPassword");
        if (!Account.existThisUser(userField.getText()) && !userField.getText().equals("") && !passField.getText().equals("")) {

            Account.setLoginAccount(new Account(userField.getText(), passField.getText()));
            View.makeMainMenu();
        } else if (!userField.getText().equals("") && !passField.getText().equals("")) {
            userField.getStyleClass().add("wrongPassword");
        } else {
            if (userField.getText().equals("")) {
                userField.getStyleClass().add("wrongPassword");
            }
            if (passField.getText().equals("")) {
                passField.getStyleClass().add("wrongPassword");
            }
        }
    }
}
