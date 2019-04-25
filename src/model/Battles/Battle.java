package model.Battles;

import model.Account;
import model.Deck;

public abstract class Battle {
    private Account firstPlayer;
    private Deck firstPlayerDeck;
    private Deck secondPlayerDeck;
    protected Battle(Account firstPlayer,Deck deck,Deck deck2){
        this.firstPlayer=firstPlayer;
        this.firstPlayerDeck=deck;
        this.secondPlayerDeck=deck2;
    }
}

