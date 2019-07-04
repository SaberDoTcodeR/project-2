package DuelystClient.Messages;

import javafx.util.Pair;

public class TextMessage {
    private Pair<String, String> text = new Pair<>("","");
    private int id = 41543;

    public Pair<String, String> getText() {
        return text;
    }

    public void setText(Pair<String, String> text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
