package model.Buffs;

import model.Cards.*;

public class DisarmBuff extends Buff {

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
