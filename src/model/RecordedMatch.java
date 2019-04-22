package model;

import java.util.Date;

public class RecordedMatch {
    private Date date;
    private boolean result;//0 losse 1 win
    private String opponentName;

    public Date getDate() {
        return date;
    }

    public RecordedMatch(boolean result, String name) {
        this.result = result;
        this.opponentName = name;
        this.date = new Date();
    }
}
