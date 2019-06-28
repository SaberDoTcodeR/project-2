package DuelystClient.model.Save;

import java.util.ArrayList;

public class  SaveAccount {
    public ArrayList<String> cards = new ArrayList<>();
    public String user, pass;
    public int money, wins, mana;
    public String mainDeck;
    public ArrayList<SaveDeck> decks = new ArrayList<>();

    public ArrayList<String> getCards() {
        return cards;
    }

    public void setCards(ArrayList<String> cards) {
        this.cards = cards;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public String getMainDeck() {
        return mainDeck;
    }

    public void setMainDeck(String mainDeck) {
        this.mainDeck = mainDeck;
    }

    public ArrayList<SaveDeck> getDecks() {
        return decks;
    }

    public void setDecks(ArrayList<SaveDeck> decks) {
        this.decks = decks;
    }


}
