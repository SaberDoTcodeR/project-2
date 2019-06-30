package DuelystServer.messages;

import DuelystServer.model.Account;
import DuelystServer.model.Shop;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ShopMessage extends AccountMessage {

    private ArrayList<VBox> heroes;
    private ArrayList<VBox> minions;
    private ArrayList<VBox> spells;
    private ArrayList<VBox> items;
    private ArrayList<String> notEnoughMoney;
    private ArrayList<String> alreadyHaveThisCard;
    private ArrayList<Boolean> heroesBought;
    private ArrayList<Boolean> minionsBought;
    private ArrayList<Boolean> spellsBought;
    private ArrayList<Boolean> itemsBought;

    public ArrayList<Boolean> getHeroesBought() {
        return heroesBought;
    }

    public ArrayList<Boolean> getMinionsBought() {
        return minionsBought;
    }

    public ArrayList<Boolean> getSpellsBought() {
        return spellsBought;
    }

    public ArrayList<Boolean> getItemsBought() {
        return itemsBought;
    }

    public void setHeroesBought(ArrayList<Boolean> heroesBought) {
        this.heroesBought = heroesBought;
    }

    public void setMinionsBought(ArrayList<Boolean> minionsBought) {
        this.minionsBought = minionsBought;
    }

    public void setSpellsBought(ArrayList<Boolean> spellsBought) {
        this.spellsBought = spellsBought;
    }

    public void setItemsBought(ArrayList<Boolean> itemsBought) {
        this.itemsBought = itemsBought;
    }

    public ShopMessage(boolean signUpOrLogIn, String user, String pass) {
        super(signUpOrLogIn, user, pass);
    }

    public ArrayList<VBox> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<VBox> heroes) {
        this.heroes = heroes;
    }

    public ArrayList<VBox> getMinions() {
        return minions;
    }

    public void setMinions(ArrayList<VBox> minions) {
        this.minions = minions;
    }

    public ArrayList<VBox> getSpells() {
        return spells;
    }

    public void setSpells(ArrayList<VBox> spells) {
        this.spells = spells;
    }

    public ArrayList<VBox> getItems() {
        return items;
    }

    public void setItems(ArrayList<VBox> items) {
        this.items = items;
    }

    public static void buyAction(ShopMessage shopMessage, Account account) {
        Shop shop = new Shop();
        int count = 0;
        for (VBox vBox : shopMessage.getHeroes()) {
            if (((CheckBox) vBox.getChildren().get(0)).isSelected()) {
                String string = ((Label) (vBox.getChildren().get(2))).getText().split("\\n")[0].replaceAll("\\s", "").toLowerCase();
                if (!account.getCollection().hasThisCard(string)) {
                    if (shop.costOfCard(string) <= account.getMoney()) {
                        account.getCollection().addToCollection(string);
                        account.incrementMoney(-shop.costOfCard(string));
                        shopMessage.getHeroesBought().set(count, true);
                    } else shopMessage.getNotEnoughMoney().add(((Label) (vBox.getChildren().get(2))).getText().split("\\n")[0]);
                } else shopMessage.getAlreadyHaveThisCard().add(((Label) (vBox.getChildren().get(2))).getText().split("\\n")[0]);
                ((CheckBox) vBox.getChildren().get(0)).setSelected(false);
            }
            count++;
        }
        count = 0;
        for (VBox vBox : shopMessage.getMinions()) {
            if (((CheckBox) vBox.getChildren().get(0)).isSelected()) {
                String string = ((Label) (vBox.getChildren().get(2))).getText().split("\\n")[0].replaceAll("\\s", "").toLowerCase();
                if (!account.getCollection().hasThisCard(string)) {
                    if (shop.costOfCard(string) <= account.getMoney()) {
                        account.getCollection().addToCollection(string);
                        account.incrementMoney(-shop.costOfCard(string));
                        shopMessage.getMinionsBought().set(count, true);
                    } else shopMessage.getNotEnoughMoney().add(((Label) (vBox.getChildren().get(2))).getText().split("\\n")[0]);
                } else shopMessage.getAlreadyHaveThisCard().add(((Label) (vBox.getChildren().get(2))).getText().split("\\n")[0]);
                ((CheckBox) vBox.getChildren().get(0)).setSelected(false);
            }
            count++;
        }
        count = 0;
        for (VBox vBox : shopMessage.getSpells()) {
            if (((CheckBox) vBox.getChildren().get(0)).isSelected()) {
                String string = ((Label) (vBox.getChildren().get(2))).getText().split("\\n")[0].replaceAll("\\s", "").toLowerCase();
                if (!account.getCollection().hasThisCard(string)) {
                    if (shop.costOfCard(string) <= account.getMoney()) {
                        account.getCollection().addToCollection(string);
                        account.incrementMoney(-shop.costOfCard(string));
                        shopMessage.getSpellsBought().set(count, true);
                    } else shopMessage.getNotEnoughMoney().add(((Label) (vBox.getChildren().get(2))).getText().split("\\n")[0]);
                } else shopMessage.getAlreadyHaveThisCard().add(((Label) (vBox.getChildren().get(2))).getText().split("\\n")[0]);
                ((CheckBox) vBox.getChildren().get(0)).setSelected(false);
            }
            count++;
        }
        count = 0;
        for (VBox vBox : shopMessage.getItems()) {
            if (((CheckBox) vBox.getChildren().get(0)).isSelected()) {
                String string = ((Label) (vBox.getChildren().get(2))).getText().split("\\n")[0].replaceAll("\\s", "").toLowerCase();
                if (!account.getCollection().hasThisCard(string)) {
                    if (shop.costOfCard(string) <= account.getMoney()) {
                        account.getCollection().addToCollection(string);
                        account.incrementMoney(-shop.costOfCard(string));
                        shopMessage.getItemsBought().set(count, true);
                    } else shopMessage.getNotEnoughMoney().add(((Label) (vBox.getChildren().get(2))).getText().split("\\n")[0]);
                } else shopMessage.getAlreadyHaveThisCard().add(((Label) (vBox.getChildren().get(2))).getText().split("\\n")[0]);
                ((CheckBox) vBox.getChildren().get(0)).setSelected(false);
            }
            count++;
        }
    }

    public ArrayList<String> getNotEnoughMoney() {
        return notEnoughMoney;
    }

    public void setNotEnoughMoney(ArrayList<String> notEnoughMoney) {
        this.notEnoughMoney = notEnoughMoney;
    }

    public ArrayList<String> getAlreadyHaveThisCard() {
        return alreadyHaveThisCard;
    }

    public void setAlreadyHaveThisCard(ArrayList<String> alreadyHaveThisCard) {
        this.alreadyHaveThisCard = alreadyHaveThisCard;
    }
}