package DuelystServer.model;


import DuelystServer.Connection;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Account {
    private int avatar;
    public transient Connection connection;
    private transient volatile static ArrayList<Account> allUser = new ArrayList<>();
    private String userName, passWord;
    private volatile int money, wins = 0, mana;
    private Deck mainDeck;
    private transient ArrayList<RecordedMatch> matches = new ArrayList<>();
    private Collection myCollection = new Collection();
    private long authToken;
    private boolean onOff;

    public Collection getMyCollection() {
        return myCollection;
    }

    public long getAuthToken() {
        return authToken;
    }

    public void setAuthToken(long authToken) {
        this.authToken = authToken;
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

    public static void setAllUser(ArrayList<Account> allUser) {
        Account.allUser = allUser;
    }

    //private ArrayList<Buff> ownBuffs = new ArrayList<>();

    public Account(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
        this.money = 15000;
        this.avatar = 1;
        allUser.add(this);
    }

    public Account(int x) {
        this.userName = "AI_Player";
        this.money = 15000;
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

    public static boolean existThisUser(String userName) {
        for (Account account : Account.getAllUser()) {
            if (account.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean authorize(String userName, String passWord) {
        for (Account account : Account.getAllUser()) {
            if (account.getUserName().equals(userName)) {
                if (account.getPassWord().equals(passWord)) {
                    return true;
                }
                return false;
            }
        }
        return false;
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


    public static void showLeaderboard() {
        for (int i = 0; i < allUser.size() - 1; i++) {
            Account pl = allUser.get(i);
            int maxW = pl.wins;
            int maxi = i;
            for (int j = i + 1; j < allUser.size(); j++) {
                Account tmp = allUser.get(j);
                if (maxW < tmp.wins) {
                    maxi = j;
                    maxW = tmp.wins;
                } else if (maxW == tmp.wins && allUser.get(maxi).userName.compareTo(allUser.get(j).userName) > 0) {
                    maxi = j;
                    maxW = tmp.wins;

                }
            }
            pl = allUser.get(maxi);
            allUser.remove(maxi);
            allUser.add(maxi, allUser.get(i));
            allUser.remove(i);
            allUser.add(i, pl);
        }

    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public static ArrayList<Account> getAllUser() {
        return allUser;
    }

    public static Account getAccount(String userName) {
        for (Account account : allUser) {
            if (account.getUserName().equals(userName))
                return account;
        }
        return null;
    }
    public static Account getAccount(long authToken) {
        for (Account account : allUser) {
            if (account.getAuthToken()==authToken)
                return account;
        }
        return null;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getUserName() {
        return userName;
    }

    public static void addUser(Account account) {
        allUser.add(account);
    }

    public boolean isOnOff() {
        return onOff;
    }

    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }

    /*public ArrayList<Buff> getOwnBuffs() {
        return ownBuffs;
    }

    public void setOwnBuffs(ArrayList<Buff> ownBuffs) {
        this.ownBuffs = ownBuffs;
    }*/
}
