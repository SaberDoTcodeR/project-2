package model.Battles;

import model.Menus.Account;
import model.*;

import java.util.ArrayList;

public abstract class Battle {
    private Account firstPlayer;
    private Deck firstPlayerDeck;
    private Deck secondPlayerDeck;
    private Hand firstPlayerHand;
    private ArrayList<ArrayList<Cell>> map=new ArrayList<>();

    protected Battle(Account firstPlayer,Deck deck,Deck deck2){
        this.firstPlayer=firstPlayer;
        this.firstPlayerDeck=deck;
        this.secondPlayerDeck=deck2;
    }

    public ArrayList<ArrayList<Cell>> getMap() {
        return map;
    }
    public abstract void showDetailedInfo();
    public Account getFirstPlayer() {
        return firstPlayer;
    }

    public Deck getFirstPlayerDeck() {
        return firstPlayerDeck;
    }

    public Deck getSecondPlayerDeck() {
        return secondPlayerDeck;
    }

    public Hand getFirstPlayerHand() {
        return firstPlayerHand;
    }
    public abstract boolean isPlayWithAI();
    public abstract Account getSecondPlayer();
    public abstract Hand getSecondPlayerHand();
}

