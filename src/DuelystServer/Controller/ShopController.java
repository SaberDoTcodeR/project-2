package DuelystServer.Controller;

import DuelystServer.Connection;
import DuelystServer.Server;
import DuelystServer.messages.CustomMessage;
import DuelystServer.messages.ShopMessage;
import DuelystServer.model.Card.Card;
import DuelystServer.model.Card.Hero.CustomHero;
import DuelystServer.model.Card.Hero.Hero;
import DuelystServer.model.Card.Minion.CustomMinion;
import DuelystServer.model.Card.Minion.Minion;
import DuelystServer.model.Card.Spell.Spell;
import DuelystServer.model.Item.UsableItem.UsableItem;
import com.google.gson.Gson;
import com.jfoenix.controls.*;
import com.jfoenix.controls.events.JFXDialogEvent;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.util.ArrayList;

public class ShopController {
    public static AnchorPane anchorPane;
    private static ShopController shopController;
    public Button button5;

    public static ShopController getInstance() {
        return shopController;
    }

    public static ArrayList<VBox> createdHeroes = new ArrayList<>();
    public static ArrayList<VBox> createdMinions = new ArrayList<>();
    public static ArrayList<VBox> createdSpells = new ArrayList<>();
    @FXML
    public ScrollPane heroes;
    public ScrollPane minions;
    public ScrollPane spells;
    public ScrollPane items;
    @FXML
    StackPane stackPane = new StackPane();

    @FXML
    GridPane gridPane = new GridPane();
    @FXML
    public Button button1;
    @FXML
    public Button button2;
    @FXML
    public Button button3;
    @FXML
    public Button button4;
    public VBox hero1Box;
    public VBox hero2Box;
    public VBox hero3Box;
    public VBox hero4Box;
    public VBox hero5Box;
    public VBox hero6Box;
    public VBox hero7Box;
    public VBox hero8Box;
    public VBox hero9Box;
    public VBox hero10Box;
    public static ArrayList<VBox> heroBoxes = new ArrayList<>();


    public VBox spell1Box;
    public VBox spell2Box;
    public VBox spell3Box;
    public VBox spell4Box;
    public VBox spell5Box;
    public VBox spell6Box;
    public VBox spell7Box;
    public VBox spell8Box;
    public VBox spell9Box;
    public VBox spell10Box;
    public VBox spell11Box;
    public VBox spell12Box;
    public VBox spell13Box;
    public VBox spell14Box;
    public VBox spell15Box;
    public VBox spell16Box;
    public VBox spell17Box;
    public VBox spell18Box;
    public VBox spell19Box;
    public VBox spell20Box;
    public static ArrayList<VBox> spellBoxes = new ArrayList<>();

    public VBox minion1Box;
    public VBox minion2Box;
    public VBox minion3Box;
    public VBox minion4Box;
    public VBox minion5Box;
    public VBox minion6Box;
    public VBox minion7Box;
    public VBox minion8Box;
    public VBox minion9Box;
    public VBox minion10Box;
    public VBox minion11Box;
    public VBox minion12Box;
    public VBox minion13Box;
    public VBox minion14Box;
    public VBox minion15Box;
    public VBox minion16Box;
    public VBox minion17Box;
    public VBox minion18Box;
    public VBox minion19Box;
    public VBox minion20Box;
    public VBox minion21Box;
    public VBox minion22Box;
    public VBox minion23Box;
    public VBox minion24Box;
    public VBox minion25Box;
    public VBox minion26Box;
    public VBox minion27Box;
    public VBox minion28Box;
    public VBox minion29Box;
    public VBox minion30Box;
    public VBox minion31Box;
    public VBox minion32Box;
    public VBox minion33Box;
    public VBox minion34Box;
    public VBox minion35Box;
    public VBox minion36Box;
    public VBox minion37Box;
    public VBox minion38Box;
    public VBox minion39Box;
    public VBox minion40Box;
    public static ArrayList<VBox> minionBoxes = new ArrayList<>();

    public VBox item1Box;
    public VBox item2Box;
    public VBox item3Box;
    public VBox item4Box;
    public VBox item5Box;
    public VBox item6Box;
    public VBox item7Box;
    public VBox item8Box;
    public VBox item9Box;
    public VBox item10Box;
    public VBox item11Box;
    public static ArrayList<VBox> itemBoxes = new ArrayList<>();

