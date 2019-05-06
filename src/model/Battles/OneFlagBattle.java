package model.Battles;

import model.Cards.Hero.Hero;
import model.Cards.Minion.Minion;
import model.Cell;
import model.Hand;
import model.Item.CollectibleItem.*;
import model.Menus.Account;
import model.Deck;
import view.View;

import java.util.ArrayList;
import java.util.Random;

public class OneFlagBattle extends Battle {
    private boolean playWithAI;
    private Account secondPlayer;
    private Hand secondPlayerHand = new Hand();

    public OneFlagBattle(Deck opponentDeck, Deck myDeck, Account player, int reward) {
        super(player, myDeck, opponentDeck);
        this.playWithAI = true;
        Account account = new Account(1);
        account.setMainDeck(opponentDeck);
        this.secondPlayer = account;
        this.setMap();
        this.setReward(reward);
        this.getMap().get(2).get(0).getHero().setCardId(player.getUserName() + "_" + this.getMap().get(2).get(0).getHero().getName() + "_" + (1));
        this.getMap().get(2).get(8).getHero().setCardId(account.getUserName() + "_" + this.getMap().get(2).get(8).getHero().getName() + "_" + (1));
        this.getSecondPlayerInGameCards().add(this.getMap().get(2).get(8).getHero());
        this.getFirstPlayerInGameCards().add(this.getMap().get(2).get(0).getHero());
        if (this.getMap().get(2).get(8).getNumberOfFlag() > 0) {
            this.getMap().get(2).get(8).getHero().setNumberOfFlag(this.getMap().get(2).get(8).getHero().getNumberOfFlag() + this.getMap().get(2).get(8).getNumberOfFlag());
            this.getMap().get(2).get(8).setNumberOfFlag(0);
        } else if (this.getMap().get(2).get(0).getNumberOfFlag() > 0) {
            this.getMap().get(2).get(0).getHero().setNumberOfFlag(this.getMap().get(2).get(0).getHero().getNumberOfFlag() + this.getMap().get(2).get(0).getNumberOfFlag());
            this.getMap().get(2).get(0).setNumberOfFlag(0);
        }
    }

    public OneFlagBattle(Deck opponentDeck, Deck myDeck, Account player, Account player2, int reward) {
        super(player, myDeck, opponentDeck);
        this.secondPlayer = player2;
        this.playWithAI = false;
        this.setMap();
        this.setReward(reward);
        this.getMap().get(2).get(0).getHero().setCardId(player.getUserName() + "_" + this.getMap().get(2).get(0).getHero().getName() + "_" + (1));
        this.getMap().get(2).get(8).getHero().setCardId(player2.getUserName() + "_" + this.getMap().get(2).get(8).getHero().getName() + "_" + (1));
        this.getSecondPlayerInGameCards().add(this.getMap().get(2).get(8).getHero());
        this.getFirstPlayerInGameCards().add(this.getMap().get(2).get(0).getHero());
        if (this.getMap().get(2).get(8).getNumberOfFlag() > 0) {
            this.getMap().get(2).get(8).getHero().setNumberOfFlag(this.getMap().get(2).get(8).getHero().getNumberOfFlag() + this.getMap().get(2).get(8).getNumberOfFlag());
            this.getMap().get(2).get(8).setNumberOfFlag(0);
        } else if (this.getMap().get(2).get(0).getNumberOfFlag() > 0) {
            this.getMap().get(2).get(0).getHero().setNumberOfFlag(this.getMap().get(2).get(0).getHero().getNumberOfFlag() + this.getMap().get(2).get(0).getNumberOfFlag());
            this.getMap().get(2).get(0).setNumberOfFlag(0);
        }
    }

    public void setMap() {
        Random random = new Random();
        int x = random.nextInt(45);
        for (int i = 0; i < 5; i++) {
            getMap().add(new ArrayList<>());
            for (int j = 0; j < 9; j++) {
                if (random.nextInt(100) < 25) {
                    if (x % 5 == i && x % 9 == j) {
                        getMap().get(i).add(new Cell(i, j, 1, random.nextInt(CollectibleItem.getCollectibleItems().size())));

                    } else
                        getMap().get(i).add(new Cell(i, j, 0, random.nextInt(CollectibleItem.getCollectibleItems().size())));

                } else {
                    if (x % 5 == i && x % 9 == j) {
                        getMap().get(i).add(new Cell(i, j, 1, -1));
                    } else
                        getMap().get(i).add(new Cell(i, j, 0, -1));

                }
                if (i == 2 && j == 0) {
                    getMap().get(2).get(0).setHero(getFirstPlayerDeck().getHero().duplicate(), 0);

                }
                if (i == 2 && j == 8) {
                    getMap().get(2 + 1 - 1).get(8).setHero(getSecondPlayerDeck().getHero().duplicate(), 1);
                }

            }
        }

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
        View view = View.getInstance();
        view.showDetailedInfoOneFlagMode(this);
    }

    @Override
    public Hand getSecondPlayerHand() {
        return secondPlayerHand;
    }
}
