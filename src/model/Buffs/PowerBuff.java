package model.Buffs;

import model.Cards.*;

public class PowerBuff extends Buff {

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
