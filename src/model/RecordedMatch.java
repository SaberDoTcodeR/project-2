package model;

import java.util.Date;

public class RecordedMatch {
    private Date date;
    private boolean result;//false: loss | true: win
    private String opponentName;

    public Date getDate() {
        return date;
    }

    public boolean getResult() {
        return result;
    }

    public String getOpponentName() {
        return opponentName;
    }


    public RecordedMatch(boolean result, String name) {
        this.result = result;
        this.opponentName = name;
        this.date = new Date();
    }
}
