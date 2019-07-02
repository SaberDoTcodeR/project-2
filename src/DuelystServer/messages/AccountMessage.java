package DuelystServer.messages;

public class AccountMessage {
    private boolean signUpOrLogIn;
    private String user;
    private String pass;
    private String nameOfClass;

    public AccountMessage(boolean signUpOrLogIn, String user, String pass , String nameOfClass) {
        this.signUpOrLogIn = signUpOrLogIn;
        this.user = user;
        this.pass = pass;
        this.nameOfClass = nameOfClass;
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

    public boolean isSignUpOrLogIn() {
        return signUpOrLogIn;
    }

    public void setSignUpOrLogIn(boolean signUpOrLogIn) {
        this.signUpOrLogIn = signUpOrLogIn;
    }

    public String getNameOfClass() {
        return nameOfClass;
    }

    public void setNameOfClass(String nameOfClass) {
        this.nameOfClass = nameOfClass;
    }
}
