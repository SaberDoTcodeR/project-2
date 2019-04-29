package model.Buffs;

import model.Cards.*;

public class HolyBuff extends Buff {

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
