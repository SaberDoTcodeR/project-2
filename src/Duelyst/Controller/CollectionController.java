package Duelyst.Controller;

import Duelyst.View.View;
import Duelyst.model.Account;
import Duelyst.model.Card.Hero.Hero;
import Duelyst.model.Card.Minion.Minion;
import Duelyst.model.Card.Spell.Spell;
import Duelyst.model.Deck;
import Duelyst.model.Item.UsableItem.UsableItem;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.events.JFXDialogEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;

import java.util.ArrayList;

public class CollectionController {
    public ArrayList<Deck> myDecks = new ArrayList<>();
    public boolean[] heroesBought = new boolean[10];
    public boolean[] itemsBought = new boolean[12];
    public boolean[] minionsBought = new boolean[40];
    public boolean[] spellsBought = new boolean[20];

    public void setCurrentDeck(String name) {
        for (Deck deck : myDecks) {
            if (deck.getName().equals(name))
                this.currentDeck = deck;
        }
        reChooseComboBox();

    }

    private Deck currentDeck;
    @FXML
    public ScrollPane heroes;
    public ScrollPane minions;
    public ScrollPane spells;
    public ScrollPane items;
    public HBox heroHBox;
    public HBox minionHBox;
    public HBox spellHBox;
    public HBox itemHBox;
    public VBox deckBox;
    public ComboBox deckList;

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
    @FXML
    public Button addButton;
    @FXML
    public Button createButton;
    @FXML
    public Button deleteButton;
    @FXML
    public Button crossButton;
    @FXML
    public Button setMainButton;
    @FXML
    public Button mainMenuButton;

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
    public VBox[] heroBoxes = new VBox[10];


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
    public VBox[] spellBoxes = new VBox[20];

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
    public VBox[] minionBoxes = new VBox[40];

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
    public VBox[] itemBoxes = new VBox[11];

    @FXML
    private CheckBox hero1;
    @FXML
    private CheckBox hero2;
    @FXML
    private CheckBox hero3;
    @FXML
    private CheckBox hero4;
    @FXML
    private CheckBox hero5;
    @FXML
    private CheckBox hero6;
    @FXML
    private CheckBox hero7;
    @FXML
    private CheckBox hero8;
    @FXML
    private CheckBox hero9;
    @FXML
    private CheckBox hero10;


    @FXML
    private CheckBox item1;
    @FXML
    private CheckBox item2;
    @FXML
    private CheckBox item3;
    @FXML
    private CheckBox item4;
    @FXML
    private CheckBox item5;
    @FXML
    private CheckBox item6;
    @FXML
    private CheckBox item7;
    @FXML
    private CheckBox item8;
    @FXML
    private CheckBox item9;
    @FXML
    private CheckBox item10;
    @FXML
    private CheckBox item11;

    @FXML
    private CheckBox spell1;
    @FXML
    private CheckBox spell2;
    @FXML
    private CheckBox spell3;
    @FXML
    private CheckBox spell4;
    @FXML
    private CheckBox spell5;
    @FXML
    private CheckBox spell6;
    @FXML
    private CheckBox spell7;
    @FXML
    private CheckBox spell8;
    @FXML
    private CheckBox spell9;
    @FXML
    private CheckBox spell10;
    @FXML
    private CheckBox spell11;
    @FXML
    private CheckBox spell12;
    @FXML
    private CheckBox spell13;
    @FXML
    private CheckBox spell14;
    @FXML
    private CheckBox spell15;
    @FXML
    private CheckBox spell16;
    @FXML
    private CheckBox spell17;
    @FXML
    private CheckBox spell18;
    @FXML
    private CheckBox spell19;
    @FXML
    private CheckBox spell20;

    @FXML
    private CheckBox minion1;
    @FXML
    private CheckBox minion2;
    @FXML
    private CheckBox minion3;
    @FXML
    private CheckBox minion4;
    @FXML
    private CheckBox minion5;
    @FXML
    private CheckBox minion6;
    @FXML
    private CheckBox minion7;
    @FXML
    private CheckBox minion8;
    @FXML
    private CheckBox minion9;
    @FXML
    private CheckBox minion10;
    @FXML
    private CheckBox minion11;
    @FXML
    private CheckBox minion12;
    @FXML
    private CheckBox minion13;
    @FXML
    private CheckBox minion14;
    @FXML
    private CheckBox minion15;
    @FXML
    private CheckBox minion16;
    @FXML
    private CheckBox minion17;
    @FXML
    private CheckBox minion18;
    @FXML
    private CheckBox minion19;
    @FXML
    private CheckBox minion20;
    @FXML
    private CheckBox minion21;
    @FXML
    private CheckBox minion22;
    @FXML
    private CheckBox minion23;
    @FXML
    private CheckBox minion24;
    @FXML
    private CheckBox minion25;
    @FXML
    private CheckBox minion26;
    @FXML
    private CheckBox minion27;
    @FXML
    private CheckBox minion28;
    @FXML
    private CheckBox minion29;
    @FXML
    private CheckBox minion30;
    @FXML
    private CheckBox minion31;
    @FXML
    private CheckBox minion32;
    @FXML
    private CheckBox minion33;
    @FXML
    private CheckBox minion34;
    @FXML
    private CheckBox minion35;
    @FXML
    private CheckBox minion36;
    @FXML
    private CheckBox minion37;
    @FXML
    private CheckBox minion38;
    @FXML
    private CheckBox minion39;
    @FXML
    private CheckBox minion40;

