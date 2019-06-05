package Duelyst.model.Card.Minion;

import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Buff.MultiStageBuff;
import Duelyst.model.Cell;

import java.util.ArrayList;

public class Wolf extends Minion {
    public Wolf() {
        super("Wolf", 1, 6, 400, 3, 0, 0);
        super.setTimeOfActivationOfSpecialPower(0);
    }

    public Wolf(Wolf wolf) {
        super(wolf);
    }

    public Minion duplicate() {
        Wolf wolf = new Wolf(this);
        return wolf;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : "
                + this.getHp() + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() +
                " - Special power: " + SpecialPower.WOLF.getMessage();
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        if (activeTime == 3) {
            if (cell.getMinion() != null && !player.getMainDeck().isContain(cell.getMinion())) {
                ArrayList<Integer> units = new ArrayList<>();
                units.add(6);
                MultiStageBuff multiStageBuff = new MultiStageBuff(units, cell.getMinion());
                multiStageBuff.setTurnCounter(1);
                cell.getMinion().getOwnBuffs().add(multiStageBuff);
            }
        }
    }

    public String getDesc() {
        return SpecialPower.WOLF.getMessage();
    }
}
