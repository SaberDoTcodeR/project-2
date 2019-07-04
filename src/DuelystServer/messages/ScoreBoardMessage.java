package DuelystServer.messages;

import DuelystServer.model.Account;

import java.util.ArrayList;

public class ScoreBoardMessage {

    private int id;
    private ArrayList<Account> accounts = new ArrayList<>();

    public ScoreBoardMessage(int id) {
        this.id = id;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }
}