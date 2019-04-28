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

    public abstract void dispel(Hero hero);

    public abstract void dispel(Minion minion);
}

class HolyBuff extends Buff {

    public void holy(Hero hero) {
        hero.incrementHolyCounter();
    }

    public void holy(Minion minion) {
        minion.incrementHolyCounter();
    }

    @Override
    public void dispel(Hero hero) {
        hero.setHolyCounter(0);
    }

    @Override
    public void dispel(Minion minion) {
        minion.setHolyCounter(0);
    }
}

class PowerBuff extends Buff {

    private int number;

    public void power(Hero hero) {
        if (getRandomNumber() % 2 == 0) {
            hero.incrementAp(1);
        } else {
            hero.incrementHp(1);
        }
    }

    public void power(Minion minion) {
        if (getNumber() % 2 == 0) {
            minion.incrementAp(1);
        } else {
            minion.incrementHp(1);
        }
    }

    @Override
    public void dispel(Hero hero) {
        if (getRandomNumber() % 2 == 0) {
            hero.decrementAp(1);
        } else {
            hero.decrementHp(1);
        }
    }

    @Override
    public void dispel(Minion minion) {
        if (getNumber() % 2 == 0) {
            minion.decrementAp(1);
        } else {
            minion.decrementHp(1);
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber() {
        this.number = getRandomNumber();
    }
}

class PoisonBuff extends Buff {

    public void poison(Hero hero) {
        hero.decrementHp(1);
    }

    public void poison(Minion minion) {
        minion.decrementHp(1);
    }

    @Override
    public void dispel(Hero hero) {
        //nothing
    }

    @Override
    public void dispel(Minion minion) {
        //nothing
    }
}

class WeaknessBuff extends Buff {

    private int number;

    public void weakness(Hero hero) {
        if (getRandomNumber() % 2 == 0) {
            hero.decrementAp(1);
        } else {
            hero.decrementHp(1);
        }
    }

    public void weakness(Minion minion) {
        if (getNumber() % 2 == 0) {
            minion.decrementAp(1);
        } else {
            minion.decrementHp(1);
        }
    }

    @Override
    public void dispel(Hero hero) {
        if (getRandomNumber() % 2 == 0) {
            hero.incrementAp(1);
        } else {
            hero.incrementHp(1);
        }
    }

    @Override
    public void dispel(Minion minion) {
        if (getNumber() % 2 == 0) {
            minion.incrementAp(1);
        } else {
            minion.incrementHp(1);
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber() {
        this.number = getRandomNumber();
    }
}

class StunBuff extends Buff {

    public void stun(Hero hero) {
        hero.setStunning(true);
    }

    public void stun(Minion minion) {
        minion.setStunning(true);
    }

    @Override
    public void dispel(Hero hero) {
        hero.setStunning(false);
    }

    @Override
    public void dispel(Minion minion) {
        minion.setStunning(false);
    }
}

class DisarmBuff extends Buff {

    public void disarm(Hero hero) {
        hero.setCounterAttack(false);
    }

    public void disarm(Minion minion) {
        minion.setCounterAttack(false);
    }

    @Override
    public void dispel(Hero hero) {
        hero.setCounterAttack(true);
    }

    @Override
    public void dispel(Minion minion) {
        minion.setCounterAttack(true);
    }
}

class ChangeApBuff extends Buff {
    private int unit;
    private boolean heroChange;
    private boolean minionChange;

    public ChangeApBuff(int unit) {
        this.unit = unit;
    }

    public void increment(Hero hero) {
        hero.incrementAp(unit);
        this.heroChange = true;
    }

    public void decrement(Hero hero) {
        hero.decrementAp(unit);
        this.heroChange = false;
    }

    public void increment(Minion minion) {
        minion.incrementAp(unit);
        this.minionChange = true;
    }

    public void decrement(Minion minion) {
        minion.decrementAp(unit);
        this.minionChange = false;
    }

    @Override
    public void dispel(Hero hero) {
        if (heroChange) {
            hero.decrementAp(unit);
        } else {
            hero.incrementAp(unit);
        }
    }

    @Override
    public void dispel(Minion minion) {
        if (minionChange) {
            minion.decrementAp(unit);
        } else {
            minion.incrementAp(unit);
        }
    }
}

class ChangeHpBuff extends Buff {
    private int unit;
    private boolean heroChange;
    private boolean minionChange;

    public ChangeHpBuff(int unit) {
        this.unit = unit;
    }

    public void increment(Hero hero) {
        hero.incrementHp(unit);
        this.heroChange = true;
    }

    public void decrement(Hero hero) {
        hero.decrementHp(unit);
        this.heroChange = false;
    }

    public void increment(Minion minion) {
        minion.incrementHp(unit);
        this.minionChange = true;
    }

    public void decrement(Minion minion) {
        minion.decrementHp(unit);
        this.minionChange = false;
    }

    @Override
    public void dispel(Hero hero) {
        if (heroChange) {
            hero.decrementHp(unit);
        } else {
            hero.incrementHp(unit);
        }
    }

    @Override
    public void dispel(Minion minion) {
        if (minionChange) {
            minion.decrementHp(unit);
        } else {
            minion.incrementHp(unit);
        }
    }
}

class PoisonEffectedCell extends Buff {

    public void poison(Hero hero) {
        hero.decrementHp(1);
    }

    public void poison(Minion minion) {
        minion.decrementHp(1);
    }

    @Override
    public void dispel(Hero hero) {
        //Nothing
    }

    @Override
    public void dispel(Minion minion) {
        //Nothing
    }
}

class FiringEffectedCell extends Buff {

    @Override
    public void dispel(Hero hero) {

    }

    @Override
    public void dispel(Minion minion) {

    }
}
