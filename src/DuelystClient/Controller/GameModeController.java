package DuelystClient.Controller;

import DuelystClient.View.View;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.events.JFXDialogEvent;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class GameModeController {
    public static int MODE=0;// 0 for HeroMode 1 for OneFlag 2 for SeveralFlag
    @FXML
    public Button mode1Button;
    @FXML
    public Button mode2Button;
    @FXML
    public Button mode3Button;
    @FXML
    public Button mainMenuGameButton;
    public StackPane stackPane;
    public GridPane gridPane;

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
        if(SingleOrMultiController.singleOrMulti)
            View.makeBattle();
        else {
            
        }
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
            MODE = 0;
            mode1BtnAct();
        }
    }

    public void handleOnKeyPressedMode2(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            MODE = 1;
            mode2BtnAct();
        }
    }
    public void handleOnKeyPressedMode3(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            MODE = 2;
            mode3BtnAct();
        }
    }
    private void showDialog(String string) {
        Platform.runLater(() -> {
            BoxBlur blur = new BoxBlur(5, 5, 10);
            JFXDialogLayout jfxDialogLayout = new JFXDialogLayout();
            JFXButton jfxButton = new JFXButton("OK");
            jfxDialogLayout.setStyle(" -fx-background-color: rgba(0, 0, 0, 0.3);");
            JFXDialog jfxDialog = new JFXDialog(stackPane, jfxDialogLayout, JFXDialog.DialogTransition.TOP);
            jfxButton.getStyleClass().add("dialog-button");
            jfxButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> {
                        jfxDialog.close();
                    }
            );
            jfxDialog.setOnDialogClosed((JFXDialogEvent jfxEvent) -> {
                gridPane.setEffect(null);
            });
            Label label = new Label(string);
            label.setStyle("-fx-font-size: 20px; -fx-text-fill: black");
            jfxDialogLayout.setBody(label);
            jfxDialogLayout.setActions(jfxButton);
            jfxDialogLayout.setActions(jfxButton);
            jfxDialog.show();
            gridPane.setEffect(blur);
        });
    }
}