    public void initialize() {
        deckList.setOnAction(event -> {
            setCurrentDeck((String) (deckList.getValue()));
            showDeck();
        });
        deckList.setPromptText("CHOOSE A DECK :");
        myDecks = Account.getLoginAccount().getCollection().getDecks();

        for (Deck deck : myDecks) {
            if (Account.getLoginAccount().getMainDeck() != null && deck.getName().equals(Account.getLoginAccount().getMainDeck())) {
                deckList.getItems().add(deck.getName());
            } else {
                deckList.getItems().add(deck.getName());

            }
        }


        heroBoxes[0] = hero1Box;
        heroBoxes[1] = hero2Box;
        heroBoxes[2] = hero3Box;
        heroBoxes[3] = hero4Box;
        heroBoxes[4] = hero5Box;
        heroBoxes[5] = hero6Box;
        heroBoxes[6] = hero7Box;
        heroBoxes[7] = hero8Box;
        heroBoxes[8] = hero9Box;
        heroBoxes[9] = hero10Box;

        itemBoxes[0] = item1Box;
        itemBoxes[1] = item2Box;
        itemBoxes[2] = item3Box;
        itemBoxes[3] = item4Box;
        itemBoxes[4] = item5Box;
        itemBoxes[5] = item6Box;
        itemBoxes[6] = item7Box;
        itemBoxes[7] = item8Box;
        itemBoxes[8] = item9Box;
        itemBoxes[9] = item10Box;
        itemBoxes[10] = item11Box;


        spellBoxes[0] = spell1Box;
        spellBoxes[1] = spell2Box;
        spellBoxes[2] = spell3Box;
        spellBoxes[3] = spell4Box;
        spellBoxes[4] = spell5Box;
        spellBoxes[5] = spell6Box;
        spellBoxes[6] = spell7Box;
        spellBoxes[7] = spell8Box;
        spellBoxes[8] = spell9Box;
        spellBoxes[9] = spell10Box;
        spellBoxes[10] = spell11Box;
        spellBoxes[11] = spell12Box;
        spellBoxes[12] = spell13Box;
        spellBoxes[13] = spell14Box;
        spellBoxes[14] = spell15Box;
        spellBoxes[15] = spell16Box;
        spellBoxes[16] = spell17Box;
        spellBoxes[17] = spell18Box;
        spellBoxes[18] = spell19Box;
        spellBoxes[19] = spell20Box;

        minionBoxes[0] = minion1Box;
        minionBoxes[1] = minion2Box;
        minionBoxes[2] = minion3Box;
        minionBoxes[3] = minion4Box;
        minionBoxes[4] = minion5Box;
        minionBoxes[5] = minion6Box;
        minionBoxes[6] = minion7Box;
        minionBoxes[7] = minion8Box;
        minionBoxes[8] = minion9Box;
        minionBoxes[9] = minion10Box;
        minionBoxes[10] = minion11Box;
        minionBoxes[11] = minion12Box;
        minionBoxes[12] = minion13Box;
        minionBoxes[13] = minion14Box;
        minionBoxes[14] = minion15Box;
        minionBoxes[15] = minion16Box;
        minionBoxes[16] = minion17Box;
        minionBoxes[17] = minion18Box;
        minionBoxes[18] = minion19Box;
        minionBoxes[19] = minion20Box;
        minionBoxes[20] = minion21Box;
        minionBoxes[21] = minion22Box;
        minionBoxes[22] = minion23Box;
        minionBoxes[23] = minion24Box;
        minionBoxes[24] = minion25Box;
        minionBoxes[25] = minion26Box;
        minionBoxes[26] = minion27Box;
        minionBoxes[27] = minion28Box;
        minionBoxes[28] = minion29Box;
        minionBoxes[29] = minion30Box;
        minionBoxes[30] = minion31Box;
        minionBoxes[31] = minion32Box;
        minionBoxes[32] = minion33Box;
        minionBoxes[33] = minion34Box;
        minionBoxes[34] = minion35Box;
        minionBoxes[35] = minion36Box;
        minionBoxes[36] = minion37Box;
        minionBoxes[37] = minion38Box;
        minionBoxes[38] = minion39Box;
        minionBoxes[39] = minion40Box;


        for (int i = 0, x = 0; i < 10; i++, x++) {
            if (Account.getLoginAccount().getCollection().hasThisCard
                    (((Label) (heroBoxes[i].getChildren().get(2))).getText().split("\\n")[0].replaceAll("\\s", "").toLowerCase())) {
                heroesBought[i] = true;

            } else {
                heroHBox.getChildren().remove(x);
                x--;
            }
            String heroInfo = Hero.getHeroes().get(i).showDetails() + "\nBuy Cost : " + Hero.getHeroes().get(i).getCostOfBuy();

            ((Label) (heroBoxes[i].getChildren().get(2))).setText(
                    ((Label) (heroBoxes[i].getChildren().get(2))).getText() + "\n" + heroInfo);
            ((Label) (heroBoxes[i].getChildren().get(2))).setWrapText(true);
        }
        for (int i = 0, x = 0; i < 11; i++, x++) {
            if (Account.getLoginAccount().getCollection().hasThisCard
                    (((Label) (itemBoxes[i].getChildren().get(2))).getText().split("\\n")[0].replaceAll("\\s", "").toLowerCase())) {
                itemsBought[i] = true;
            } else {
                itemHBox.getChildren().remove(x);
                x--;
            }
            String itemInfo = UsableItem.getUsableItems().get(i).showDetails() + "\nBuy Cost : " + UsableItem.getUsableItems().get(i).getCostOfBuy();

            ((Label) (itemBoxes[i].getChildren().get(2))).setText(
                    ((Label) (itemBoxes[i].getChildren().get(2))).getText() + "\n" + itemInfo);
            ((Label) (itemBoxes[i].getChildren().get(2))).setWrapText(true);
        }
        for (int i = 0, x = 0; i < 40; i++, x++) {
            if (Account.getLoginAccount().getCollection().hasThisCard
                    (((Label) (minionBoxes[i].getChildren().get(2))).getText().split("\\n")[0].replaceAll("\\s", "").toLowerCase())) {
                minionsBought[i] = true;
            } else {
                minionHBox.getChildren().remove(x);
                x--;
            }
            String minionInfo = Minion.getMinions().get(i).showDetails() + "\nBuy Cost : " + Minion.getMinions().get(i).getCostOfBuy();

            ((Label) (minionBoxes[i].getChildren().get(2))).setText(
                    ((Label) (minionBoxes[i].getChildren().get(2))).getText() + "\n" + minionInfo);
            ((Label) (minionBoxes[i].getChildren().get(2))).setWrapText(true);
        }
        for (int i = 0, x = 0; i < 20; i++, x++) {
            if (Account.getLoginAccount().getCollection().hasThisCard
                    (((Label) (spellBoxes[i].getChildren().get(2))).getText().split("\\n")[0].replaceAll("\\s", "").toLowerCase())) {
                spellsBought[i] = true;
            } else {
                spellHBox.getChildren().remove(x);
                x--;
            }
            String spellInfo = Spell.getSpells().get(i).showDetails() + "\nBuy Cost : " + Spell.getSpells().get(i).getCostOfBuy();

            ((Label) (spellBoxes[i].getChildren().get(2))).setText(
                    ((Label) (spellBoxes[i].getChildren().get(2))).getText() + "\n" + spellInfo);
            ((Label) (spellBoxes[i].getChildren().get(2))).setWrapText(true);
        }
    }

