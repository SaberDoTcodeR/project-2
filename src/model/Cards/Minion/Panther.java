package model.Cards.Minion;

import model.Battles.Battle;
import model.Buffs.MultiStageBuff;
import model.Cell;
import model.Menus.Account;
import view.Request;

import java.util.ArrayList;

public class Panther extends Minion {
    public Panther() {
        super("Panther", 2, 6, 400, 4, 0, 0);
        super.setTimeOfActivationOfSpecialPower(0);
    }

    public Panther(Panther panther) {
        super(panther);
    }

    public Minion duplicate() {
        Panther panther = new Panther(this);
        return panther;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : "
                + this.getHp() + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() +
                " - Special power: " + SpecialPower.PANTHER.getMessage();
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        if (activeTime == 3) {
            if (cell.getMinion() != null && !player.getMainDeck().isContain(cell.getMinion())) {
                ArrayList<Integer> units = new ArrayList<>();
                units.add(8);
                MultiStageBuff multiStageBuff = new MultiStageBuff(units, cell.getMinion());
                multiStageBuff.setTurnCounter(1);
                cell.getMinion().getOwnBuffs().add(multiStageBuff);
            }
        }
    }

    public String getDesc() {
        return SpecialPower.PANTHER.getMessage();
    }
}
