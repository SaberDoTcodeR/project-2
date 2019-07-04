package DuelystClient.Messages;

import DuelystClient.model.Account;

import java.util.ArrayList;
import java.util.Arrays;

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
    private ArrayList<String> notOwnedCard = new ArrayList<>();
    private Account account;
    private ArrayList<Integer> heroesInShop = new ArrayList<>();
    private ArrayList<Integer> minionsInShop = new ArrayList<>();
    private ArrayList<Integer> spellInShop = new ArrayList<>();
    private ArrayList<Integer> itemsInShop = new ArrayList<>();
    private ArrayList<String> notAvailableCard = new ArrayList<>();
    private ArrayList<String> notEnoughMoney = new ArrayList<>();
    private ArrayList<String> alreadyHaveThisCard = new ArrayList<>();

    public ArrayList<String> getNotOwnedCard() {
        return notOwnedCard;
    }

    @Override
    public int hashCode() {
        return 2357;
    }

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

    public ShopMessage(boolean signUpOrLogIn, String user, String pass, String nameOfClass, ArrayList<Boolean> heroesBought,
                       ArrayList<Boolean> minionsBought, ArrayList<Boolean> spellsBought, ArrayList<Boolean> itemsBought, long authToken) {
        super(signUpOrLogIn, user, pass, nameOfClass, authToken);
        setSpellsBought(spellsBought);
        setMinionsBought(minionsBought);
        setItemsBought(itemsBought);
        setHeroesBought(heroesBought);
        super.setId(43123);
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

    public ArrayList<Integer> getHeroesInShop() {
        return heroesInShop;
    }

    public void setHeroesInShop(ArrayList<Integer> heroesInShop) {
        this.heroesInShop = heroesInShop;
    }

    public ArrayList<String> getNotAvailableCard() {
        return notAvailableCard;
    }

    public void setNotAvailableCard(ArrayList<String> notAvailableCard) {
        this.notAvailableCard = notAvailableCard;
    }

    public ArrayList<Integer> getMinionsInShop() {
        return minionsInShop;
    }

    public void setMinionsInShop(ArrayList<Integer> minionsInShop) {
        this.minionsInShop = minionsInShop;
    }

    public ArrayList<Integer> getSpellInShop() {
        return spellInShop;
    }

    public void setSpellInShop(ArrayList<Integer> spellInShop) {
        this.spellInShop = spellInShop;
    }

    public ArrayList<Integer> getItemsInShop() {
        return itemsInShop;
    }

    public void setItemsInShop(ArrayList<Integer> itemsInShop) {
        this.itemsInShop = itemsInShop;
    }

    public void setNumberOfCards() {

    }
}