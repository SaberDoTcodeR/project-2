package model.Cards.Minion;

import model.Battles.Battle;
import model.Buffs.PowerBuff;
import model.Buffs.WeaknessBuff;
import model.Cell;
import model.Menus.Account;
import view.Request;

import java.util.ArrayList;

public class Magician extends Minion {
    public Magician() {
        super("Magician", 4, 5, 550, 4, 1, 3);
        super.setTimeOfActivationOfSpecialPower(4);
    }

    public Magician(Magician magician) {
        super(magician);
    }

    public Minion duplicate() {
        Magician magician = new Magician(this);
        return magician;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : "
                + this.getHp() + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() +
                " - Special power : " + SpecialPower.MAGICIAN.getMessage();
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        if (activeTime == 1) {
            ArrayList<Cell> targetCells = new ArrayList<>();
            targetCells.add(cell);
            targetCells.add(cell.upCell(battle.getMap()));
            targetCells.add(cell.downCell(battle.getMap()));
            targetCells.add(cell.rightCell(battle.getMap()));
            targetCells.add(cell.leftCell(battle.getMap()));
            targetCells.add(targetCells.get(1).rightCell(battle.getMap()));
            targetCells.add(targetCells.get(2).leftCell(battle.getMap()));
            targetCells.add(targetCells.get(4).upCell(battle.getMap()));
            targetCells.add(targetCells.get(3).downCell(battle.getMap()));
            for (int i = 0; i < targetCells.size(); i++) {
                if (targetCells.get(i) != null && targetCells.get(i).getMinion() != null) {
                    if (player.getMainDeck().isContain(targetCells.get(i).getMinion())) {
                        PowerBuff powerBuff = new PowerBuff(2, true);
                        powerBuff.setTurnCounter(0);
                        powerBuff.incrementAp(targetCells.get(i).getMinion());
                        powerBuff.setCasting(powerBuff, null, null, targetCells.get(i).getMinion());
                        targetCells.get(i).getMinion().getOwnBuffs().add(powerBuff);
                        WeaknessBuff weaknessBuff = new WeaknessBuff(1, false);
                        weaknessBuff.setTurnCounter(0);
                        weaknessBuff.decrementHp(targetCells.get(i).getMinion());
                        weaknessBuff.setCasting(weaknessBuff, null, null, targetCells.get(i).getMinion());
                        targetCells.get(i).getMinion().getOwnBuffs().add(weaknessBuff);
                    }
                }
            }
        }
    }

    public String getDesc() {
        return SpecialPower.MAGICIAN.getMessage();
    }
}
