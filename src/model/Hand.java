package model;

import model.*;
import model.Battles.Battle;
import model.Cards.*;

import java.util.*;

public class Hand {
    private ArrayList<Card> cards;
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
    public void fillHand(Battle battle,int whichPlayer){
        while (this.cards.size()<5){
            Random random=new Random();
            if(this.nextCardInHand!=null)
            {
                this.cards.add(nextCardInHand);
                nextCardInHand=null;
            }
            else if(whichPlayer==1&&battle.getSecondPlayerDeck().getSpells().size()!=0) {
                int x=random.nextInt(battle.getSecondPlayerDeck().getSpells().size());
                this.cards.add(battle.getSecondPlayerDeck().getSpells().get(x));
                battle.getSecondPlayerDeck().getSpells().remove(x);
            }else if(whichPlayer==0&&battle.getFirstPlayerDeck().getSpells().size()!=0) {
                int x=random.nextInt(battle.getFirstPlayerDeck().getSpells().size());
                this.cards.add(battle.getFirstPlayerDeck().getSpells().get(x));
                battle.getFirstPlayerDeck().getSpells().remove(x);
            }
        }
    }
}

