package DuelystClient.Messages;

import DuelystClient.model.Account;

public class AuctionMessage {
    private Account account;
    private int id = 52341;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
