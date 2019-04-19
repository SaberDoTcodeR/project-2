package model;

import java.util.ArrayList;
import view.*;
import control.*;
public class Account {
    private static View view = View.getInstance();
    private static Account loginAccount;
    private static ArrayList<Account> allUser=new ArrayList<>();
    private String userName,passWord;
    private int money,xPos,yPos,wins=0;
    //private Deck mainDeck=new Deck();
    private ArrayList<RecordedMatch> matches=new ArrayList<RecordedMatch>();


    public Account (String userName,String passWord)
    {
        this.userName=userName;
        this.passWord=passWord;
        this.money=15000;

        allUser.add(this);

    }
    public static void showLeaderboard(){
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
        view.printLeaderBoard();

    }

    public int getWins() {
        return wins;
    }

    public static Account getLoginAccount() {
        return loginAccount;
    }

    public static void setLoginAccount(Account loginAccount) {
        Account.loginAccount = loginAccount;
    }

    public static ArrayList<Account> getAllUser() {
        return allUser;
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
}