    public void initialize() {
        shopController = this;
        heroBoxes.add(hero1Box);
        heroBoxes.add(hero2Box);
        heroBoxes.add(hero3Box);
        heroBoxes.add(hero4Box);
        heroBoxes.add(hero5Box);
        heroBoxes.add(hero6Box);
        heroBoxes.add(hero7Box);
        heroBoxes.add(hero8Box);
        heroBoxes.add(hero9Box);
        heroBoxes.add(hero10Box);

        itemBoxes.add(item1Box);
        itemBoxes.add(item2Box);
        itemBoxes.add(item3Box);
        itemBoxes.add(item4Box);
        itemBoxes.add(item5Box);
        itemBoxes.add(item6Box);
        itemBoxes.add(item7Box);
        itemBoxes.add(item8Box);
        itemBoxes.add(item9Box);
        itemBoxes.add(item10Box);
        itemBoxes.add(item11Box);

        spellBoxes.add(spell1Box);
        spellBoxes.add(spell2Box);
        spellBoxes.add(spell3Box);
        spellBoxes.add(spell4Box);
        spellBoxes.add(spell5Box);
        spellBoxes.add(spell6Box);
        spellBoxes.add(spell7Box);
        spellBoxes.add(spell8Box);
        spellBoxes.add(spell9Box);
        spellBoxes.add(spell10Box);
        spellBoxes.add(spell11Box);
        spellBoxes.add(spell12Box);
        spellBoxes.add(spell13Box);
        spellBoxes.add(spell14Box);
        spellBoxes.add(spell15Box);
        spellBoxes.add(spell16Box);
        spellBoxes.add(spell17Box);
        spellBoxes.add(spell18Box);
        spellBoxes.add(spell19Box);
        spellBoxes.add(spell20Box);

        minionBoxes.add(minion1Box);
        minionBoxes.add(minion2Box);
        minionBoxes.add(minion3Box);
        minionBoxes.add(minion4Box);
        minionBoxes.add(minion5Box);
        minionBoxes.add(minion6Box);
        minionBoxes.add(minion7Box);
        minionBoxes.add(minion8Box);
        minionBoxes.add(minion9Box);
        minionBoxes.add(minion10Box);
        minionBoxes.add(minion11Box);
        minionBoxes.add(minion12Box);
        minionBoxes.add(minion13Box);
        minionBoxes.add(minion14Box);
        minionBoxes.add(minion15Box);
        minionBoxes.add(minion16Box);
        minionBoxes.add(minion17Box);
        minionBoxes.add(minion18Box);
        minionBoxes.add(minion19Box);
        minionBoxes.add(minion20Box);
        minionBoxes.add(minion21Box);
        minionBoxes.add(minion22Box);
        minionBoxes.add(minion23Box);
        minionBoxes.add(minion24Box);
        minionBoxes.add(minion25Box);
        minionBoxes.add(minion26Box);
        minionBoxes.add(minion27Box);
        minionBoxes.add(minion28Box);
        minionBoxes.add(minion29Box);
        minionBoxes.add(minion30Box);
        minionBoxes.add(minion31Box);
        minionBoxes.add(minion32Box);
        minionBoxes.add(minion33Box);
        minionBoxes.add(minion34Box);
        minionBoxes.add(minion35Box);
        minionBoxes.add(minion36Box);
        minionBoxes.add(minion37Box);
        minionBoxes.add(minion38Box);
        minionBoxes.add(minion39Box);
        minionBoxes.add(minion40Box);

        for (int i = 0; i < 10; i++) {
            String heroInfo = Hero.getHeroes().get(i).showDetails() + "\nBuy Cost : " + Hero.getHeroes().get(i).getCostOfBuy();
            ((Label) (heroBoxes.get(i).getChildren().get(2))).setText(
                    ((Label) (heroBoxes.get(i).getChildren().get(2))).getText() + "\n" + heroInfo + "\navailable from this : " + ShopMessage.getNumberOfHeroesInShop().get(i));
            ((Label) (heroBoxes.get(i).getChildren().get(2))).setWrapText(true);
        }
        for (int i = 0; i < 40; i++) {
            String minionInfo = Minion.getMinions().get(i).showDetails() + "\nBuy Cost : " + Minion.getMinions().get(i).getCostOfBuy();
            ((Label) (minionBoxes.get(i).getChildren().get(2))).setText(
                    ((Label) (minionBoxes.get(i).getChildren().get(2))).getText() + "\n" + minionInfo + "\navailable from this : " + ShopMessage.getNumberOfMinionsInShop().get(i));
            ((Label) (minionBoxes.get(i).getChildren().get(2))).setWrapText(true);
        }
        for (int i = 0; i < 20; i++) {
            String spellInfo = Spell.getSpells().get(i).showDetails() + "\nBuy Cost : " + Spell.getSpells().get(i).getCostOfBuy();
            ((Label) (spellBoxes.get(i).getChildren().get(2))).setText(
                    ((Label) (spellBoxes.get(i).getChildren().get(2))).getText() + "\n" + spellInfo + "\navailable from this : " + ShopMessage.getNumberOfSpellInShop().get(i));
            ((Label) (spellBoxes.get(i).getChildren().get(2))).setWrapText(true);
        }
        for (int i = 0; i < 11; i++) {
            String itemInfo = UsableItem.getUsableItems().get(i).showDetails() + "\nBuy Cost : " + UsableItem.getUsableItems().get(i).getCostOfBuy();
            ((Label) (itemBoxes.get(i).getChildren().get(2))).setText(
                    ((Label) (itemBoxes.get(i).getChildren().get(2))).getText() + "\n" + itemInfo + "\navailable from this : " + ShopMessage.getNumberOfItemsInShop().get(i));
            ((Label) (itemBoxes.get(i).getChildren().get(2))).setWrapText(true);
        }
        if (heroBoxes.size() == 10 && createdHeroes.size() != 0) {
            for (int i = 0; i < createdHeroes.size(); i++) {
                ((HBox) ((AnchorPane) heroes.getContent()).getChildren().get(0)).getChildren().add(createdHeroes.get(i));
                heroBoxes.add(createdHeroes.get(i));
            }
        }
        if (minionBoxes.size() == 40 && createdMinions.size() != 0) {
            for (int i = 0; i < createdMinions.size(); i++) {
                ((HBox) ((AnchorPane) minions.getContent()).getChildren().get(0)).getChildren().add(createdMinions.get(i));
                minionBoxes.add(createdMinions.get(i));
            }
        }
        if (spellBoxes.size() == 20 && createdSpells.size() != 0) {
            for (int i = 0; i < createdSpells.size(); i++) {
                ((HBox) ((AnchorPane) spells.getContent()).getChildren().get(0)).getChildren().add(createdSpells.get(i));
                spellBoxes.add(createdSpells.get(i));
            }
        }
    }

