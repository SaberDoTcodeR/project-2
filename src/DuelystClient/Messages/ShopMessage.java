package DuelystClient.Messages;

import DuelystClient.model.Card.Hero.Hero;
import DuelystClient.model.Card.Minion.Minion;
import DuelystClient.model.Card.Spell.Spell;
import DuelystClient.model.Item.Item;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ShopMessage extends AccountMessage{
    private ArrayList<VBox> heroes;
    private ArrayList<VBox> minions;
    private ArrayList<VBox> spells;
    private ArrayList<VBox> items;
    private ArrayList<Boolean> heroesBought;
    private ArrayList<Boolean> minionsBought;
    private ArrayList<Boolean> SpellsBought;
    private ArrayList<Boolean> itemsBought;

    public ArrayList<String> getNotEnoughMoney() {
        return notEnoughMoney;
    }

    public ArrayList<String> getAlreadyHaveThisCard() {
        return alreadyHaveThisCard;
    }

    public void setNotEnoughMoney(ArrayList<String> notEnoughMoney) {
        this.notEnoughMoney = notEnoughMoney;
    }

    public void setAlreadyHaveThisCard(ArrayList<String> alreadyHaveThisCard) {
        this.alreadyHaveThisCard = alreadyHaveThisCard;
    }

    ArrayList<String> notEnoughMoney = new ArrayList<>();
    ArrayList<String> alreadyHaveThisCard = new ArrayList<>();

    public ShopMessage(boolean signUpOrLogIn, String user, String pass, ArrayList<Boolean> heroesBought, ArrayList<Boolean> minionsBought
    , ArrayList<Boolean> spellsBought, ArrayList<Boolean> itemsBought, ArrayList<VBox> heroes, ArrayList<VBox> minions
    , ArrayList<VBox> spells, ArrayList<VBox> items) {
        super(signUpOrLogIn, user, pass);
        setHeroes(heroes);
        setHeroesBought(heroesBought);
        setItems(items);
        setItemsBought(itemsBought);
        setMinions(minions);
        setMinionsBought(minionsBought);
        setSpells(spells);
        setSpellsBought(spellsBought);
    }

    public void setHeroes(ArrayList<VBox> heroes) {
        this.heroes = heroes;
    }

    public ArrayList<VBox> getHeroes() {
        return heroes;
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

    public ArrayList<Boolean> getHeroesBought() {
        return heroesBought;
    }

    public void setHeroesBought(ArrayList<Boolean> heroesBought) {
        this.heroesBought = heroesBought;
    }

    public ArrayList<Boolean> getMinionsBought() {
        return minionsBought;
    }

    public void setMinionsBought(ArrayList<Boolean> minionsBought) {
        this.minionsBought = minionsBought;
    }

    public ArrayList<Boolean> getSpellsBought() {
        return SpellsBought;
    }

    public void setSpellsBought(ArrayList<Boolean> spellsBought) {
        SpellsBought = spellsBought;
    }

    public ArrayList<Boolean> getItemsBought() {
        return itemsBought;
    }

    public void setItemsBought(ArrayList<Boolean> itemsBought) {
        this.itemsBought = itemsBought;
    }
}
