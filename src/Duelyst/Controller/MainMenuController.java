package Duelyst.Controller;

import Duelyst.View.View;
import Duelyst.model.Account;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class MainMenuController {
    @FXML
    ImageView profile;
    @FXML
    Label accountInfo;
    @FXML
    Button startGame;
    @FXML
    Button recordedMatch;
    @FXML
    Button shop;
    @FXML
    Button collection;
    @FXML
    Button logOut;

    @FXML
    public void initialize() {
        setProfile(Account.getLoginAccount().getAvatar());
        accountInfo.setText(Account.getLoginAccount().getUserName() + "\n" + "MONEY :" + Account.getLoginAccount().getMoney());

    }

    public void logOutBtnAct() {
        View.makeLoginScene();
    }

    public void startGameAct() {

    }

    public void shopAct() {

    }

    public void collectionAct() {

    }

    public void recordedMatchAct() {

    }

    public void changeProfile(MouseEvent event) {
        if (event.getX() < profile.getFitWidth()) {
            if (Account.getLoginAccount().getAvatar().impl_getUrl().contains("Duelyst/css/avatar1.png"))
                Account.getLoginAccount().setAvatar(new Image("Duelyst/css/avatar2.jpg"));
            else
                Account.getLoginAccount().setAvatar(new Image("Duelyst/css/avatar1.png"));
            setProfile(Account.getLoginAccount().getAvatar());
        }
    }

    public void setProfile(Image imagePro) {
        profile.setImage(imagePro);
        Rectangle clip = new Rectangle(
                profile.getFitWidth(), profile.getFitHeight()
        );
        clip.setArcWidth(20);
        clip.setArcHeight(20);
        profile.setClip(clip);
        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);
        WritableImage image = profile.snapshot(parameters, null);
        profile.setClip(null);
        profile.setEffect(new DropShadow(20, Color.BLACK));
        profile.setImage(image);
    }

    public void logOutBtnActFocus() {
        logOut.requestFocus();
    }

    public void collectionBtnActFocus() {
        collection.requestFocus();
    }

    public void shopBtnActFocus() {
        shop.requestFocus();
    }

    public void recordedMatchBtnActFocus() {
        recordedMatch.requestFocus();
    }

    public void startGameBtnActFocus() {
        startGame.requestFocus();
    }

    public void handleOnKeyPressedStartGame(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            this.startGameAct();
        } else if (event.getCode().equals(KeyCode.UP)) {
            logOut.requestFocus();
        }

    }

    public void handleOnKeyPressedShop(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            this.shopAct();
        }

    }

    public void handleOnKeyPressedCollection(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            this.collectionAct();
        }

    }

    public void handleOnKeyPressedRecordedMatch(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            this.recordedMatchAct();
        }

    }

    public void handleOnKeyPressedLogOut(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            this.logOutBtnAct();
        } else if (event.getCode().equals(KeyCode.DOWN)) {
            startGame.requestFocus();
        }

    }

}