    public void createCard(CustomMessage customMessage, Card card) {
        if (customMessage.isType()) {
            VBox vBox1 = new VBox(5);
            vBox1.setPrefWidth(300);
            vBox1.setId("boxNotBoughtStyle");
            CheckBox checkBox = new CheckBox();
            checkBox.setAlignment(Pos.CENTER);
            checkBox.setPadding(new Insets(0, 30, 30, 30));
            Label label1 = new Label();
            label1.setText(customMessage.getName() + "\n" + card.showDetails() + "\nCost Of Buy :" + card.getCostOfBuy() + "\navailable from this : " + 5);
            label1.setWrapText(true);
            label1.setPadding(new Insets(0, 0, 0, 7));
            ImageView imageView = new ImageView(new Image("DuelystServer/css/hero.jpg"));
            imageView.setFitWidth(200.0);
            imageView.setFitHeight(150.0);
            imageView.setPreserveRatio(true);
            vBox1.getChildren().addAll(checkBox, imageView, label1);
            heroBoxes.add(vBox1);
            createdHeroes.add(vBox1);
            Platform.runLater(() -> {
                ((HBox) ((AnchorPane) heroes.getContent()).getChildren().get(0)).getChildren().add(vBox1);
            });
        } else {
            VBox vBox1 = new VBox(5);
            vBox1.setPrefWidth(300);
            vBox1.setId("boxNotBoughtStyle");
            CheckBox checkBox = new CheckBox();
            checkBox.setAlignment(Pos.CENTER);
            checkBox.setPadding(new Insets(0, 30, 30, 30));
            Label label1 = new Label();
            label1.setText(customMessage.getName() + "\n" + card.showDetails() + "\nCost Of Buy :" + card.getCostOfBuy() + "\navailable from this : " + 5);
            label1.setWrapText(true);
            label1.setPadding(new Insets(0, 0, 0, 7));
            ImageView imageView = new ImageView(new Image("DuelystServer/css/avatar3.jpg"));
            imageView.setFitWidth(200.0);
            imageView.setFitHeight(150.0);
            imageView.setPreserveRatio(true);
            vBox1.getChildren().addAll(checkBox, imageView, label1);
            minionBoxes.add(vBox1);
            createdMinions.add(vBox1);
            Platform.runLater(() -> {
                ((HBox) ((AnchorPane) minions.getContent()).getChildren().get(0)).getChildren().add(vBox1);
            });
        }
    }

