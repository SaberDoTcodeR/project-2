package DuelystClient.Controller;

import DuelystClient.Client;
import DuelystClient.Messages.LogoutMessage;
import DuelystClient.View.View;
import DuelystClient.Messages.SaveAccountMessage;
import DuelystClient.model.Account;
import javafx.fxml.FXML;
import com.google.gson.Gson;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class MainMenuController {
    public Button save;
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
        setProfile();
        accountInfo.setText(Account.getLoginAccount().getUserName() + "\n" + "MONEY :" + Account.getLoginAccount().getMoney());
        accountInfo.setGraphicTextGap(10);
    }

    public void logOutBtnAct() {
        playSound();
        Gson gson = new Gson();
        LogoutMessage logoutMessage = new LogoutMessage(Account.getLoginAccount(),42568);
        Client.connectionToServer.sendPacket(gson.toJson(logoutMessage));
        View.makeLoginScene();
    }

    public void startGameAct() {
        playSound();
        View.makeSingleOrMultiMenu();
    }

    public void shopAct() {
        String musicFile = "out/production/project-2(Phase-3)/DuelystClient/View/button_clicked.wav";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer;
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.3);
        mediaPlayer.play();
        View.makeShopMenu();
    }

    public void collectionAct() {
        playSound();
        View.makeCollectionMenu();
    }

    public void recordedMatchAct() {
        playSound();
    }

    static void playSound() {
        String musicFile = "out/production/project-2(Phase-3)/DuelystClient/View/button_clicked.wav";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer;
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.3);
        mediaPlayer.play();
    }

    public void saveBtnAct() {
        playSound();
        Gson gson = new Gson();
        SaveAccountMessage saveAccountMessage = new SaveAccountMessage();
        saveAccountMessage.setAccount(Account.getLoginAccount());
        String json = gson.toJson(saveAccountMessage);
        Client.connectionToServer.sendPacket(json);
        System.out.println(json);
    }

    public void changeProfile(MouseEvent event) {
        if (event.getX() < profile.getFitWidth()) {
            Account.getLoginAccount().setAvatar((Account.getLoginAccount().getAvatar() % 3) + 1);
            setProfile();
        }
    }

    public void setProfile() {
        profile.setImage(Account.getLoginAccount().getAvatarImage());
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

    public void saveBtnActFocus() {
        save.requestFocus();
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

    public void handleOnKeyPressedSave(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            this.saveBtnAct();
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
