package DuelystClient.Controller;

import DuelystClient.Client;
import DuelystClient.Messages.AccountMessage;
import DuelystClient.View.View;
import DuelystClient.model.Account;
import DuelystClient.model.Collection;
import DuelystClient.model.Deck;
import DuelystClient.model.ErrorType;
import DuelystClient.model.Save.SaveAccount;
import com.gilecode.yagson.YaGson;
import com.gilecode.yagson.YaGsonBuilder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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
            BufferedReader bufferedReader = new BufferedReader(new FileReader("DuelystClient/model/Save/saveaccount.json"));
            ArrayList<SaveAccount> saveAccounts;
            saveAccounts = gson.fromJson(bufferedReader, new TypeToken<ArrayList<SaveAccount>>() {
            }.getType());
            if (saveAccounts != null) {
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
                    for (Deck deck : collection.getDecks()) {
                        if (deck.getName().equals(saveAccounts.get(i).mainDeck)) {
                            account.setMainDeck(deck);
                            break;
                        }
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
        if (!userField.getText().equals("") && !passField.getText().equals("")) {
            YaGson yaGson = new YaGsonBuilder().create();
            AccountMessage accountMessage = new AccountMessage(true, userField.getText(), passField.getText());
            Client.connectionToServer.sendPacket(yaGson.toJson(accountMessage));

            new Thread(new Runnable() {
                @Override
                public void run() {
                    Object object = null;
                    while (object == null)
                        object = Client.connectionToServer.readPacket();

                    object = yaGson.fromJson((String) object, Object.class);
                    if (object.getClass().getSimpleName().equals("ErrorType")) {
                        userField.getStyleClass().add("wrongPassword");
                    } else if (object.getClass().getSimpleName().equals("Account")) {

                    }
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
}
