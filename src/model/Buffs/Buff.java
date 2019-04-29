package model.Buffs;

import model.Cards.*;

import java.util.Random;

public abstract class Buff {

    private Random random = new Random(50);

    private int turnCounter;

    public int getRandomNumber() {
        int randomNumber = random.nextInt();
        return randomNumber;
    }

    public int getTurnCounter() {
        return turnCounter;
    }

    public void setTurnCounter(int turnCounter) {
        this.turnCounter = turnCounter;
    }

    public void decrementTurnCounter(int number) {
        this.turnCounter -= number;
    }

    public void incrementTurnCounter(int number) {
        this.turnCounter += number;
    }

    public abstract void dispel(Hero hero);

    public abstract void dispel(Minion minion);
}

