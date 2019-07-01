package DuelystServer.messages;

import DuelystServer.model.Account;
import DuelystServer.model.Shop;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class ShopMessage extends AccountMessage {

    private ArrayList<String> heroes = new ArrayList<>();
    private ArrayList<String> minions = new ArrayList<>();
    private ArrayList<String> spells = new ArrayList<>();
    private ArrayList<String> items = new ArrayList<>();
    private ArrayList<String> notEnoughMoney = new ArrayList<>();
    private ArrayList<String> alreadyHaveThisCard = new ArrayList<>();
    private ArrayList<Boolean> heroesBought;
    private ArrayList<Boolean> minionsBought;
    private ArrayList<Boolean> spellsBought;
    private ArrayList<Boolean> itemsBought;
    private ArrayList<Boolean> heroCheck = new ArrayList<>();
    private ArrayList<Boolean> minionCheck = new ArrayList<>();
    private ArrayList<Boolean> spellCheck = new ArrayList<>();
    private ArrayList<Boolean> itemCheck = new ArrayList<>();

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

    public ArrayList<String> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<String> heroes) {
        this.heroes = heroes;
    }

    public ArrayList<String> getMinions() {
        return minions;
    }

    public void setMinions(ArrayList<String> minions) {
        this.minions = minions;
    }

    public ArrayList<String> getSpells() {
        return spells;
    }

    public void setSpells(ArrayList<String> spells) {
        this.spells = spells;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }

    public  void buyAction(Account account) {
        Shop shop = new Shop();
        int count = 0;
        for (String vBox : this.getHeroes()) {
            if (heroCheck.get(count)) {
                if (!account.getCollection().hasThisCard(vBox)) {
                    if (shop.costOfCard(vBox) <= account.getMoney()) {
                        account.getCollection().addToCollection(vBox);
                        account.incrementMoney(-shop.costOfCard(vBox));
                        this.getHeroesBought().set(count, true);
                    } else
                        this.getNotEnoughMoney().add(vBox);
                } else
                    this.getAlreadyHaveThisCard().add((vBox));
                heroCheck.set(count, false);
            }
            count++;
        }
        count = 0;
        for (String vBox : this.getMinions()) {
            if (minionCheck.get(count)) {
                if (!account.getCollection().hasThisCard(vBox)) {
                    if (shop.costOfCard(vBox) <= account.getMoney()) {
                        account.getCollection().addToCollection(vBox);
                        account.incrementMoney(-shop.costOfCard(vBox));
                        this.getMinionsBought().set(count, true);
                    } else
                        this.getNotEnoughMoney().add(vBox);
                } else
                    this.getAlreadyHaveThisCard().add(vBox);
                minionCheck.set(count, false);
            }
            count++;
        }
        count = 0;
        for (String vBox : this.getSpells()) {
            if (spellCheck.get(count)) {
                if (!account.getCollection().hasThisCard(vBox)) {
                    if (shop.costOfCard(vBox) <= account.getMoney()) {
                        account.getCollection().addToCollection(vBox);
                        account.incrementMoney(-shop.costOfCard(vBox));
                        this.getSpellsBought().set(count, true);
                    } else
                        this.getNotEnoughMoney().add(vBox);
                } else
                    this.getAlreadyHaveThisCard().add(vBox);
                spellCheck.set(count, false);
            }
            count++;
        }
        count = 0;
        for (String vBox : this.getItems()) {
            if (itemCheck.get(count)) {
                if (!account.getCollection().hasThisCard(vBox)) {
                    if (shop.costOfCard(vBox) <= account.getMoney()) {
                        account.getCollection().addToCollection(vBox);
                        account.incrementMoney(-shop.costOfCard(vBox));
                        this.getItemsBought().set(count, true);
                    } else
                        this.getNotEnoughMoney().add(vBox);
                } else
                    this.getAlreadyHaveThisCard().add(vBox);
                itemCheck.set(count, false);
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