package model.Buffs;

import model.Cards.*;

public class StunBuff extends Buff {

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
