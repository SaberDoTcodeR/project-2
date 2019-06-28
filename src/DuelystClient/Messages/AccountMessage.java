package DuelystClient.Messages;

public class AccountMessage {
    private boolean signUpOrLogIn;
    private String user,pass;

    public AccountMessage(boolean signUpOrLogIn, String user, String pass) {
        this.signUpOrLogIn = signUpOrLogIn;
        this.user = user;
        this.pass = pass;
    }

    public boolean isSignUpOrLogIn() {
        return signUpOrLogIn;
    }

    public void setSignUpOrLogIn(boolean signUpOrLogIn) {
        this.signUpOrLogIn = signUpOrLogIn;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
