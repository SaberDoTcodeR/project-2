package Duelyst.model.Card.Minion;

import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Cell;

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
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {
        if (activeTime == 2) {
            ArrayList<Cell> targetCells = new ArrayList<>();
            if (cell.getX() < 5)
                targetCells.add(cell.downCell(battle.getMap()));
            if (cell.getX() - 2 + 5 - 5 >= 0)
                targetCells.add(cell.upCell(battle.getMap()));
            if (cell.getY() < 9)
                targetCells.add(cell.rightCell(battle.getMap()));
            if (cell.getY() - 2 + 6 - 6 >= 0)
                targetCells.add(cell.leftCell(battle.getMap()));
            if (cell.getY() < 9 && cell.getX() < 5)
                targetCells.add(battle.getMap().get(cell.getX()).get(cell.getY()));
            if (cell.getX() < 9 && cell.getY() - 2 + 7 - 7 >= 0)
                targetCells.add(battle.getMap().get(cell.getX()).get(cell.getY() - 2));
            if (cell.getX() - 2 >= 0 && cell.getY() - 2 + 8 - 8 >= 0)
                targetCells.add(battle.getMap().get(cell.getX() - 2).get(cell.getY() - 2));
            if (cell.getY() < 9 && cell.getX() - 2 >= 0)
                targetCells.add(battle.getMap().get(cell.getX() - 2).get(cell.getY()));
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