    private void showDeck() {
        deckBox.getChildren().clear();
        for (Hero hero : currentDeck.getHero()) {
            showCard(hero.getName().toUpperCase(), 0);
        }
        for (Minion minion : currentDeck.getMinions()) {
            showCard(minion.getName().toUpperCase(), 1);
        }
        for (Spell spell : currentDeck.getSpells()) {
            showCard(spell.getName().toUpperCase(), 2);
        }
        for (UsableItem item : currentDeck.getUsableItem()) {
            showCard(item.getName().toUpperCase(), 3);
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

    public void mainMenuAct() {
        View.makeMainMenu();
    }

    private void reChooseComboBox() {
        myDecks = Account.getLoginAccount().getCollection().getDecks();
        for (Object node : deckList.getItems()) {
            String label = (String) node;
            if (Account.getLoginAccount().getMainDeck() != null && label.equals(Account.getLoginAccount().getMainDeck().getName())) {
                if (currentDeck != null && currentDeck.getName().equals(label)) {

                    deckList.setValue("*" + label + "*");

                    return;
                }
            } else {
                if (currentDeck != null && currentDeck.getName().equals(label)) {
                    deckList.setValue(label);
                    return;
                }
            }


        }
    }

    private void showDialog(String promptText, String message) {
        BoxBlur blur = new BoxBlur(5, 5, 10);
        JFXDialogLayout jfxDialogLayout = new JFXDialogLayout();
        JFXButton jfxButton = new JFXButton("OK");
        JFXTextField jfxTextField = new JFXTextField();
        jfxTextField.setPromptText(promptText);

        jfxTextField.setId("text");
        jfxDialogLayout.setStyle(" -fx-background-color: rgba(0, 0, 0, 0.3);");
        JFXDialog jfxDialog = new JFXDialog(stackPane, jfxDialogLayout, JFXDialog.DialogTransition.TOP);
        jfxButton.getStyleClass().add("dialog-button");
        jfxButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> {
                    if (!jfxTextField.getText().equals("") && Account.getLoginAccount().getCollection().findDeck(jfxTextField.getText()) == null) {
                        createDeck(jfxTextField.getText());
                        jfxDialog.close();
                    } else {
                        jfxTextField.setId("wrongPassword");
                    }

                }
        );
        jfxDialog.setOnDialogClosed((JFXDialogEvent jfxEvent) -> {
            gridPane.setEffect(null);
        });
        Label label = new Label(message);
        label.setStyle("-fx-font-size: 20px; -fx-text-fill: black");
        VBox vBox = new VBox();
        vBox.getChildren().addAll(label, jfxTextField);
        jfxDialogLayout.getBody().add(vBox);
        jfxDialogLayout.setActions(jfxButton);
        jfxDialog.show();
        gridPane.setEffect(blur);
    }

    public void hero1BoxClicked() {
        hero1.setSelected(!hero1.isSelected());
        if (hero1.isSelected()) {
            hero1Box.setId("boxPendingBoughtStyle");
        } else {
            if (heroesBought[0])
                hero1Box.setId("boxBoughtStyle");
            else
                hero1Box.setId("boxNotBoughtStyle");
        }
    }

    public void hero2BoxClicked() {
        hero2.setSelected(!hero2.isSelected());
        if (hero2.isSelected()) {
            hero2Box.setId("boxPendingBoughtStyle");
        } else {
            if (heroesBought[1])
                hero2Box.setId("boxBoughtStyle");
            else
                hero2Box.setId("boxNotBoughtStyle");
        }
    }

    public void hero3BoxClicked() {
        hero3.setSelected(!hero3.isSelected());
        if (hero3.isSelected()) {
            hero3Box.setId("boxPendingBoughtStyle");
        } else {
            if (heroesBought[2])
                hero3Box.setId("boxBoughtStyle");
            else
                hero3Box.setId("boxNotBoughtStyle");
        }
    }

    public void hero4BoxClicked() {
        hero4.setSelected(!hero4.isSelected());
        if (hero4.isSelected()) {
            hero4Box.setId("boxPendingBoughtStyle");
        } else {
            if (heroesBought[3])
                hero4Box.setId("boxBoughtStyle");
            else
                hero4Box.setId("boxNotBoughtStyle");
        }
    }

    public void hero5BoxClicked() {
        hero5.setSelected(!hero5.isSelected());
        if (hero5.isSelected()) {
            hero5Box.setId("boxPendingBoughtStyle");
        } else {
            if (heroesBought[4])
                hero5Box.setId("boxBoughtStyle");
            else
                hero5Box.setId("boxNotBoughtStyle");
        }
    }

    public void hero6BoxClicked() {
        hero6.setSelected(!hero6.isSelected());
        if (hero6.isSelected()) {
            hero6Box.setId("boxPendingBoughtStyle");
        } else {
            if (heroesBought[5])
                hero6Box.setId("boxBoughtStyle");
            else
                hero6Box.setId("boxNotBoughtStyle");
        }
    }

    public void hero7BoxClicked() {
        hero7.setSelected(!hero7.isSelected());
        if (hero7.isSelected()) {
            hero7Box.setId("boxPendingBoughtStyle");
        } else {
            if (heroesBought[6])
                hero7Box.setId("boxBoughtStyle");
            else
                hero7Box.setId("boxNotBoughtStyle");
        }
    }

    public void hero8BoxClicked() {
        hero8.setSelected(!hero8.isSelected());
        if (hero8.isSelected()) {
            hero8Box.setId("boxPendingBoughtStyle");
        } else {
            if (heroesBought[7])
                hero8Box.setId("boxBoughtStyle");
            else
                hero8Box.setId("boxNotBoughtStyle");
        }
    }

    public void hero9BoxClicked() {
        hero9.setSelected(!hero9.isSelected());
        if (hero9.isSelected()) {
            hero9Box.setId("boxPendingBoughtStyle");
        } else {
            if (heroesBought[8])
                hero9Box.setId("boxBoughtStyle");
            else
                hero9Box.setId("boxNotBoughtStyle");
        }
    }

    public void hero10BoxClicked() {
        hero10.setSelected(!hero10.isSelected());
        if (hero10.isSelected()) {
            hero10Box.setId("boxPendingBoughtStyle");
        } else {
            if (heroesBought[9])
                hero10Box.setId("boxBoughtStyle");
            else
                hero10Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell1BoxClicked() {
        spell1.setSelected(!spell1.isSelected());
        if (spell1.isSelected()) {
            spell1Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[0])
                spell1Box.setId("boxBoughtStyle");
            else
                spell1Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell2BoxClicked() {
        spell2.setSelected(!spell2.isSelected());
        if (spell2.isSelected()) {
            spell2Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[1])
                spell2Box.setId("boxBoughtStyle");
            else
                spell2Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell3BoxClicked() {
        spell3.setSelected(!spell3.isSelected());
        if (spell3.isSelected()) {
            spell3Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[2])
                spell3Box.setId("boxBoughtStyle");
            else
                spell3Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell4BoxClicked() {
        spell4.setSelected(!spell4.isSelected());
        if (spell4.isSelected()) {
            spell4Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[3])
                spell4Box.setId("boxBoughtStyle");
            else
                spell4Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell5BoxClicked() {
        spell5.setSelected(!spell5.isSelected());
        if (spell5.isSelected()) {
            spell5Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[4])
                spell5Box.setId("boxBoughtStyle");
            else
                spell5Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell6BoxClicked() {
        spell6.setSelected(!spell6.isSelected());
        if (spell6.isSelected()) {
            spell6Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[5])
                spell6Box.setId("boxBoughtStyle");
            else
                spell6Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell7BoxClicked() {
        spell7.setSelected(!spell7.isSelected());
        if (spell7.isSelected()) {
            spell7Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[6])
                spell7Box.setId("boxBoughtStyle");
            else
                spell7Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell8BoxClicked() {
        spell8.setSelected(!spell8.isSelected());
        if (spell8.isSelected()) {
            spell8Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[7])
                spell8Box.setId("boxBoughtStyle");
            else
                spell8Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell9BoxClicked() {
        spell9.setSelected(!spell9.isSelected());
        if (spell9.isSelected()) {
            spell9Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[8])
                spell9Box.setId("boxBoughtStyle");
            else
                spell9Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell10BoxClicked() {
        spell10.setSelected(!spell10.isSelected());
        if (spell10.isSelected()) {
            spell10Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[9])
                spell10Box.setId("boxBoughtStyle");
            else
                spell10Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell11BoxClicked() {
        spell11.setSelected(!spell11.isSelected());
        if (spell11.isSelected()) {
            spell11Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[10])
                spell11Box.setId("boxBoughtStyle");
            else
                spell11Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell12BoxClicked() {
        spell12.setSelected(!spell12.isSelected());
        if (spell12.isSelected()) {
            spell12Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[11])
                spell12Box.setId("boxBoughtStyle");
            else
                spell12Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell13BoxClicked() {
        spell13.setSelected(!spell13.isSelected());
        if (spell13.isSelected()) {
            spell13Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[12])
                spell13Box.setId("boxBoughtStyle");
            else
                spell13Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell14BoxClicked() {
        spell14.setSelected(!spell14.isSelected());
        if (spell14.isSelected()) {
            spell14Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[13])
                spell14Box.setId("boxBoughtStyle");
            else
                spell14Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell15BoxClicked() {
        spell15.setSelected(!spell15.isSelected());
        if (spell15.isSelected()) {
            spell15Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[14])
                spell15Box.setId("boxBoughtStyle");
            else
                spell15Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell16BoxClicked() {
        spell16.setSelected(!spell16.isSelected());
        if (spell16.isSelected()) {
            spell16Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[15])
                spell16Box.setId("boxBoughtStyle");
            else
                spell16Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell17BoxClicked() {
        spell17.setSelected(!spell17.isSelected());
        if (spell17.isSelected()) {
            spell17Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[16])
                spell17Box.setId("boxBoughtStyle");
            else
                spell17Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell18BoxClicked() {
        spell18.setSelected(!spell18.isSelected());
        if (spell18.isSelected()) {
            spell18Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[17])
                spell18Box.setId("boxBoughtStyle");
            else
                spell18Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell19BoxClicked() {
        spell19.setSelected(!spell19.isSelected());
        if (spell19.isSelected()) {
            spell19Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[18])
                spell19Box.setId("boxBoughtStyle");
            else
                spell19Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell20BoxClicked() {
        spell20.setSelected(!spell20.isSelected());
        if (spell20.isSelected()) {
            spell20Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[19])
                spell20Box.setId("boxBoughtStyle");
            else
                spell20Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion1BoxClicked() {
        minion1.setSelected(!minion1.isSelected());
        if (minion1.isSelected()) {
            minion1Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[0])
                minion1Box.setId("boxBoughtStyle");
            else
                minion1Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion2BoxClicked() {
        minion2.setSelected(!minion2.isSelected());
        if (minion2.isSelected()) {
            minion2Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[1])
                minion2Box.setId("boxBoughtStyle");
            else
                minion2Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion3BoxClicked() {
        minion3.setSelected(!minion3.isSelected());
        if (minion3.isSelected()) {
            minion3Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[2])
                minion3Box.setId("boxBoughtStyle");
            else
                minion3Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion4BoxClicked() {
        minion4.setSelected(!minion4.isSelected());
        if (minion4.isSelected()) {
            minion4Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[3])
                minion4Box.setId("boxBoughtStyle");
            else
                minion4Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion5BoxClicked() {
        minion5.setSelected(!minion5.isSelected());
        if (minion5.isSelected()) {
            minion5Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[4])
                minion5Box.setId("boxBoughtStyle");
            else
                minion5Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion6BoxClicked() {
        minion6.setSelected(!minion6.isSelected());
        if (minion6.isSelected()) {
            minion6Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[5])
                minion6Box.setId("boxBoughtStyle");
            else
                minion6Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion7BoxClicked() {
        minion7.setSelected(!minion7.isSelected());
        if (minion7.isSelected()) {
            minion7Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[6])
                minion7Box.setId("boxBoughtStyle");
            else
                minion7Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion8BoxClicked() {
        minion8.setSelected(!minion8.isSelected());
        if (minion8.isSelected()) {
            minion8Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[7])
                minion8Box.setId("boxBoughtStyle");
            else
                minion8Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion9BoxClicked() {
        minion9.setSelected(!minion9.isSelected());
        if (minion9.isSelected()) {
            minion9Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[8])
                minion9Box.setId("boxBoughtStyle");
            else
                minion9Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion10BoxClicked() {
        minion10.setSelected(!minion10.isSelected());
        if (minion10.isSelected()) {
            minion10Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[9])
                minion10Box.setId("boxBoughtStyle");
            else
                minion10Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion11BoxClicked() {
        minion11.setSelected(!minion11.isSelected());
        if (minion11.isSelected()) {
            minion11Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[10])
                minion11Box.setId("boxBoughtStyle");
            else
                minion11Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion12BoxClicked() {
        minion12.setSelected(!minion12.isSelected());
        if (minion12.isSelected()) {
            minion12Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[11])
                minion12Box.setId("boxBoughtStyle");
            else
                minion12Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion13BoxClicked() {
        minion13.setSelected(!minion13.isSelected());
        if (minion13.isSelected()) {
            minion13Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[12])
                minion13Box.setId("boxBoughtStyle");
            else
                minion13Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion14BoxClicked() {
        minion14.setSelected(!minion14.isSelected());
        if (minion14.isSelected()) {
            minion14Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[13])
                minion14Box.setId("boxBoughtStyle");
            else
                minion14Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion15BoxClicked() {
        minion15.setSelected(!minion15.isSelected());
        if (minion15.isSelected()) {
            minion15Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[14])
                minion15Box.setId("boxBoughtStyle");
            else
                minion15Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion16BoxClicked() {
        minion16.setSelected(!minion16.isSelected());
        if (minion16.isSelected()) {
            minion16Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[15])
                minion16Box.setId("boxBoughtStyle");
            else
                minion16Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion17BoxClicked() {
        minion17.setSelected(!minion17.isSelected());
        if (minion17.isSelected()) {
            minion17Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[16])
                minion17Box.setId("boxBoughtStyle");
            else
                minion17Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion18BoxClicked() {
        minion18.setSelected(!minion18.isSelected());
        if (minion18.isSelected()) {
            minion18Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[17])
                minion18Box.setId("boxBoughtStyle");
            else
                minion18Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion19BoxClicked() {
        minion19.setSelected(!minion19.isSelected());
        if (minion19.isSelected()) {
            minion19Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[18])
                minion19Box.setId("boxBoughtStyle");
            else
                minion19Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion20BoxClicked() {
        minion20.setSelected(!minion20.isSelected());
        if (minion20.isSelected()) {
            minion20Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[19])
                minion20Box.setId("boxBoughtStyle");
            else
                minion20Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion21BoxClicked() {
        minion21.setSelected(!minion21.isSelected());
        if (minion21.isSelected()) {
            minion21Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[20])
                minion21Box.setId("boxBoughtStyle");
            else
                minion21Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion22BoxClicked() {
        minion22.setSelected(!minion22.isSelected());
        if (minion22.isSelected()) {
            minion22Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[21])
                minion22Box.setId("boxBoughtStyle");
            else
                minion22Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion23BoxClicked() {
        minion23.setSelected(!minion23.isSelected());
        if (minion23.isSelected()) {
            minion23Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[22])
                minion23Box.setId("boxBoughtStyle");
            else
                minion23Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion24BoxClicked() {
        minion24.setSelected(!minion24.isSelected());
        if (minion24.isSelected()) {
            minion24Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[23])
                minion24Box.setId("boxBoughtStyle");
            else
                minion24Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion25BoxClicked() {
        minion25.setSelected(!minion25.isSelected());
        if (minion25.isSelected()) {
            minion25Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[24])
                minion25Box.setId("boxBoughtStyle");
            else
                minion25Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion26BoxClicked() {
        minion26.setSelected(!minion26.isSelected());
        if (minion26.isSelected()) {
            minion26Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[25])
                minion26Box.setId("boxBoughtStyle");
            else
                minion26Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion27BoxClicked() {
        minion27.setSelected(!minion27.isSelected());
        if (minion27.isSelected()) {
            minion27Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[26])
                minion27Box.setId("boxBoughtStyle");
            else
                minion27Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion28BoxClicked() {
        minion28.setSelected(!minion28.isSelected());
        if (minion28.isSelected()) {
            minion28Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[27])
                minion28Box.setId("boxBoughtStyle");
            else
                minion28Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion29BoxClicked() {
        minion29.setSelected(!minion29.isSelected());
        if (minion29.isSelected()) {
            minion29Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[28])
                minion29Box.setId("boxBoughtStyle");
            else
                minion29Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion30BoxClicked() {
        minion30.setSelected(!minion30.isSelected());
        if (minion30.isSelected()) {
            minion30Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[29])
                minion30Box.setId("boxBoughtStyle");
            else
                minion30Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion31BoxClicked() {
        minion31.setSelected(!minion31.isSelected());
        if (minion31.isSelected()) {
            minion31Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[30])
                minion31Box.setId("boxBoughtStyle");
            else
                minion31Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion32BoxClicked() {
        minion32.setSelected(!minion32.isSelected());
        if (minion32.isSelected()) {
            minion32Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[31])
                minion32Box.setId("boxBoughtStyle");
            else
                minion32Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion33BoxClicked() {
        minion33.setSelected(!minion33.isSelected());
        if (minion33.isSelected()) {
            minion33Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[32])
                minion33Box.setId("boxBoughtStyle");
            else
                minion33Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion34BoxClicked() {
        minion34.setSelected(!minion34.isSelected());
        if (minion34.isSelected()) {
            minion34Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[33])
                minion34Box.setId("boxBoughtStyle");
            else
                minion34Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion35BoxClicked() {
        minion35.setSelected(!minion35.isSelected());
        if (minion35.isSelected()) {
            minion35Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[34])
                minion35Box.setId("boxBoughtStyle");
            else
                minion35Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion36BoxClicked() {
        minion36.setSelected(!minion36.isSelected());
        if (minion36.isSelected()) {
            minion36Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[35])
                minion36Box.setId("boxBoughtStyle");
            else
                minion36Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion37BoxClicked() {
        minion37.setSelected(!minion37.isSelected());
        if (minion37.isSelected()) {
            minion37Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[36])
                minion37Box.setId("boxBoughtStyle");
            else
                minion37Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion38BoxClicked() {
        minion38.setSelected(!minion38.isSelected());
        if (minion38.isSelected()) {
            minion38Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[37])
                minion38Box.setId("boxBoughtStyle");
            else
                minion38Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion39BoxClicked() {
        minion39.setSelected(!minion39.isSelected());
        if (minion39.isSelected()) {
            minion39Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[38])
                minion39Box.setId("boxBoughtStyle");
            else
                minion39Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion40BoxClicked() {
        minion40.setSelected(!minion40.isSelected());
        if (minion40.isSelected()) {
            minion40Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[39])
                minion40Box.setId("boxBoughtStyle");
            else
                minion40Box.setId("boxNotBoughtStyle");
        }
    }

    public void item1BoxClicked() {
        item1.setSelected(!item1.isSelected());
        if (item1.isSelected()) {
            item1Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[0])
                item1Box.setId("boxBoughtStyle");
            else
                item1Box.setId("boxNotBoughtStyle");
        }
    }

    public void item2BoxClicked() {
        item2.setSelected(!item2.isSelected());
        if (item2.isSelected()) {
            item2Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[1])
                item2Box.setId("boxBoughtStyle");
            else
                item2Box.setId("boxNotBoughtStyle");
        }
    }

    public void item3BoxClicked() {
        item3.setSelected(!item3.isSelected());
        if (item3.isSelected()) {
            item3Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[2])
                item3Box.setId("boxBoughtStyle");
            else
                item3Box.setId("boxNotBoughtStyle");
        }
    }

    public void item4BoxClicked() {
        item4.setSelected(!item4.isSelected());
        if (item4.isSelected()) {
            item4Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[3])
                item4Box.setId("boxBoughtStyle");
            else
                item4Box.setId("boxNotBoughtStyle");
        }
    }

    public void item5BoxClicked() {
        item5.setSelected(!item5.isSelected());
        if (item5.isSelected()) {
            item5Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[4])
                item5Box.setId("boxBoughtStyle");
            else
                item5Box.setId("boxNotBoughtStyle");
        }
    }

    public void item6BoxClicked() {
        item6.setSelected(!item6.isSelected());
        if (item6.isSelected()) {
            item6Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[5])
                item6Box.setId("boxBoughtStyle");
            else
                item6Box.setId("boxNotBoughtStyle");
        }
    }

    public void item7BoxClicked() {
        item7.setSelected(!item7.isSelected());
        if (item7.isSelected()) {
            item7Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[6])
                item7Box.setId("boxBoughtStyle");
            else
                item7Box.setId("boxNotBoughtStyle");
        }
    }

    public void item8BoxClicked() {
        item8.setSelected(!item8.isSelected());
        if (item8.isSelected()) {
            item8Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[7])
                item8Box.setId("boxBoughtStyle");
            else
                item8Box.setId("boxNotBoughtStyle");
        }
    }

    public void item9BoxClicked() {
        item9.setSelected(!item9.isSelected());
        if (item9.isSelected()) {
            item9Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[8])
                item9Box.setId("boxBoughtStyle");
            else
                item9Box.setId("boxNotBoughtStyle");
        }
    }

    public void item10BoxClicked() {
        item10.setSelected(!item10.isSelected());
        if (item10.isSelected()) {
            item10Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[9])
                item10Box.setId("boxBoughtStyle");
            else
                item10Box.setId("boxNotBoughtStyle");
        }
    }

    public void item11BoxClicked() {
        item11.setSelected(!item11.isSelected());
        if (item11.isSelected()) {
            item11Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[10])
                item11Box.setId("boxBoughtStyle");
            else
                item11Box.setId("boxNotBoughtStyle");
        }
    }


    public void hero1CheckBox() {
        if (hero1.isSelected()) {
            hero1Box.setId("boxPendingBoughtStyle");
        } else {
            if (heroesBought[0])
                hero1Box.setId("boxBoughtStyle");
            else
                hero1Box.setId("boxNotBoughtStyle");
        }
    }

    public void hero2CheckBox() {
        if (hero2.isSelected()) {
            hero2Box.setId("boxPendingBoughtStyle");
        } else {
            if (heroesBought[1])
                hero2Box.setId("boxBoughtStyle");
            else
                hero2Box.setId("boxNotBoughtStyle");
        }
    }

    public void hero3CheckBox() {
        if (hero3.isSelected()) {
            hero3Box.setId("boxPendingBoughtStyle");
        } else {
            if (heroesBought[2])
                hero3Box.setId("boxBoughtStyle");
            else
                hero3Box.setId("boxNotBoughtStyle");
        }
    }

    public void hero4CheckBox() {
        if (hero4.isSelected()) {
            hero4Box.setId("boxPendingBoughtStyle");
        } else {
            if (heroesBought[3])
                hero4Box.setId("boxBoughtStyle");
            else
                hero4Box.setId("boxNotBoughtStyle");
        }
    }

    public void hero5CheckBox() {
        if (hero5.isSelected()) {
            hero5Box.setId("boxPendingBoughtStyle");
        } else {
            if (heroesBought[4])
                hero5Box.setId("boxBoughtStyle");
            else
                hero5Box.setId("boxNotBoughtStyle");
        }
    }

    public void hero6CheckBox() {
        if (hero6.isSelected()) {
            hero6Box.setId("boxPendingBoughtStyle");
        } else {
            if (heroesBought[5])
                hero6Box.setId("boxBoughtStyle");
            else
                hero6Box.setId("boxNotBoughtStyle");
        }
    }

    public void hero7CheckBox() {
        if (hero7.isSelected()) {
            hero7Box.setId("boxPendingBoughtStyle");
        } else {
            if (heroesBought[6])
                hero7Box.setId("boxBoughtStyle");
            else
                hero7Box.setId("boxNotBoughtStyle");
        }
    }

    public void hero8CheckBox() {
        if (hero8.isSelected()) {
            hero8Box.setId("boxPendingBoughtStyle");
        } else {
            if (heroesBought[7])
                hero8Box.setId("boxBoughtStyle");
            else
                hero8Box.setId("boxNotBoughtStyle");
        }
    }

    public void hero9CheckBox() {
        if (hero9.isSelected()) {
            hero9Box.setId("boxPendingBoughtStyle");
        } else {
            if (heroesBought[8])
                hero9Box.setId("boxBoughtStyle");
            else
                hero9Box.setId("boxNotBoughtStyle");
        }
    }

    public void hero10CheckBox() {
        if (hero10.isSelected()) {
            hero10Box.setId("boxPendingBoughtStyle");
        } else {
            if (heroesBought[9])
                hero10Box.setId("boxBoughtStyle");
            else
                hero10Box.setId("boxNotBoughtStyle");
        }
    }

    public void item1CheckBox() {
        if (item1.isSelected()) {
            item1Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[0])
                item1Box.setId("boxBoughtStyle");
            else
                item1Box.setId("boxNotBoughtStyle");
        }
    }

    public void item2CheckBox() {
        if (item2.isSelected()) {
            item2Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[1])
                item2Box.setId("boxBoughtStyle");
            else
                item2Box.setId("boxNotBoughtStyle");
        }
    }

    public void item3CheckBox() {
        if (item3.isSelected()) {
            item3Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[2])
                item3Box.setId("boxBoughtStyle");
            else
                item3Box.setId("boxNotBoughtStyle");
        }
    }

    public void item4CheckBox() {
        if (item4.isSelected()) {
            item4Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[3])
                item4Box.setId("boxBoughtStyle");
            else
                item4Box.setId("boxNotBoughtStyle");
        }
    }

    public void item5CheckBox() {
        if (item5.isSelected()) {
            item5Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[4])
                item5Box.setId("boxBoughtStyle");
            else
                item5Box.setId("boxNotBoughtStyle");
        }
    }

    public void item6CheckBox() {
        if (item6.isSelected()) {
            item6Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[5])
                item6Box.setId("boxBoughtStyle");
            else
                item6Box.setId("boxNotBoughtStyle");
        }
    }

    public void item7CheckBox() {
        if (item7.isSelected()) {
            item7Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[6])
                item7Box.setId("boxBoughtStyle");
            else
                item7Box.setId("boxNotBoughtStyle");
        }
    }

    public void item8CheckBox() {
        if (item8.isSelected()) {
            item8Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[7])
                item8Box.setId("boxBoughtStyle");
            else
                item8Box.setId("boxNotBoughtStyle");
        }
    }

    public void item9CheckBox() {
        if (item9.isSelected()) {
            item9Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[8])
                item9Box.setId("boxBoughtStyle");
            else
                item9Box.setId("boxNotBoughtStyle");
        }
    }

    public void item10CheckBox() {
        if (item10.isSelected()) {
            item10Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[9])
                item10Box.setId("boxBoughtStyle");
            else
                item10Box.setId("boxNotBoughtStyle");
        }
    }

    public void item11CheckBox() {
        if (item11.isSelected()) {
            item11Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[10])
                item11Box.setId("boxBoughtStyle");
            else
                item11Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion1CheckBox() {
        if (minion1.isSelected()) {
            minion1Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[0])
                minion1Box.setId("boxBoughtStyle");
            else
                minion1Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion2CheckBox() {
        if (minion2.isSelected()) {
            minion2Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[1])
                minion2Box.setId("boxBoughtStyle");
            else
                minion2Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion3CheckBox() {
        if (minion3.isSelected()) {
            minion3Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[2])
                minion3Box.setId("boxBoughtStyle");
            else
                minion3Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion4CheckBox() {
        if (minion4.isSelected()) {
            minion4Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[3])
                minion4Box.setId("boxBoughtStyle");
            else
                minion4Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion5CheckBox() {
        if (minion5.isSelected()) {
            minion5Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[4])
                minion5Box.setId("boxBoughtStyle");
            else
                minion5Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion6CheckBox() {
        if (minion6.isSelected()) {
            minion6Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[5])
                minion6Box.setId("boxBoughtStyle");
            else
                minion6Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion7CheckBox() {
        if (minion7.isSelected()) {
            minion7Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[6])
                minion7Box.setId("boxBoughtStyle");
            else
                minion7Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion8CheckBox() {
        if (minion8.isSelected()) {
            minion8Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[7])
                minion8Box.setId("boxBoughtStyle");
            else
                minion8Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion9CheckBox() {
        if (minion9.isSelected()) {
            minion9Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[8])
                minion9Box.setId("boxBoughtStyle");
            else
                minion9Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion10CheckBox() {
        if (minion10.isSelected()) {
            minion10Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[9])
                minion10Box.setId("boxBoughtStyle");
            else
                minion10Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion11CheckBox() {
        if (minion11.isSelected()) {
            minion11Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[10])
                minion11Box.setId("boxBoughtStyle");
            else
                minion11Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion12CheckBox() {
        if (minion12.isSelected()) {
            minion12Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[11])
                minion12Box.setId("boxBoughtStyle");
            else
                minion12Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion13CheckBox() {
        if (minion13.isSelected()) {
            minion13Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[12])
                minion13Box.setId("boxBoughtStyle");
            else
                minion13Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion14CheckBox() {
        if (minion14.isSelected()) {
            minion14Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[13])
                minion14Box.setId("boxBoughtStyle");
            else
                minion14Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion15CheckBox() {
        if (minion15.isSelected()) {
            minion15Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[14])
                minion15Box.setId("boxBoughtStyle");
            else
                minion15Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion16CheckBox() {
        if (minion16.isSelected()) {
            minion16Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[15])
                minion16Box.setId("boxBoughtStyle");
            else
                minion16Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion17CheckBox() {
        if (minion17.isSelected()) {
            minion17Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[16])
                minion17Box.setId("boxBoughtStyle");
            else
                minion17Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion18CheckBox() {
        if (minion18.isSelected()) {
            minion18Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[17])
                minion18Box.setId("boxBoughtStyle");
            else
                minion18Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion19CheckBox() {
        if (minion19.isSelected()) {
            minion19Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[18])
                minion19Box.setId("boxBoughtStyle");
            else
                minion19Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion20CheckBox() {
        if (minion20.isSelected()) {
            minion20Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[19])
                minion20Box.setId("boxBoughtStyle");
            else
                minion20Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion21CheckBox() {
        if (minion21.isSelected()) {
            minion21Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[20])
                minion21Box.setId("boxBoughtStyle");
            else
                minion21Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion22CheckBox() {
        if (minion22.isSelected()) {
            minion22Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[21])
                minion22Box.setId("boxBoughtStyle");
            else
                minion22Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion23CheckBox() {
        if (minion23.isSelected()) {
            minion23Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[22])
                minion23Box.setId("boxBoughtStyle");
            else
                minion23Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion24CheckBox() {
        if (minion24.isSelected()) {
            minion24Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[23])
                minion24Box.setId("boxBoughtStyle");
            else
                minion24Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion25CheckBox() {
        if (minion25.isSelected()) {
            minion25Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[24])
                minion25Box.setId("boxBoughtStyle");
            else
                minion25Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion26CheckBox() {
        if (minion26.isSelected()) {
            minion26Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[25])
                minion26Box.setId("boxBoughtStyle");
            else
                minion26Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion27CheckBox() {
        if (minion27.isSelected()) {
            minion27Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[26])
                minion27Box.setId("boxBoughtStyle");
            else
                minion27Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion28CheckBox() {
        if (minion28.isSelected()) {
            minion28Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[27])
                minion28Box.setId("boxBoughtStyle");
            else
                minion28Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion29CheckBox() {
        if (minion29.isSelected()) {
            minion29Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[28])
                minion29Box.setId("boxBoughtStyle");
            else
                minion29Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion30CheckBox() {
        if (minion30.isSelected()) {
            minion30Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[29])
                minion30Box.setId("boxBoughtStyle");
            else
                minion30Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion31CheckBox() {
        if (minion31.isSelected()) {
            minion31Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[30])
                minion31Box.setId("boxBoughtStyle");
            else
                minion31Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion32CheckBox() {
        if (minion32.isSelected()) {
            minion32Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[31])
                minion32Box.setId("boxBoughtStyle");
            else
                minion32Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion33CheckBox() {
        if (minion33.isSelected()) {
            minion33Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[32])
                minion33Box.setId("boxBoughtStyle");
            else
                minion33Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion34CheckBox() {
        minion34.setSelected(!minion34.isSelected());
        if (minion34.isSelected()) {
            minion34Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[33])
                minion34Box.setId("boxBoughtStyle");
            else
                minion34Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion35CheckBox() {
        if (minion35.isSelected()) {
            minion35Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[34])
                minion35Box.setId("boxBoughtStyle");
            else
                minion35Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion36CheckBox() {
        if (minion36.isSelected()) {
            minion36Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[35])
                minion36Box.setId("boxBoughtStyle");
            else
                minion36Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion37CheckBox() {
        if (minion37.isSelected()) {
            minion37Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[36])
                minion37Box.setId("boxBoughtStyle");
            else
                minion37Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion38CheckBox() {
        if (minion38.isSelected()) {
            minion38Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[37])
                minion38Box.setId("boxBoughtStyle");
            else
                minion38Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion39CheckBox() {
        if (minion39.isSelected()) {
            minion39Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[38])
                minion39Box.setId("boxBoughtStyle");
            else
                minion39Box.setId("boxNotBoughtStyle");
        }
    }

    public void minion40CheckBox() {
        if (minion40.isSelected()) {
            minion40Box.setId("boxPendingBoughtStyle");
        } else {
            if (minionsBought[39])
                minion40Box.setId("boxBoughtStyle");
            else
                minion40Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell1CheckBox() {
        if (spell1.isSelected()) {
            spell1Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[0])
                spell1Box.setId("boxBoughtStyle");
            else
                spell1Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell2CheckBox() {
        if (spell2.isSelected()) {
            spell2Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[1])
                spell2Box.setId("boxBoughtStyle");
            else
                spell2Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell3CheckBox() {
        if (spell3.isSelected()) {
            spell3Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[2])
                spell3Box.setId("boxBoughtStyle");
            else
                spell3Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell4CheckBox() {
        if (spell4.isSelected()) {
            spell4Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[3])
                spell4Box.setId("boxBoughtStyle");
            else
                spell4Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell5CheckBox() {
        if (spell5.isSelected()) {
            spell5Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[4])
                spell5Box.setId("boxBoughtStyle");
            else
                spell5Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell6CheckBox() {
        if (spell6.isSelected()) {
            spell6Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[5])
                spell6Box.setId("boxBoughtStyle");
            else
                spell6Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell7CheckBox() {
        if (spell7.isSelected()) {
            spell7Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[6])
                spell7Box.setId("boxBoughtStyle");
            else
                spell7Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell8CheckBox() {
        if (spell8.isSelected()) {
            spell8Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[7])
                spell8Box.setId("boxBoughtStyle");
            else
                spell8Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell9CheckBox() {
        if (spell9.isSelected()) {
            spell9Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[8])
                spell9Box.setId("boxBoughtStyle");
            else
                spell9Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell10CheckBox() {
        if (spell10.isSelected()) {
            spell10Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[9])
                spell10Box.setId("boxBoughtStyle");
            else
                spell10Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell11CheckBox() {
        if (spell11.isSelected()) {
            spell11Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[10])
                spell11Box.setId("boxBoughtStyle");
            else
                spell11Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell12CheckBox() {
        if (spell12.isSelected()) {
            spell12Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[11])
                spell12Box.setId("boxBoughtStyle");
            else
                spell12Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell13CheckBox() {
        if (spell13.isSelected()) {
            spell13Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[12])
                spell13Box.setId("boxBoughtStyle");
            else
                spell13Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell14CheckBox() {
        if (spell14.isSelected()) {
            spell14Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[13])
                spell14Box.setId("boxBoughtStyle");
            else
                spell14Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell15CheckBox() {
        if (spell15.isSelected()) {
            spell15Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[14])
                spell15Box.setId("boxBoughtStyle");
            else
                spell15Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell16CheckBox() {
        if (spell16.isSelected()) {
            spell16Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[15])
                spell16Box.setId("boxBoughtStyle");
            else
                spell16Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell17CheckBox() {
        if (spell17.isSelected()) {
            spell17Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[16])
                spell17Box.setId("boxBoughtStyle");
            else
                spell17Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell18CheckBox() {
        if (spell18.isSelected()) {
            spell18Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[17])
                spell18Box.setId("boxBoughtStyle");
            else
                spell18Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell19CheckBox() {
        if (spell19.isSelected()) {
            spell19Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[18])
                spell19Box.setId("boxBoughtStyle");
            else
                spell19Box.setId("boxNotBoughtStyle");
        }
    }

    public void spell20CheckBox() {
        if (spell20.isSelected()) {
            spell20Box.setId("boxPendingBoughtStyle");
        } else {
            if (spellsBought[19])
                spell20Box.setId("boxBoughtStyle");
            else
                spell20Box.setId("boxNotBoughtStyle");
        }
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

    public void addBtnActFocus() {
        addButton.requestFocus();

    }

    public void createBtnActFocus() {
        createButton.requestFocus();
    }

    public void deleteBtnActFocus() {
        deleteButton.requestFocus();
    }

    public ImageView crossImage;
    public ImageView addImage;

    public void crossBtnActFocus() {
        crossButton.requestFocus();
    }

    public void setMainBtnActFocus() {
        setMainButton.requestFocus();
    }

    public void mainMenuBtnActFocus() {
        mainMenuButton.requestFocus();
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

    public void handleOnKeyPressedMainMenu(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            mainMenuAct();
        }
    }

    public void handleOnKeyPressedAdd(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            addBtnAct();
        }
    }

    public void handleOnKeyPressedDelete(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            deleteBtnAct();
        }
    }

    public void handleOnKeyPressedCross(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            crossBtnAct();
        }
    }

    public void crossBtnAct() {
        for (Node ignored : deckBox.getChildren()) {
            HBox hBox = (HBox) ignored;
            if (((CheckBox) hBox.getChildren().get(0)).isSelected()) {
                String cardName = ((Label) (hBox.getChildren().get(2))).getText().replaceAll("\\s", "").toLowerCase();
                Account.getLoginAccount().getCollection().removeFromDeck(cardName, this.currentDeck.getName());
                deckBox.getChildren().remove(hBox);
            }
        }
    }

    public void handleOnKeyPressedCreate(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            createBtnAct();
        }
    }

    public void createBtnAct() {
        showDialog("DECK NAME... ", "ENTER A NAME FOR A NEW DECK :\n");
    }

    public void createDeck(String deckName) {
        Deck deck = new Deck();
        deck.setName(deckName);
        Account.getLoginAccount().getCollection().addDeck(deck);
        myDecks = Account.getLoginAccount().getCollection().getDecks();
        deckList.getItems().add(deckName);
        currentDeck = deck;
        reChooseComboBox();
    }

    public void handleOnKeyPressedSetMain(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            setMainBtnAct();
        }
    }

    public void addBtnAct() {
        for (VBox vBox : heroBoxes) {
            if (((CheckBox) vBox.getChildren().get(0)).isSelected() && currentDeck != null) {
                String string = ((Label) (vBox.getChildren().get(2))).getText().split("\\n")[0].replaceAll("\\s", "").toLowerCase();
                Account.getLoginAccount().getCollection().addToDeck(string, currentDeck.getName());
                showCard(string, 0);
                ((CheckBox) vBox.getChildren().get(0)).setSelected(false);
            }
        }
        for (VBox vBox : minionBoxes) {
            if (((CheckBox) vBox.getChildren().get(0)).isSelected() && currentDeck != null) {
                String string = ((Label) (vBox.getChildren().get(2))).getText().split("\\n")[0].replaceAll("\\s", "").toLowerCase();
                Account.getLoginAccount().getCollection().addToDeck(string, currentDeck.getName());
                showCard(string, 1);
                ((CheckBox) vBox.getChildren().get(0)).setSelected(false);
            }
        }
        for (VBox vBox : spellBoxes) {
            if (((CheckBox) vBox.getChildren().get(0)).isSelected() && currentDeck != null) {
                String string = ((Label) (vBox.getChildren().get(2))).getText().split("\\n")[0].replaceAll("\\s", "").toLowerCase();
                Account.getLoginAccount().getCollection().addToDeck(string, currentDeck.getName());
                showCard(string, 2);
                ((CheckBox) vBox.getChildren().get(0)).setSelected(false);
            }
        }
        for (VBox vBox : itemBoxes) {
            if (((CheckBox) vBox.getChildren().get(0)).isSelected()) {
                String string = ((Label) (vBox.getChildren().get(2))).getText().split("\\n")[0].replaceAll("\\s", "").toLowerCase();
                Account.getLoginAccount().getCollection().addToDeck(string, currentDeck.getName());
                showCard(string, 3);
                ((CheckBox) vBox.getChildren().get(0)).setSelected(false);
            }
        }
    }

    private void showCard(String cardName, int type) {//0 hero 1 minion 2 spell 3 item
        HBox hBox = new HBox();
        hBox.setId("boxBoughtStyle");
        CheckBox checkBox = new CheckBox();
        checkBox.setAlignment(Pos.CENTER);
        checkBox.setPadding(new Insets(40, 0, 0, 20));
        ImageView imageView;
        if (type == 0) {
            imageView = new ImageView(new Image("Duelyst/css/heroDeck.jpg"));
        } else if (type == 1) {
            imageView = new ImageView(new Image("Duelyst/css/minionDeck.jpg"));
        } else if (type == 2) {
            imageView = new ImageView(new Image("Duelyst/css/spellDeck.jpg"));
        } else {
            imageView = new ImageView(new Image("Duelyst/css/itemDeck.jpg"));
        }
        imageView.setPreserveRatio(true);
        imageView.setPickOnBounds(true);
        imageView.setFitHeight(200);
        Label label = new Label(cardName);
        label.setId("label-deck");
        label.setPadding(new Insets(70, 20, 0, 20));
        hBox.getChildren().addAll(checkBox, imageView, label);
        deckBox.getChildren().addAll(hBox);
    }

    public void deleteBtnAct() {
        for (Deck deck : myDecks) {
            if (deck.getName().equals(deckList.getValue())) {
                deckList.getItems().remove(deckList.getValue());
                myDecks.remove(deck);
                reChooseComboBox();
                deckBox.getChildren().clear();
                return;
            }

            if (deckList.getValue().equals("*" + deck.getName() + "*")) {
                deckList.getItems().remove(deck.getName());
                Account.getLoginAccount().getCollection().deleteDeck(deck.getName());
                myDecks = Account.getLoginAccount().getCollection().getDecks();
                Account.getLoginAccount().setMainDeck(null);
                reChooseComboBox();
                deckBox.getChildren().clear();
                return;
            }
        }

    }

    private void showDialog(String string) {
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
        jfxDialog.show();
        gridPane.setEffect(blur);
    }

    public void setMainBtnAct() {
        if (currentDeck.isValid()) {
            Account.getLoginAccount().setMainDeck(currentDeck);
            reChooseComboBox();
        } else {
            showDialog("Chosen Deck Is Invalid \nPlease Choose a valid deck 0_0");
        }
    }
}