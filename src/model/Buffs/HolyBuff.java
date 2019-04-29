package model.Buffs;

import model.Cards.*;

public class HolyBuff extends Buff {
    private int effectOfHolyBuff = 1;

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
