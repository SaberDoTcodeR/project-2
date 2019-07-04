package DuelystServer.messages;

public class ShopInitializeMessage extends AccountMessage{
    public ShopInitializeMessage(boolean signUpOrLogIn, String user, String pass, String nameOfClass, long authToken) {
        super(signUpOrLogIn, user, pass, nameOfClass, authToken);
        super.setId(34121);
    }
    private int[] heroesInShop = new int[10];
    private int[] minionsInShop = new int[40];
    private int[] spellInShop = new int[20];
    private int[] itemsInShop = new int[11];

    public int[] getHeroesInShop() {
        return heroesInShop;
    }

    public void setHeroesInShop(int[] heroesInShop) {
        this.heroesInShop = heroesInShop;
    }

    public int[] getMinionsInShop() {
        return minionsInShop;
    }

    public void setMinionsInShop(int[] minionsInShop) {
        this.minionsInShop = minionsInShop;
    }

    public int[] getSpellInShop() {
        return spellInShop;
    }

    public void setSpellInShop(int[] spellInShop) {
        this.spellInShop = spellInShop;
    }

    public int[] getItemsInShop() {
        return itemsInShop;
    }

    public void setItemsInShop(int[] itemsInShop) {
        this.itemsInShop = itemsInShop;
    }
}
