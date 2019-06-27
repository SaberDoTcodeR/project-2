package Duelyst.Controller;

import Duelyst.View.View;
import Duelyst.model.Account;
import Duelyst.model.Card.Hero.Hero;
import Duelyst.model.Collection;
import Duelyst.model.Deck;
import Duelyst.model.Save.SaveAccount;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


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

    public void initialize() {
        Gson gson = new Gson();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Duelyst/model/Save/accounts.json"));
            ArrayList<SaveAccount> saveAccounts;
            saveAccounts = gson.fromJson(bufferedReader, new TypeToken<ArrayList<SaveAccount>>(){}.getType());
            for (int i = 0; i < saveAccounts.size(); i++) {
                Account account = new Account(saveAccounts.get(i).user, saveAccounts.get(i).pass);
                account.setMana(saveAccounts.get(i).mana);
                account.setMoney(saveAccounts.get(i).money);
                account.setWins(saveAccounts.get(i).wins);
                Collection collection = new Collection();
                for (int j = 0; j < saveAccounts.get(i).cards.size(); j++) {
                    collection.addToCollection(saveAccounts.get(i).cards.get(j));
                }
                account.setMyCollection(collection);
                for (int j = 0; j < saveAccounts.get(i).decks.size(); j++) {
                    Deck deck = new Deck();
                    deck.setName(saveAccounts.get(i).decks.get(j).name);
                    collection.addDeck(deck);
                    for (int k = 0; k < saveAccounts.get(i).decks.get(j).cards.size(); k++) {
                        collection.addToDeck(saveAccounts.get(i).decks.get(j).cards.get(k), deck.getName());
                    }
                }
                for (Deck deck:collection.getDecks()){
                    if (deck.getName().equals(saveAccounts.get(i).mainDeck)){
                        account.setMainDeck(deck);
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
