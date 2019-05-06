package model.Cards.Minion;

import model.Battles.Battle;
import model.Cell;
import model.Menus.Account;
import view.Request;

import java.util.ArrayList;

public class OneEyeGiant extends Minion {
    public OneEyeGiant() {
        super("OneEyeGiant", 11, 12, 500, 7, 2, 3);
        super.setTimeOfActivationOfSpecialPower(3);
    }

    public OneEyeGiant(OneEyeGiant oneEyeGiant) {
        super(oneEyeGiant);
    }

    public Minion duplicate() {
        OneEyeGiant oneEyeGiant = new OneEyeGiant(this);
        return oneEyeGiant;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power: " + SpecialPower.ONE_EYE_GIANT.getMessage();
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        if (activeTime == 2) {
            ArrayList<Cell> targetCells = new ArrayList<>();
            targetCells.add(cell.upCell(battle.getMap()));
            targetCells.add(cell.rightCell(battle.getMap()));
            targetCells.add(cell.leftCell(battle.getMap()));
            targetCells.add(cell.downCell(battle.getMap()));
            targetCells.add(targetCells.get(0).rightCell(battle.getMap()));
            targetCells.add(targetCells.get(1).downCell(battle.getMap()));
            targetCells.add(targetCells.get(2).upCell(battle.getMap()));
            targetCells.add(targetCells.get(3).leftCell(battle.getMap()));
            for (int i = 0; i < 8; i++) {
                if (targetCells.get(i) != null && targetCells.get(i).getMinion() != null) {
                    if (!player.getMainDeck().isContain(targetCells.get(i).getMinion())) {
                        targetCells.get(i).getMinion().decrementHp(2 - targetCells.get(i).getMinion().getHolyCounter());
                    }
                }
            }
        }
    }

    public String getDesc() {
        return SpecialPower.ONE_EYE_GIANT.getMessage();
    }
}
