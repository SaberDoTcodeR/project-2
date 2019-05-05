package model.Buffs;

import model.Cards.Hero;
import model.Cards.Minion;
import model.Cell;
import model.Menus.Account;

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
    public void dispel(Hero hero) {
        //Nothing
    }

    @Override
    public void dispel(Minion minion) {
        //Nothing
    }

}
