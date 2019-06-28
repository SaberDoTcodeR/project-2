package DuelystClient.Messages;

public class AccountMessage {
    private boolean signUpOrLogIn;
    private String user,pass;

    public AccountMessage(boolean signUpOrLogIn, String user, String pass) {
        this.signUpOrLogIn = signUpOrLogIn;
        this.user = user;
        this.pass = pass;
    }
}
