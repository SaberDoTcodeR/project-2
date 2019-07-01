package DuelystClient.Messages;

import DuelystClient.model.Account;

import java.util.ArrayList;

public class ShopMessage extends AccountMessage {
    private ArrayList<String> heroes = new ArrayList<>();
    private ArrayList<String> minions = new ArrayList<>();
    private ArrayList<String> spells = new ArrayList<>();
    private ArrayList<String> items = new ArrayList<>();
    private ArrayList<Boolean> heroesBought;
    private ArrayList<Boolean> minionsBought;
    private ArrayList<Boolean> spellsBought;
    private ArrayList<Boolean> itemsBought;
    private ArrayList<Boolean> heroCheck = new ArrayList<>();
    private ArrayList<Boolean> minionCheck = new ArrayList<>();
    private ArrayList<Boolean> spellCheck = new ArrayList<>();
    private ArrayList<Boolean> itemCheck = new ArrayList<>();
    private Account account;

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

    public ShopMessage(boolean signUpOrLogIn, String user, String pass, ArrayList<Boolean> heroesBought,
                       ArrayList<Boolean> minionsBought, ArrayList<Boolean> spellsBought, ArrayList<Boolean> itemsBought) {
        super(signUpOrLogIn, user, pass);
        setSpellsBought(spellsBought);
        setMinionsBought(minionsBought);
        setItemsBought(itemsBought);
        setHeroesBought(heroesBought);
    }

    public void setHeroes(String hero) {
        this.heroes.add(hero);
    }

    public ArrayList<String> getHeroes() {
        return heroes;
    }

    public ArrayList<String> getMinions() {
        return minions;
    }

    public void setMinions(String minions) {
        this.minions.add(minions);
    }

    public ArrayList<String> getSpells() {
        return spells;
    }

    public void setSpells(String spells) {
        this.spells.add(spells);
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items.add(items);
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
        return spellsBought;
    }

    public void setSpellsBought(ArrayList<Boolean> spellsBought) {
        this.spellsBought = spellsBought;
    }

    public ArrayList<Boolean> getItemsBought() {
        return itemsBought;
    }

    public void setItemsBought(ArrayList<Boolean> itemsBought) {
        this.itemsBought = itemsBought;
    }

    public ArrayList<Boolean> getHeroCheck() {
        return heroCheck;
    }

    public void setHeroCheck(Boolean heroCheck) {
        this.heroCheck.add(heroCheck);
    }

    public ArrayList<Boolean> getMinionCheck() {
        return minionCheck;
    }

    public void setMinionCheck(Boolean minionCheck) {
        this.minionCheck.add(minionCheck);
    }

    public ArrayList<Boolean> getSpellCheck() {
        return spellCheck;
    }

    public void setSpellCheck(Boolean spellCheck) {
        this.spellCheck.add(spellCheck);
    }

    public ArrayList<Boolean> getItemCheck() {
        return itemCheck;
    }

    public void setItemCheck(Boolean itemCheck) {
        this.itemCheck.add(itemCheck);
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
