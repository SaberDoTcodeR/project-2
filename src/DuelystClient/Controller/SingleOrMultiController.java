package DuelystClient.Controller;

import DuelystClient.View.View;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class SingleOrMultiController {
    @FXML
    public Button singleGameButton;
    @FXML
    public Button multiGameButton;
    @FXML
    public Button mainMenuGameButton;

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
}
