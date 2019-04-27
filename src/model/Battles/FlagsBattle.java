package model.Battles;

import model.Hand;
import model.Menus.Account;
import model.Deck;

public class FlagsBattle extends Battle {
    private boolean playWithAI;
    private Account secondPlayer;
    private int flags;

    public FlagsBattle(Deck opponentDeck, Deck myDeck, Account player, int flags) {
        super(player, myDeck, opponentDeck);
        this.playWithAI = true;
        this.flags = flags;
    }

    public FlagsBattle(Deck opponentDeck, Deck myDeck, Account player, Account player2, int flags) {
        super(player, myDeck, opponentDeck);
        this.secondPlayer = player2;
        this.playWithAI = false;
        this.flags = flags;
    }

    @Override
    public Account getSecondPlayer() {
        return secondPlayer;
    }

    @Override
    public boolean isPlayWithAI() {
        return playWithAI;
    }

    @Override
    public void showDetailedInfo() {
        int x;
    }

    @Override
    public Hand getSecondPlayerHand() {
        return null;
    }
}
