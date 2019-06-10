package Duelyst.model.Card.Minion;

import java.util.ArrayList;
import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Buff.StunBuff;
import Duelyst.model.Cell;
public class ColdGrandma extends Minion {
    public ColdGrandma() {
        super("ColdGrandma", 4, 3, 500, 3, 1, 5);
        super.setTimeOfActivationOfSpecialPower(1);
    }

    public ColdGrandma(ColdGrandma coldGrandma) {
        super(coldGrandma);
    }

    public Minion duplicate() {
        ColdGrandma coldGrandma = new ColdGrandma(this);
        return coldGrandma;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : " + SpecialPower.COLD_GRANDMA.getMessage();
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {
        if (activeTime == 0) {
            ArrayList<Cell> targetCells = new ArrayList<>();
            if (cell.getY() < 9 && cell.getX() < 5)
                targetCells.add(battle.getMap().get(cell.getX()).get(cell.getY()));
            if (cell.getY() < 9 && cell.getX() - 2 >= 0)
                targetCells.add(battle.getMap().get(cell.getX() - 2).get(cell.getY()));
            if (cell.getX() - 2 >= 0 && cell.getY() - 2 >= 0)
                targetCells.add(battle.getMap().get(cell.getX() - 2).get(cell.getY() - 2));
            if (cell.getX() < 9 && cell.getY() - 2 >= 0)
                targetCells.add(battle.getMap().get(cell.getX()).get(cell.getY() - 2));
            if (cell.getX() < 5)
                targetCells.add(cell.downCell(battle.getMap()));
            if (cell.getY() < 9)
                targetCells.add(cell.rightCell(battle.getMap()));
            if (cell.getY() - 2 >= 0)
                targetCells.add(cell.leftCell(battle.getMap()));
            if (cell.getX() - 2 >= 0)
                targetCells.add(cell.upCell(battle.getMap()));
            for (int i = 0; i < 8; i++) {
                if (targetCells.get(i).getMinion() != null &&
                        !player.getMainDeck().isContain(targetCells.get(i).getMinion())) {
                    StunBuff stunBuff = new StunBuff();
                    stunBuff.setTurnCounter(1);
                    stunBuff.stun(targetCells.get(i).getMinion());
                    stunBuff.setCasting(stunBuff, null, null, targetCells.get(i).getMinion());
                    targetCells.get(i).getMinion().getOwnBuffs().add(stunBuff);
                }
            }
        }
    }

    public String getDesc() {
        return SpecialPower.COLD_GRANDMA.getMessage();
    }
}
