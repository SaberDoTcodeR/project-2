package DuelystClient.Messages;

import DuelystClient.model.Account;

public class GameRequestAns {
    private boolean fail;
    private int id = 94573;
    private Account Opponent;

    public GameRequestAns(boolean fail, Account opponent) {
        this.fail = fail;
        Opponent = opponent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getOpponent() {
        return Opponent;
    }

    public void setOpponent(Account opponent) {
        Opponent = opponent;
    }

    public boolean isFail() {
        return fail;
    }

    public void setFail(boolean fail) {
        this.fail = fail;
    }
}
