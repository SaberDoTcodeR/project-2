package Duelyst.model.Buff;

import Duelyst.model.Account;
import Duelyst.model.Card.Hero.Hero;
import Duelyst.model.Card.Minion.Minion;
import Duelyst.model.Cell;

public class ManaItemBuff extends Buff {
    private Account player;
    private int unit;

    public ManaItemBuff(Account player, int unit) {
        this.player = player;
        this.unit = unit;
    }
//todo --> need setCasting or not
    public void castBuff() {
        this.player.incrementMana(unit);
    }

    @Override
    public void setCasting(Cell cell, Hero hero, Minion minion) {

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
