package Duelyst.Controller;

import Duelyst.View.View;
import Duelyst.model.Account;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class ShopController {
    public boolean[] heroesBought = new boolean[10];
    public boolean[] itemsBought = new boolean[12];


    @FXML
    public ScrollPane heroes;
    public ScrollPane minions;
    public ScrollPane spells;
    public ScrollPane items;

    @FXML
    public Button button1;
    @FXML
    public Button button2;
    @FXML
    public Button button3;
    @FXML
    public Button button4;
    @FXML
    public Button button5;
    @FXML
    public Button button6;
    @FXML
    public Button button7;

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
    public VBox item12Box;
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


    public void initialize() {
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
        for (int i = 0; i < 10; i++) {
            if (Account.getLoginAccount().getCollection().hasThisCard
                    (((Label) (heroBoxes[i].getChildren().get(2))).getText().toLowerCase())) {
                heroesBought[i] = true;
            }
        }
        for (int i = 0; i < 11; i++) {
            if (Account.getLoginAccount().getCollection().hasThisCard
                    (((Label) (itemBoxes[i].getChildren().get(2))).getText().toLowerCase())) {
                itemsBought[i] = true;
            }
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

    public void sellBtnAct() {

    }

    public void buyBtnAct() {

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


    public void hero1CheckBoxClicked() {
        if (hero1.isSelected()) {
            hero1Box.setId("boxPendingBoughtStyle");
        } else {
            if (heroesBought[0])
                hero1Box.setId("boxBoughtStyle");
            else
                hero1Box.setId("boxNotBoughtStyle");
        }
    }

    public void hero2CheckBoxClicked() {
        if (hero2.isSelected()) {
            hero2Box.setId("boxPendingBoughtStyle");
        } else {
            if (heroesBought[1])
                hero2Box.setId("boxBoughtStyle");
            else
                hero2Box.setId("boxNotBoughtStyle");
        }
    }

    public void hero3CheckBoxClicked() {
        if (hero3.isSelected()) {
            hero3Box.setId("boxPendingBoughtStyle");
        } else {
            if (heroesBought[2])
                hero3Box.setId("boxBoughtStyle");
            else
                hero3Box.setId("boxNotBoughtStyle");
        }
    }

    public void hero4CheckBoxClicked() {
        if (hero4.isSelected()) {
            hero4Box.setId("boxPendingBoughtStyle");
        } else {
            if (heroesBought[3])
                hero4Box.setId("boxBoughtStyle");
            else
                hero4Box.setId("boxNotBoughtStyle");
        }
    }

    public void hero5CheckBoxClicked() {
        if (hero5.isSelected()) {
            hero5Box.setId("boxPendingBoughtStyle");
        } else {
            if (heroesBought[4])
                hero5Box.setId("boxBoughtStyle");
            else
                hero5Box.setId("boxNotBoughtStyle");
        }
    }

    public void hero6CheckBoxClicked() {
        if (hero6.isSelected()) {
            hero6Box.setId("boxPendingBoughtStyle");
        } else {
            if (heroesBought[5])
                hero6Box.setId("boxBoughtStyle");
            else
                hero6Box.setId("boxNotBoughtStyle");
        }
    }

    public void hero7CheckBoxClicked() {
        if (hero7.isSelected()) {
            hero7Box.setId("boxPendingBoughtStyle");
        } else {
            if (heroesBought[6])
                hero7Box.setId("boxBoughtStyle");
            else
                hero7Box.setId("boxNotBoughtStyle");
        }
    }

    public void hero8CheckBoxClicked() {
        if (hero8.isSelected()) {
            hero8Box.setId("boxPendingBoughtStyle");
        } else {
            if (heroesBought[7])
                hero8Box.setId("boxBoughtStyle");
            else
                hero8Box.setId("boxNotBoughtStyle");
        }
    }

    public void hero9CheckBoxClicked() {
        if (hero9.isSelected()) {
            hero9Box.setId("boxPendingBoughtStyle");
        } else {
            if (heroesBought[8])
                hero9Box.setId("boxBoughtStyle");
            else
                hero9Box.setId("boxNotBoughtStyle");
        }
    }

    public void hero10CheckBoxClicked() {
        if (hero10.isSelected()) {
            hero10Box.setId("boxPendingBoughtStyle");
        } else {
            if (heroesBought[9])
                hero10Box.setId("boxBoughtStyle");
            else
                hero10Box.setId("boxNotBoughtStyle");
        }
    }

    public void item1CheckBoxClicked() {
        if (item1.isSelected()) {
            item1Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[0])
                item1Box.setId("boxBoughtStyle");
            else
                item1Box.setId("boxNotBoughtStyle");
        }
    }

    public void item2CheckBoxClicked() {
        if (item2.isSelected()) {
            item2Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[1])
                item2Box.setId("boxBoughtStyle");
            else
                item2Box.setId("boxNotBoughtStyle");
        }
    }

    public void item3CheckBoxClicked() {
        if (item3.isSelected()) {
            item3Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[2])
                item3Box.setId("boxBoughtStyle");
            else
                item3Box.setId("boxNotBoughtStyle");
        }
    }

    public void item4CheckBoxClicked() {
        if (item4.isSelected()) {
            item4Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[3])
                item4Box.setId("boxBoughtStyle");
            else
                item4Box.setId("boxNotBoughtStyle");
        }
    }

    public void item5CheckBoxClicked() {
        if (item5.isSelected()) {
            item5Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[4])
                item5Box.setId("boxBoughtStyle");
            else
                item5Box.setId("boxNotBoughtStyle");
        }
    }

    public void item6CheckBoxClicked() {
        if (item6.isSelected()) {
            item6Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[5])
                item6Box.setId("boxBoughtStyle");
            else
                item6Box.setId("boxNotBoughtStyle");
        }
    }

    public void item7CheckBoxClicked() {
        if (item7.isSelected()) {
            item7Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[6])
                item7Box.setId("boxBoughtStyle");
            else
                item7Box.setId("boxNotBoughtStyle");
        }
    }

    public void item8CheckBoxClicked() {
        if (item8.isSelected()) {
            item8Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[7])
                item8Box.setId("boxBoughtStyle");
            else
                item8Box.setId("boxNotBoughtStyle");
        }
    }

    public void item9CheckBoxClicked() {
        if (item9.isSelected()) {
            item9Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[8])
                item9Box.setId("boxBoughtStyle");
            else
                item9Box.setId("boxNotBoughtStyle");
        }
    }

    public void item10CheckBoxClicked() {
        if (item10.isSelected()) {
            item10Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[9])
                item10Box.setId("boxBoughtStyle");
            else
                item10Box.setId("boxNotBoughtStyle");
        }
    }

    public void item11CheckBoxClicked() {
        if (item11.isSelected()) {
            item11Box.setId("boxPendingBoughtStyle");
        } else {
            if (itemsBought[10])
                item11Box.setId("boxBoughtStyle");
            else
                item11Box.setId("boxNotBoughtStyle");
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

    public void sellBtnActFocus() {
        button6.requestFocus();
    }

    public void buyBtnActFocus() {
        button5.requestFocus();
    }

    public void mainMenuBtnActFocus() {
        button7.requestFocus();
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


    public void handleOnKeyPressedSell(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            sellBtnAct();
        }
    }


    public void handleOnKeyPressedBuy(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            buyBtnAct();
        }
    }


}
