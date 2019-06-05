package Duelyst.Controller;

import Duelyst.View.View;
import Duelyst.model.Account;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class ShopController {
    @FXML
    public ScrollPane heroes;
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
    void showHeros() {

    }

    @FXML
    void showItems() {

    }

    @FXML
    void showMinions() {

    }

    @FXML
    void showSpells() {

    }

    public void mainMenuAct() {
        View.makeMainMenu();
    }

    public void hero1BoxClicked() {
        hero1.setSelected(!hero1.isSelected());
        if (hero1.isSelected()) {

        }
    }
}
