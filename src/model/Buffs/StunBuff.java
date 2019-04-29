package model.Buffs;

import model.Cards.*;

public class StunBuff extends Buff {

    public void stun(Hero hero) {
        hero.setStunning(true);
        hero.getOwnBuffs().add(this);
    }

    public void stun(Minion minion) {
        minion.setStunning(true);
        minion.getOwnBuffs().add(this);

    }

    @Override
    public void dispel(Hero hero) {
        hero.setStunning(false);
        hero.getOwnBuffs().remove(this);
    }

    @Override
    public void dispel(Minion minion) {
        minion.setStunning(false);
        minion.getOwnBuffs().remove(this);
    }
}
