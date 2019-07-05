package DuelystClient.Messages;

import javafx.util.Pair;

public class BidMessage {
    private int id = 53412;
    private Pair<Long, String> text = new Pair<>(null, "");

    public Pair<Long, String> getText() {
        return text;
    }

    public void setText(Pair<Long, String> text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
