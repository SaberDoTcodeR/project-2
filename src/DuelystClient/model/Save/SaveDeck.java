package DuelystClient.model.Save;

import java.util.ArrayList;

public class SaveDeck {
    public String name;

    public ArrayList<String> cards = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getCards() {
        return cards;
    }

    public void setCards(ArrayList<String> cards) {
        this.cards = cards;
    }

}
