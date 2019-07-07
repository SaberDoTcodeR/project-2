package DuelystClient.Controller;

import DuelystClient.Client;
import DuelystClient.Messages.ScoreBoardMessage;
import DuelystClient.View.View;
import DuelystClient.model.Account;
import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

public class ScoreBoardController implements Initializable {
    private static ScoreBoardController scoreBoardController;

    public static ScoreBoardController getInstance() {
        return scoreBoardController;
    }

    @FXML
    Button loginMenuButton;
    @FXML
    private TableView<Account> tableView;
    @FXML
    private TableColumn<Account, String> userName;
    @FXML
    private TableColumn<Account, String> wins;
    @FXML
    private TableColumn<Account, String> onOrOff;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        scoreBoardController = this;
        userName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        wins.setCellValueFactory(new PropertyValueFactory<>("wins"));
        onOrOff.setCellValueFactory(new PropertyValueFactory<>("onOrOff"));
        Gson gson = new Gson();
        ScoreBoardMessage sbm = new ScoreBoardMessage(46723);
        Client.connectionToServer.sendPacket(gson.toJson(sbm));


    }

    public void handleOnKeyPressedLoginMenu(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            loginAct();
        }
    }

    public void loginAct() {
        View.makeLoginScene();
    }

    public void loginBtnActFocus() {
        loginMenuButton.requestFocus();
    }

    public void loginBtnActNotFocus() {
        loginMenuButton.setId("");
    }

    public void initTable(ScoreBoardMessage message) {
        for (int i = 0; i < message.getAccounts().size(); i++) {
            message.getAccounts().get(i).setOnOrOff();
        }
        Collections.sort(message.getAccounts(), Collections.reverseOrder());
        tableView.getItems().setAll(FXCollections.observableArrayList(message.getAccounts()));
    }
}
