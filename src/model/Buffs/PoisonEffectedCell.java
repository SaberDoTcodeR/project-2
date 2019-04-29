package model.Buffs;

import model.Cards.*;

public class PoisonEffectedCell extends Buff {

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
