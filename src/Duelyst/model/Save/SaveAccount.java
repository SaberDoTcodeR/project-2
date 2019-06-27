package Duelyst.model.Save;

import java.util.ArrayList;

public class SaveAccount {
    public ArrayList<String> cards = new ArrayList<>();
    public String user, pass;
    int money, wins, mana;
    public String mainDeck;
    public ArrayList<SaveDeck> decks = new ArrayList<>();

}
