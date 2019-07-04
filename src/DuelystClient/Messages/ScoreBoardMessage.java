package DuelystClient.Messages;

import DuelystClient.model.Account;

import java.util.ArrayList;
//id --> 46723
public class ScoreBoardMessage {
    private int id;
    public ScoreBoardMessage(int id){
        this.id = id;
    }
    private ArrayList<Account> accounts = new ArrayList<>();

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }
}
