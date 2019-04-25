package model.Battles;

import model.Account;
import model.Deck;

public class HeroBattle extends Battle{
    private boolean playWithAI;
    private Account secondPlayer;
    public HeroBattle(Deck opponentDeck, Deck myDeck, Account player){
        super(player,myDeck,opponentDeck);
        this.playWithAI=true;
    }
    public HeroBattle(Deck opponentDeck,Deck myDeck,Account player,Account player2){
        super(player,myDeck,opponentDeck);
        this.secondPlayer=player2;
        this.playWithAI=false;
    }
}