    public void updateShop() {
        for (int i = 0; i < heroBoxes.size(); i++) {
            String str = ((Label) (heroBoxes.get(i).getChildren().get(2))).getText();
            str = str.substring(0, str.indexOf("\navailable from this : "));
            str += "\navailable from this : " + ShopMessage.getNumberOfHeroesInShop().get(i);
            final String x = str;
            int finalI = i;
            Platform.runLater(() -> {
                ((Label) (heroBoxes.get(finalI).getChildren().get(2))).setText(x);
            });
        }
        for (int i = 0; i < minionBoxes.size(); i++) {
            String str = ((Label) (minionBoxes.get(i).getChildren().get(2))).getText();
            str = str.substring(0, str.indexOf("\navailable from this : "));
            str += "\navailable from this : " + ShopMessage.getNumberOfMinionsInShop().get(i);
            final String x = str;
            int finalI = i;
            Platform.runLater(() -> {
                ((Label) (minionBoxes.get(finalI).getChildren().get(2))).setText(x);
            });
        }
        for (int i = 0; i < spellBoxes.size(); i++) {
            String str = ((Label) (spellBoxes.get(i).getChildren().get(2))).getText();
            str = str.substring(0, str.indexOf("\navailable from this : "));
            str += "\navailable from this : " + ShopMessage.getNumberOfSpellInShop().get(i);
            final String x = str;
            int finalI = i;
            Platform.runLater(() -> {
                ((Label) (spellBoxes.get(finalI).getChildren().get(2))).setText(x);
            });
        }
        for (int i = 0; i < itemBoxes.size(); i++) {
            String str = ((Label) (itemBoxes.get(i).getChildren().get(2))).getText();
            str = str.substring(0, str.indexOf("\navailable from this : "));
            str += "\navailable from this : " + ShopMessage.getNumberOfItemsInShop().get(i);
            final String x = str;
            int finalI = i;
            Platform.runLater(() -> {
                ((Label) (itemBoxes.get(finalI).getChildren().get(2))).setText(x);
            });
        }
    }

    @FXML
    void showHeroes() {
        items.setVisible(false);
        spells.setVisible(false);
        minions.setVisible(false);
        heroes.setVisible(true);
    }

    @FXML
    void showItems() {
        spells.setVisible(false);
        minions.setVisible(false);
        heroes.setVisible(false);
        items.setVisible(true);
    }

    @FXML
    void showMinions() {
        items.setVisible(false);
        spells.setVisible(false);
        heroes.setVisible(false);
        minions.setVisible(true);
    }

    @FXML
    void showSpells() {
        items.setVisible(false);
        minions.setVisible(false);
        heroes.setVisible(false);
        spells.setVisible(true);
    }

    public void heroesBtnActFocus() {
        button1.requestFocus();
    }

    public void minionsBtnActFocus() {
        button2.requestFocus();
    }

    public void spellsBtnActFocus() {
        button3.requestFocus();
    }

    public void itemsBtnActFocus() {
        button4.requestFocus();
    }

