package model.Buffs;

import model.Cards.Hero.Hero;
import model.Cards.Minion.Minion;

import java.util.ArrayList;
import java.util.Random;

public abstract class Buff {

    private static ArrayList<String> positiveBuffs = new ArrayList<>();
    private static ArrayList<String> negativeBuffs = new ArrayList<>();

    public static ArrayList<String> getPositiveBuffs() {
        return positiveBuffs;
    }


    public static ArrayList<String> getNegativeBuffs() {
        return negativeBuffs;
    }

    static {
        positiveBuffs.add("HolyBuff");
        positiveBuffs.add("PowerBuff");
        negativeBuffs.add("PoisonBuff");
        negativeBuffs.add("WeaknessBuff");
        negativeBuffs.add("StunBuff");
        negativeBuffs.add("DisarmBuff");
    }

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

    public abstract void castBuff();

    public abstract void dispel(Hero hero);

    public abstract void dispel(Minion minion);
}

