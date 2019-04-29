package model.Buffs;

import model.Cards.*;

public class DisarmBuff extends Buff {

    public void disarm(Hero hero) {
        hero.setCounterAttack(false);
        hero.getOwnBuffs().add(this);
    }

    public void disarm(Minion minion) {
        minion.setCounterAttack(false);
        minion.getOwnBuffs().add(this);
    }

    @Override
    public void dispel(Hero hero) {
        hero.setCounterAttack(true);
        hero.getOwnBuffs().remove(this);
    }

    @Override
    public void dispel(Minion minion) {
        minion.setCounterAttack(true);
        minion.getOwnBuffs().remove(this);
    }
}
