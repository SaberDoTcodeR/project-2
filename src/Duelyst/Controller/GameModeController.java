package Duelyst.Controller;

import Duelyst.View.View;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class GameModeController {
    @FXML
    public Button mode1Button;
    @FXML
    public Button mode2Button;
    @FXML
    public Button mode3Button;
    @FXML
    public Button mainMenuGameButton;

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

    }

    public void mode2BtnAct() {

    }

    public void mode3BtnAct() {

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
            mode1BtnAct();
        }
    }

    public void handleOnKeyPressedMode2(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            mode2BtnAct();
        }
    }
    public void handleOnKeyPressedMode3(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            mode3BtnAct();
        }
    }
}
