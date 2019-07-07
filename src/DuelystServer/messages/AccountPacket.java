package DuelystServer.messages;

import DuelystServer.model.Account;

public class AccountPacket {
    private Account account;
    private int id = 75453;

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
