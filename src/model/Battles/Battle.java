package model.Battles;

import model.Cards.Card;
import model.Menus.Account;
import model.*;

import java.util.ArrayList;

public abstract class Battle {
    private Account firstPlayer;
    private Deck firstPlayerDeck;
    private Deck secondPlayerDeck;
    private Hand firstPlayerHand=new Hand();
    private ArrayList<ArrayList<Cell>> map=new ArrayList<>();
    private int turn=1;
    private ArrayList<Card> firstPlayerInGameCards=new ArrayList<>();
    private ArrayList<Card> secondPlayerInGameCards=new ArrayList<>();

    protected Battle(Account firstPlayer,Deck deck,Deck deck2){
        this.firstPlayer=firstPlayer;
        this.firstPlayerDeck=deck;
        this.secondPlayerDeck=deck2;
    }

    public void addFirstPlayerInGameCards(Card card) {
        this.firstPlayerInGameCards.add(card);
    }
    public void addSecondPlayerInGameCards(Card card) {
        this.secondPlayerInGameCards.add(card);
    }

    public ArrayList<Card> getFirstPlayerInGameCards() {
        return firstPlayerInGameCards;
    }

    public ArrayList<Card> getSecondPlayerInGameCards() {
        return secondPlayerInGameCards;
    }

    public int getTurn() {
        return turn;
    }

    public void increamentTurn() {
        this.turn++;
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

