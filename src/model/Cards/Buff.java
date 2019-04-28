package model.Cards;

import model.Cell;

/*
* bayad card ru cell emal beshe dar method haye khode spell jame hadaf taEN beshe va buff ha bayad ru jameye hadaf
* emal shavand;
* */

import java.util.ArrayList;
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

    public abstract void dispel(Cell cell);

    public abstract void dispel(ArrayList<Cell> cells);
}

class HolyBuff extends Buff {

    public void holy(Cell cell) {
        if (cell.getHero() != null)
            cell.getHero().setHoly(true);
        if (cell.getMinion() != null)
            cell.getMinion().setHoly(true);

    }

    public void holy(ArrayList<Cell> cells) {
        for (Cell cell : cells) {
            if (cell.getHero() != null)
                cell.getHero().setHoly(true);
            if (cell.getMinion() != null)
                cell.getMinion().setHoly(true);
        }
    }

    @Override
    public void dispel(Cell cell) {
        if (cell.getHero() != null && cell.getHero().isHoly())
            cell.getHero().setHoly(false);
        if (cell.getMinion() != null && cell.getMinion().isHoly())
            cell.getMinion().setHoly(false);
    }

    @Override
    public void dispel(ArrayList<Cell> cells) {
        for (Cell cell: cells) {
            dispel(cell);
        }
    }
}

class PowerBuff extends Buff {
    public void power(Cell cell) {
        if (cell.getHero() != null) {
            if (getRandomNumber() % 2 == 0)
                cell.getHero().incrementAp(1);
            else
                cell.getMinion().incrementHp(1);
        }
        if (cell.getMinion() != null) {
            if (getRandomNumber() % 2 == 0)
                cell.getHero().incrementAp(1);
            else
                cell.getMinion().incrementHp(1);
        }
    }

    public void power(ArrayList<Cell> cells) {
        for (Cell cell : cells) {
           power(cell);
        }
    }

    @Override
    public void dispel(Cell cell) {

    }

    @Override
    public void dispel(ArrayList<Cell> cells) {

    }
}

class PoisonBuff extends Buff {
    public void poison(Cell cell) {
        if (cell.getHero() != null)
            cell.getHero().decrementHp(1);
        if (cell.getMinion() != null)
            cell.getMinion().decrementHp(1);
    }

    public void poison(ArrayList<Cell> cells) {
        for (Cell cell : cells) {
            if (cell.getHero() != null)
                cell.getHero().decrementHp(1);
            if (cell.getMinion() != null)
                cell.getMinion().decrementHp(1);
        }
    }

    @Override
    public void dispel(Cell cell) {

    }

    @Override
    public void dispel(ArrayList<Cell> cells) {

    }
}

class WeaknessBuff extends Buff {
    public void weakness(Cell cell) {
        if (cell.getHero() != null) {
            if (getRandomNumber() % 2 == 0)
                cell.getHero().decrementHp(1);
            else
                cell.getHero().decrementAp(1);
        }
        if (cell.getMinion() != null) {
            if (getRandomNumber() % 2 == 0)
                cell.getMinion().decrementAp(1);
            else
                cell.getMinion().decrementHp(1);
        }
    }

    public void weakness(ArrayList<Cell> cells) {
        for (Cell cell : cells) {
            weakness(cell);
        }
    }

    @Override
    public void dispel(Cell cell) {

    }

    @Override
    public void dispel(ArrayList<Cell> cells) {

    }
}

class StunBuff extends Buff {

    public void stun(Cell cell) {
        if (cell.getHero() != null)
            cell.getHero().setStunning(true);
        if (cell.getMinion() != null)
            cell.getMinion().setStunning(true);
    }

    public void stun(ArrayList<Cell> cells) {
        for (Cell cell : cells) {
            if (cell.getHero() != null)
                cell.getHero().setStunning(true);
            if (cell.getMinion() != null)
                cell.getMinion().setStunning(true);
        }
    }

    @Override
    public void dispel(Cell cell) {

    }

    @Override
    public void dispel(ArrayList<Cell> cells) {

    }
}

class DisarmBuff extends Buff {

    public void disarm(Cell cell) {
        if (cell.getHero() != null)
            cell.getHero().setTypeOfHit(3);
        if (cell.getMinion() != null)
            cell.getMinion().setTypeOfHit(3);
    }
    public void disarm(ArrayList<Cell> cells) {
        for (Cell cell : cells) {
            if (cell.getHero() != null)
                cell.getHero().setTypeOfHit(3);
            if (cell.getMinion() != null)
                cell.getMinion().setTypeOfHit(3);
        }
    }

    @Override
    public void dispel(Cell cell) {

    }

    @Override
    public void dispel(ArrayList<Cell> cells) {

    }
}

class ChangeApBuff extends Buff {
    private int unit;

    public ChangeApBuff(int unit) {
        this.unit = unit;
    }

    public void increment(Hero hero) {
        hero.incrementAp(unit);
    }

    public void decrement(Hero hero) {
        hero.decrementAp(unit);
    }

    public void increment(Minion minion) {
        minion.incrementAp(unit);
    }

    public void decrement(Minion minion) {
        minion.decrementAp(unit);
    }

    @Override
    public void dispel(Cell cell) {

    }

    @Override
    public void dispel(ArrayList<Cell> cells) {

    }
}

class ChangeHpBuff extends Buff {
    private int unit;

    public ChangeHpBuff(int unit) {
        this.unit = unit;
    }

    public void increment(Hero hero) {
        hero.incrementHp(unit);
    }

    public void decrement(Hero hero) {
        hero.decrementHp(unit);
    }

    public void increment(Minion minion) {
        minion.incrementHp(unit);
    }

    public void decrement(Minion minion) {
        minion.decrementHp(unit);
    }

    @Override
    public void dispel(Cell cell) {

    }

    @Override
    public void dispel(ArrayList<Cell> cells) {

    }
}

class FiringEffectedCell extends Buff {
    public void decrementHp(Cell cell) {
        if (cell.getHero() != null)
            cell.getHero().decrementHp(2);
        if (cell.getMinion() != null)
            cell.getMinion().decrementHp(2);
    }

    public void changeHP(ArrayList<Cell> cells) {
        for (Cell cell : cells) {
            if (cell.getHero() != null)
                cell.getHero().decrementHp(2);
            if (cell.getMinion() != null)
                cell.getMinion().decrementHp(2);
        }
    }

    @Override
    public void dispel(Cell cell) {

    }

    @Override
    public void dispel(ArrayList<Cell> cells) {

    }
}