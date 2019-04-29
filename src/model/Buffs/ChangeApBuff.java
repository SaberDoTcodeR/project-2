package model.Buffs;

import model.Cards.*;

public class ChangeApBuff extends Buff {
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