    public void handleOnKeyPressedHeroes(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            showHeroes();
        }
    }

    public void handleOnKeyPressedMinions(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            showMinions();
        }
    }

    public void handleOnKeyPressedSpells(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            showSpells();
        }
    }

    public void handleOnKeyPressedItems(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            showItems();
        }
    }

    public void createBtnActFocus() {
        button5.requestFocus();
    }

    public void handleOnKeyPressedCreate(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            createBtnAct();
        }
    }

    @FXML
    private void createBtnAct() {
        BoxBlur blur = new BoxBlur(5, 5, 10);
        JFXDialogLayout jfxDialogLayout = new JFXDialogLayout();
        JFXButton jfxButton = new JFXButton("Create Card");
        JFXTextField jfxTextField = new JFXTextField();
        jfxTextField.setPromptText("Name...");
        jfxTextField.setId("text");
        jfxDialogLayout.setStyle(" -fx-background-color: rgba(0, 0, 0, 0.4);");
        JFXDialog jfxDialog = new JFXDialog(stackPane, jfxDialogLayout, JFXDialog.DialogTransition.TOP);
        jfxButton.getStyleClass().add("dialog-button");
        jfxDialog.setOnDialogClosed((JFXDialogEvent jfxEvent) -> gridPane.setEffect(null));
        JFXComboBox<String> typeBox = new JFXComboBox<>();
        typeBox.getItems().addAll("Hero", "Minion", "Spell");
        typeBox.setPromptText("Choose Type Of Card");
        JFXTextField ap = new JFXTextField();
        ap.setPromptText("AP...");
        ap.setId("text");
        JFXTextField hp = new JFXTextField();
        hp.setPromptText("HP...");
        hp.setId("text");
        JFXTextField costOfCard = new JFXTextField();
        costOfCard.setPromptText("Cost Of Card...");
        costOfCard.setId("text");
        JFXTextField coolDown = new JFXTextField();
        coolDown.setPromptText("CoolDown Time...");
        coolDown.setId("text");
        JFXTextField activeTime = new JFXTextField();
        activeTime.setPromptText("Active Time...");
        activeTime.setId("text");
        JFXTextField range = new JFXTextField();
        range.setPromptText("Range...");
        range.setId("text");
        JFXComboBox<String> typeRangeBox = new JFXComboBox<>();
        typeRangeBox.setPromptText("Choose Type Of Attack");
        typeRangeBox.getItems().addAll("Melee", "Hybrid", "Ranged");
        Label label = new Label("Make Your Ideal Card");
        label.setStyle("-fx-font-size: 20px; -fx-text-fill: black");
        VBox vBox = new VBox();
        vBox.getChildren().addAll(label, jfxTextField, typeBox, costOfCard);
        typeBox.setOnAction(event -> {
            if (typeBox.getValue().equals("Hero")) {
                vBox.getChildren().removeAll(ap, hp, typeRangeBox, range, coolDown, activeTime);
                vBox.getChildren().addAll(ap, hp, typeRangeBox, range, coolDown);
            } else if (typeBox.getValue().equals("Minion")) {
                vBox.getChildren().removeAll(ap, hp, typeRangeBox, range, coolDown, activeTime);
                vBox.getChildren().addAll(ap, hp, typeRangeBox, range, activeTime);
            } else {
                vBox.getChildren().removeAll(ap, hp, typeRangeBox, range, coolDown, activeTime);
            }
        });
        jfxButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> {
                    int typeOfRange;
                    if (Card.getCard(jfxTextField.getText()) == null) {
                        if (typeRangeBox.getValue().equals("Melee")) {
                            typeOfRange = 0;
                        } else if (typeRangeBox.getValue().equals("Hybrid")) {
                            typeOfRange = 2;
                        } else {
                            typeOfRange = 1;
                        }
                        if (typeBox.getValue().equals("Hero")) {
                            CustomHero customHero = new CustomHero(jfxTextField.getText(), Integer.parseInt(ap.getText())
                                    , Integer.parseInt(hp.getText()), Integer.parseInt(costOfCard.getText()), typeOfRange, Integer.parseInt(range.getText()),
                                    Integer.parseInt(coolDown.getText()), 1);
                            VBox vBox1 = new VBox(5);
                            vBox1.setPrefWidth(300);
                            vBox1.setId("boxNotBoughtStyle");
                            CheckBox checkBox = new CheckBox();
                            checkBox.setAlignment(Pos.CENTER);
                            checkBox.setPadding(new Insets(0, 30, 30, 30));
                            ImageView imageView = new ImageView(new Image("DuelystClient/css/hero.jpg"));
                            imageView.setFitWidth(200.0);
                            imageView.setFitHeight(150.0);
                            imageView.setPreserveRatio(true);
                            Label label1 = new Label();
                            label1.setText(jfxTextField.getText() + "\n" + customHero.showDetails() + "\nCost Of Buy :" + customHero.getCostOfBuy() + "\navailable from this : " + 5);
                            label1.setWrapText(true);
                            label1.setPadding(new Insets(0, 0, 0, 7));
                            vBox1.getChildren().addAll(checkBox, imageView, label1);
                            heroBoxes.add(vBox1);
                            createdHeroes.add(vBox1);
                            ShopMessage.getNumberOfHeroesInShop().add(5);
                            ((HBox) ((AnchorPane) heroes.getContent()).getChildren().get(0)).getChildren().add(vBox1);
                            Gson gson = new Gson();
                            CustomMessage customMessage = new CustomMessage(jfxTextField.getText(), Integer.parseInt(ap.getText()), Integer.parseInt(hp.getText()),
                                    1, Integer.parseInt(costOfCard.getText()), Integer.parseInt(range.getText()), typeOfRange,
                                    Integer.parseInt(coolDown.getText()), 0, true);
                            for (Connection connection : Server.getConnections()) {
                                connection.sendPacket(gson.toJson(customMessage));
                            }
                        } else if (typeBox.getValue().equals("Minion")) {
                            CustomMinion customMinion = new CustomMinion(jfxTextField.getText(), Integer.parseInt(ap.getText())
                                    , Integer.parseInt(hp.getText()), Integer.parseInt(costOfCard.getText()), typeOfRange, Integer.parseInt(range.getText()),
                                    1, Integer.parseInt(activeTime.getText()));
                            VBox vBox1 = new VBox(6);
                            vBox1.setPrefWidth(300);
                            vBox1.setId("boxNotBoughtStyle");
                            CheckBox checkBox = new CheckBox();
                            checkBox.setAlignment(Pos.CENTER);
                            checkBox.setPadding(new Insets(0, 30, 30, 30));
                            ImageView imageView = new ImageView(new Image("DuelystClient/css/avatar3.jpg"));
                            imageView.setFitWidth(200.0);
                            imageView.setFitHeight(150.0);
                            imageView.setPreserveRatio(true);
                            Label label1 = new Label();
                            label1.setText(jfxTextField.getText() + "\n" + customMinion.showDetails() + "\nCost Of Buy :" + customMinion.getCostOfBuy() + "\navailable from this : " + 5);
                            label1.setWrapText(true);
                            label1.setPadding(new Insets(0, 0, 0, 8));
                            vBox1.getChildren().addAll(checkBox, imageView, label1);
                            minionBoxes.add(vBox1);
                            createdMinions.add(vBox1);
                            ShopMessage.getNumberOfMinionsInShop().add(5);
                            ((HBox) ((AnchorPane) minions.getContent()).getChildren().get(0)).getChildren().add(vBox1);
                            Gson gson = new Gson();
                            CustomMessage customMessage = new CustomMessage(jfxTextField.getText(), Integer.parseInt(ap.getText()), Integer.parseInt(hp.getText()),
                                    1, Integer.parseInt(costOfCard.getText()), Integer.parseInt(range.getText()), typeOfRange,
                                    0, Integer.parseInt(activeTime.getText()), false);
                            for (Connection connection : Server.getConnections()) {
                                connection.sendPacket(gson.toJson(customMessage));
                            }
                        } else if (typeBox.getValue().equals("Spell")) {
                            //nothing at moment
                        }
                        jfxDialog.close();
                    } else jfxDialog.close();
                }
        );
        jfxDialogLayout.getBody().add(vBox);
        jfxDialogLayout.setActions(jfxButton);
        jfxDialog.show();
        gridPane.setEffect(blur);
    }
}