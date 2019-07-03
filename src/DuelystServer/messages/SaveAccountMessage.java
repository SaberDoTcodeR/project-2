package DuelystServer.messages;


import DuelystServer.model.Account;

public class SaveAccountMessage {
    private Account account;

    private int messageId = 14123;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }
}
