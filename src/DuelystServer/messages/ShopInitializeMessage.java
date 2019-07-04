package DuelystServer.messages;

import java.util.ArrayList;

public class ShopInitializeMessage extends AccountMessage{
    public ShopInitializeMessage(boolean signUpOrLogIn, String user, String pass, String nameOfClass, long authToken) {
        super(signUpOrLogIn, user, pass, nameOfClass, authToken);
        super.setId(34121);
    }
    private ArrayList<Integer> heroesInShop = new ArrayList<>();
    private ArrayList<Integer> minionsInShop = new ArrayList<>();
    private ArrayList<Integer> spellInShop = new ArrayList<>();
    private ArrayList<Integer> itemsInShop = new ArrayList<>();

    public ArrayList<Integer> getHeroesInShop() {
        return heroesInShop;
    }

    public void setHeroesInShop(ArrayList<Integer> heroesInShop) {
        this.heroesInShop = heroesInShop;
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
}