package model.Buffs;

import model.Cards.*;

public class ChangeHpBuff extends Buff {
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
