package DuelystClient.model;


import javafx.scene.image.Image;

import java.util.ArrayList;

public class Account implements Comparable<Account> {
    private int avatar;
    private String userName, passWord;
    private int money, wins = 0, mana;
    private Deck mainDeck;
    private transient ArrayList<RecordedMatch> matches = new ArrayList<>();
    private Collection myCollection = new Collection();
    public transient static Account loginAccount;
    private String onOrOff;
    private boolean onOff;
    private long authToken;

    public Account(String user, String pass) {
        this.userName = user;
        this.passWord = pass;
    }

    public long getAuthToken() {
        return authToken;
    }

    public void setAuthToken(long authToken) {
        this.authToken = authToken;
    }

    public static Account getLoginAccount() {
        return loginAccount;
    }

    public static void setLoginAccount(Account loginAccount) {
        Account.loginAccount = loginAccount;
        System.out.println(Account.getLoginAccount().money);
    }

    public Collection getMyCollection() {
        return myCollection;
    }

    public void setMyCollection(Collection myCollection) {
        this.myCollection = myCollection;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Image getAvatarImage() {
        String string = "DuelystClient/css/avatar" + getAvatar() + ".jpg";
        return new Image(string);
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public void addNewRecordedMatch(RecordedMatch recordedMatch) {
        this.matches.add(recordedMatch);
    }

    public ArrayList<RecordedMatch> getMatches() {
        return matches;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void incrementMoney(int money) {
        this.money += money;
    }

    public void incrementMana(int unit) {
        this.mana += unit;
    }

    public void decrementMana(int unit) {
        this.mana -= unit;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public Deck getMainDeck() {
        return mainDeck;
    }


    public void setMainDeck(Deck mainDeck) {
        this.mainDeck = mainDeck;
    }

    public Collection getCollection() {
        return myCollection;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }


    public String getPassWord() {
        return passWord;
    }

    public String getUserName() {
        return userName;
    }

    public String getOnOrOff() {
        return onOrOff;
    }

    public void setOnOrOff() {
        if (this.onOff) {
            this.onOrOff = "online";
        } else
            this.onOrOff = "offline";
    }

    public boolean isOnOff() {
        return onOff;
    }

    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }

    @Override
    public int compareTo(Account o) {
        int result = Integer.compare(this.getWins(), o.getWins());
        if (result == 0) {
            result = o.getUserName().compareTo(this.getUserName());
        }
        return result;
    }
}
