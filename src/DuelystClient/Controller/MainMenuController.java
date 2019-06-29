package DuelystClient.Controller;

import DuelystClient.View.View;
import DuelystClient.model.Account;
import DuelystClient.model.Save.SaveAccount;
import DuelystClient.model.Save.SaveDeck;
import javafx.fxml.FXML;
import com.google.gson.Gson;
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

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


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
        accountInfo.setText(Account.getLoginAccout().getUserName() + "\n" + "MONEY :" + Account.getLoginAccout().getMoney());
        accountInfo.setGraphicTextGap(10);
    }

    public void logOutBtnAct() {
        View.makeLoginScene();
    }

    public void startGameAct() {
        View.makeSingleOrMultiMenu();
    }

    public void shopAct() {
        View.makeShopMenu();
    }

    public void collectionAct() {
        View.makeCollectionMenu();
    }

    public void recordedMatchAct() {

    }

    public void saveBtnAct(MouseEvent event) {
       /* Gson gson = new Gson();

        try {
            ArrayList<SaveAccount> saveAccounts = new ArrayList<>();
            for (Account account : Account.getAllUser()) {
                SaveAccount saveAccount = new SaveAccount();
                account.getCollection().getHeroes().forEach(x -> saveAccount.cards.add(x.getName()));
                account.getCollection().getMinions().forEach(x -> saveAccount.cards.add(x.getName()));
                account.getCollection().getSpells().forEach(x -> saveAccount.cards.add(x.getName()));
                account.getCollection().getUsableItems().forEach(x -> saveAccount.cards.add(x.getName()));
                saveAccount.user = account.getUserName();
                saveAccount.pass = account.getPassWord();
                if (account.getMainDeck() != null)
                    saveAccount.mainDeck = account.getMainDeck().getName();
                account.getCollection().getDecks().forEach(x -> {
                    SaveDeck saveDeck = new SaveDeck();
                    x.getHero().forEach(y -> saveDeck.cards.add(y.getName()));
                    x.getMinions().forEach(y -> saveDeck.cards.add(y.getName()));
                    x.getSpells().forEach(y -> saveDeck.cards.add(y.getName()));
                    x.getUsableItems().forEach(y -> saveDeck.cards.add(y.getName()));
                    saveDeck.name = x.getName();
                    saveAccount.decks.add(saveDeck);

                });

                saveAccount.money = account.getMoney();
                saveAccount.wins = account.getWins();
                saveAccount.mana = account.getMana();
                saveAccounts.add(saveAccount);
            }
            String json = gson.toJson(saveAccounts);
            FileWriter writer = new FileWriter("C:\\Users\\saber\\IdeaProjects\\projecctt\\src\\DuelystClient\\model\\Save\\saveaccount.json");
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public void changeProfile(MouseEvent event) {
        if (event.getX() < profile.getFitWidth()) {
            Account.getLoginAccout().setAvatar((Account.getLoginAccout().getAvatar() + 1) % 3 + 1);
            setProfile();
        }
    }

    public void setProfile() {
        profile.setImage(Account.getLoginAccout().getAvatarImage());
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
