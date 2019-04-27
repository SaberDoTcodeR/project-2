package model.Battles;

import model.Cell;
import model.Hand;
import model.Item.CollectableItem;
import model.Menus.Account;
import model.Deck;
import view.View;

import java.util.ArrayList;
import java.util.Random;

public class HeroBattle extends Battle {
    private boolean playWithAI;
    private Account secondPlayer;
    private Hand secondPlayerHand=new Hand();

    {
        Random random = new Random();
        getMap().add(new ArrayList<>());
        getMap().add(new ArrayList<>());
        getMap().add(new ArrayList<>());
        getMap().add(new ArrayList<>());
        getMap().add(new ArrayList<>());
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (random.nextInt(100) < 0)
                    getMap().get(i).add(new Cell(i, j, false, random.nextInt(CollectableItem.getCollectableItems().size())));
                else
                    getMap().get(i).add(new Cell(i, j, false, -1));
                if(i==2&&j==0)
                    getMap().get(2).get(0).setHero(getFirstPlayerDeck().getHero().duplicate(),0);
                if(i==2&&j==8)
                    getMap().get(2).get(0).setHero(getSecondPlayerDeck().getHero().duplicate(),1);

            }
        }
    }

    public HeroBattle(Deck opponentDeck, Deck myDeck, Account player) {
        super(player, myDeck, opponentDeck);
        this.playWithAI = true;
        Account account=new Account(1);
        this.secondPlayer=account;
    }

    public HeroBattle(Deck opponentDeck, Deck myDeck, Account player, Account player2) {
        super(player, myDeck, opponentDeck);
        this.secondPlayer = player2;
        this.playWithAI = false;
    }
    public void showDetailedInfo(){
        View view=View.getInstance();
        view.showDetailedInfoHeroMode(this);
    }
    @Override
    public boolean isPlayWithAI() {
        return playWithAI;
    }

    @Override
    public Hand getSecondPlayerHand() {
        return secondPlayerHand;
    }


    @Override
    public Account getSecondPlayer() {
        return secondPlayer;
    }
}
