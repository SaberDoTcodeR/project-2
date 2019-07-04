package DuelystClient.Messages;

import DuelystClient.model.Account;

public class LogoutMessage {
    private Account account;
    private int id;
    public LogoutMessage(Account account, int id){
        this.account = account;
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getId() {
        return id;
    }
}
