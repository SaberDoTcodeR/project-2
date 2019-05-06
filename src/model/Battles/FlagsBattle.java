package model.Battles;

import model.Cell;
import model.Hand;
import model.Item.CollectibleItem.*;
import model.Menus.Account;
import model.Deck;

import java.util.ArrayList;
import java.util.Random;

public class FlagsBattle extends Battle {
    private boolean playWithAI;
    private Account secondPlayer;
    private Hand secondPlayerHand = new Hand();
    private int flags;

    public int getFlags() {
        return flags;
    }

    public FlagsBattle(Deck opponentDeck, Deck myDeck, Account player, int flags, int reward) {
        super(player, myDeck, opponentDeck);
        this.playWithAI = true;
        Account account = new Account(1);
        account.setMainDeck(opponentDeck);
        this.secondPlayer = account;
        this.flags = flags;
        this.setMap();
        this.setReward(reward);
        this.getMap().get(2).get(0).getHero().setCardId(player.getUserName() + "_" + this.getMap().get(2).get(0).getHero().getName() + "_" + (1));
        this.getMap().get(2).get(8).getHero().setCardId(account.getUserName() + "_" + this.getMap().get(2).get(8).getHero().getName() + "_" + (1));
        this.getSecondPlayerInGameCards().add(this.getMap().get(2).get(8).getHero());
        this.getFirstPlayerInGameCards().add(this.getMap().get(2).get(0).getHero());
        if (this.getMap().get(2).get(8).getNumberOfFlag() > 0) {
            this.getMap().get(2).get(8).getHero().setNumberOfFlag(this.getMap().get(2).get(8).getHero().getNumberOfFlag() + this.getMap().get(2).get(8).getNumberOfFlag());
            this.getMap().get(2).get(8).setFlag(0);
        } else if (this.getMap().get(2).get(0).getNumberOfFlag() > 0) {
            this.getMap().get(2).get(0).getHero().setNumberOfFlag(this.getMap().get(2).get(0).getHero().getNumberOfFlag() + this.getMap().get(2).get(0).getNumberOfFlag());
            this.getMap().get(2).get(0).setFlag(0);
        }
    }

    public FlagsBattle(Deck opponentDeck, Deck myDeck, Account player, Account player2, int flags, int reward) {
        super(player, myDeck, opponentDeck);
        this.secondPlayer = player2;
        this.playWithAI = false;
        this.flags = flags;
        this.setMap();
        this.setReward(reward);
        this.getMap().get(2).get(0).getHero().setCardId(player.getUserName() + "_" + this.getMap().get(2).get(0).getHero().getName() + "_" + (1));
        this.getMap().get(2).get(8).getHero().setCardId(player2.getUserName() + "_" + this.getMap().get(2).get(8).getHero().getName() + "_" + (1));
        this.getSecondPlayerInGameCards().add(this.getMap().get(2).get(8).getHero());
        this.getFirstPlayerInGameCards().add(this.getMap().get(2).get(0).getHero());
        if (this.getMap().get(2).get(8).getNumberOfFlag() > 0) {
            this.getMap().get(2).get(8).getHero().setNumberOfFlag(this.getMap().get(2).get(8).getHero().getNumberOfFlag() + this.getMap().get(2).get(8).getNumberOfFlag());
            this.getMap().get(2).get(8).setFlag(0);
        } else if (this.getMap().get(2).get(0).getNumberOfFlag() > 0) {
            this.getMap().get(2).get(0).getHero().setNumberOfFlag(this.getMap().get(2).get(0).getHero().getNumberOfFlag() + this.getMap().get(2).get(0).getNumberOfFlag());
            this.getMap().get(2).get(0).setFlag(0);
        }
    }

    public void setMap() {
        Random random = new Random();
        getMap().add(new ArrayList<>());
        getMap().add(new ArrayList<>());
        getMap().add(new ArrayList<>());
        getMap().add(new ArrayList<>());
        getMap().add(new ArrayList<>());
        ArrayList<Integer> integers = new ArrayList<>();
        int counter = 0;
        while (counter < this.flags) {
            int x = random.nextInt(45);
            if (!integers.contains(x)) {
                integers.add(x);
            }
            counter++;
        }
        counter = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (random.nextInt(100) < 25) {
                    if (counter < this.flags && integers.get(counter) % 5 == i && integers.get(counter) % 9 == j) {
                        getMap().get(i).add(new Cell(i, j, 1, random.nextInt(CollectibleItem.getCollectibleItems().size())));
                        counter++;
                    } else
                        getMap().get(i).add(new Cell(i, j, 0, random.nextInt(CollectibleItem.getCollectibleItems().size())));

                } else {
                    if (counter < this.flags && integers.get(counter) % 5 == i && integers.get(counter) % 9 == j) {
                        getMap().get(i).add(new Cell(i, j, 1, -1));
                        counter++;
                    } else
                        getMap().get(i).add(new Cell(i, j, 0, -1));

                }
                if (i == 2 && j == 0) {
                    getMap().get(2).get(0).setHero(getFirstPlayerDeck().getHero().duplicate(), 0);

                }
                if (i == 2 && j == 8) {
                    getMap().get(2).get(8).setHero(getSecondPlayerDeck().getHero().duplicate(), 1);
                }

            }
        }

    }

    @Override
    public String getType() {
        return "FlagsBattle";
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
