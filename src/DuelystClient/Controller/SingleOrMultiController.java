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
import javafx.util.Pair;
import org.w3c.dom.Text;

public class SingleOrMultiController {
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

        new Thread(() -> {
            while (true) {
                String str = null;
                while (str == null)
                    str = (String) Client.connectionToServer.readPacket();
                if (str.contains("41543")) {
                    addText(new Gson().fromJson(str, TextMessage.class));
                }
            }
        }).start();

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

        View.makeModeMenuMenu();
    }

    public void multiGameBtnAct() {
        singleOrMulti = false;
        View.makeModeMenuMenu();
    }

    public void mainMenuAct() {
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

    private void addText(TextMessage textMessage) {
        textArea.appendText(textMessage.getText().getKey() + ":" + textMessage.getText().getValue() + "\n");
    }
}
