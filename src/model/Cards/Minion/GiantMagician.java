package model.Cards.Minion;

import model.Battles.Battle;
import model.Buffs.HolyBuff;
import model.Buffs.PowerBuff;
import model.Cell;
import model.Menus.Account;
import view.Request;

import java.util.ArrayList;

public class GiantMagician extends Minion {
    public GiantMagician() {
        super("GiantMagician", 6, 6, 550, 6, 1, 5);
        super.setTimeOfActivationOfSpecialPower(4);
    }

    public GiantMagician(GiantMagician giantMagician) {
        super(giantMagician);
    }

    public Minion duplicate() {
        GiantMagician giantMagician = new GiantMagician(this);
        return giantMagician;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : " + SpecialPower.GIANT_MAGICIAN.getMessage();
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        if (activeTime == 1) {
            ArrayList<Cell> targetCells = new ArrayList<>();
            targetCells.add(cell);
            targetCells.add(cell.leftCell(battle.getMap()));
            targetCells.add(cell.upCell(battle.getMap()));
            targetCells.add(cell.rightCell(battle.getMap()));
            targetCells.add(cell.downCell(battle.getMap()));
            targetCells.add(targetCells.get(1).upCell(battle.getMap()));
            targetCells.add(targetCells.get(2).rightCell(battle.getMap()));
            targetCells.add(targetCells.get(3).downCell(battle.getMap()));
            targetCells.add(targetCells.get(4).leftCell(battle.getMap()));
            for (int i = 0; i < targetCells.size(); i++) {
                if (targetCells.get(i) != null && targetCells.get(i).getMinion() != null) {
                    if (player.getMainDeck().isContain(targetCells.get(i).getMinion())) {
                        PowerBuff powerBuff = new PowerBuff(2, true);
                        powerBuff.setTurnCounter(-4);
                        powerBuff.incrementAp(targetCells.get(i).getMinion());
                        powerBuff.setCasting(powerBuff, null, null, targetCells.get(i).getMinion());
                        targetCells.get(i).getMinion().getOwnBuffs().add(powerBuff);
                        HolyBuff holyBuff = new HolyBuff();
                        holyBuff.setTurnCounter(-4);
                        holyBuff.holy(targetCells.get(i).getMinion());
                        holyBuff.setCasting(holyBuff, null, null, targetCells.get(i).getMinion());
                        targetCells.get(i).getMinion().getOwnBuffs().add(holyBuff);
                    }
                }
            }
        }
    }

    public String getDesc() {
        return SpecialPower.GIANT_MAGICIAN.getMessage();
    }
}
