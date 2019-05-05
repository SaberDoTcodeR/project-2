package model.Battles;

import model.Hand;
import model.Menus.Account;
import model.Deck;

public class OneFlagBattle extends Battle {
    private boolean playWithAI;
    private Account secondPlayer;

    public OneFlagBattle(Deck opponentDeck, Deck myDeck, Account player) {
        super(player, myDeck, opponentDeck);
        this.playWithAI = true;
    }

    public OneFlagBattle(Deck opponentDeck, Deck myDeck, Account player, Account player2) {
        super(player, myDeck, opponentDeck);
        this.secondPlayer = player2;
        this.playWithAI = false;
    }

    @Override
    public String getType() {
        return "OneFlagBattle";
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
