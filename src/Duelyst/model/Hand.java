package Duelyst.model;

import Duelyst.model.Battle.Battle;
import Duelyst.model.Card.Card;


import java.util.*;

public class Hand {
    private ArrayList<Card> cards = new ArrayList<>();
    private Card nextCardInHand;

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public Card getNextCardInHand() {
        return nextCardInHand;
    }

    public void setNextCardInHand(Card nextCardInHand) {
        this.nextCardInHand = nextCardInHand;
    }

    public void fillHand(Battle battle, int whichPlayer) {
        this.cards.add(battle.getFirstPlayerDeck().getHero().get(0));

        while (this.cards.size() < 5) {
            Random random = new Random();
            if (this.nextCardInHand != null) {
                this.cards.add(nextCardInHand);
                nextCardInHand = null;
            }
            while (this.nextCardInHand == null) {
                if (whichPlayer == 1 && battle.getSecondPlayerDeck().getSpells().size() != 0 && random.nextBoolean()) {
                    int x = random.nextInt(battle.getSecondPlayerDeck().getSpells().size());
                    this.nextCardInHand = (battle.getSecondPlayerDeck().getSpells().get(x));
                    battle.getSecondPlayerDeck().getSpells().remove(x);
                } else if (whichPlayer == 1 && battle.getSecondPlayerDeck().getMinions().size() != 0 && random.nextBoolean()) {
                    int x = random.nextInt(battle.getSecondPlayerDeck().getMinions().size());
                    this.nextCardInHand = (battle.getSecondPlayerDeck().getMinions().get(x));
                    battle.getSecondPlayerDeck().getMinions().remove(x);
                } else if (whichPlayer == 0 && battle.getFirstPlayerDeck().getSpells().size() != 0 && random.nextBoolean()) {
                    int x = random.nextInt(battle.getFirstPlayerDeck().getSpells().size());
                    this.nextCardInHand = battle.getFirstPlayerDeck().getSpells().get(x);
                    battle.getFirstPlayerDeck().getSpells().remove(x);
                } else if (whichPlayer == 0 && battle.getFirstPlayerDeck().getMinions().size() != 0 && random.nextBoolean()) {
                    int x = random.nextInt(battle.getFirstPlayerDeck().getMinions().size());
                    this.nextCardInHand = (battle.getFirstPlayerDeck().getMinions().get(x));
                    battle.getFirstPlayerDeck().getMinions().remove(x);
                }
            }
        }
    }
}

