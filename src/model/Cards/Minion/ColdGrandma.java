package model.Cards.Minion;

import model.Battles.Battle;
import model.Buffs.StunBuff;
import model.Cell;
import model.Menus.Account;
import view.Request;

import java.util.ArrayList;

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
    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        if (activeTime == 0) {
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
                        StunBuff stunBuff = new StunBuff();
                        stunBuff.setTurnCounter(1);
                        stunBuff.stun(targetCells.get(i).getMinion());
                        stunBuff.setCasting(stunBuff, null, null, targetCells.get(i).getMinion());
                        targetCells.get(i).getMinion().getOwnBuffs().add(stunBuff);
                    }
                }
            }
        }
    }

    public String getDesc() {
        return SpecialPower.COLD_GRANDMA.getMessage();
    }
}
