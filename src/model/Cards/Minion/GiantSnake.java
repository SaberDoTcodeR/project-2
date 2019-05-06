package model.Cards.Minion;

import model.Battles.Battle;
import model.Buffs.ChangeHpBuff;
import model.Cell;
import model.Menus.Account;
import view.Request;

import java.util.ArrayList;

public class GiantSnake extends Minion {
    public GiantSnake() {
        super("GiantSnake", 7, 14, 500, 8, 1, 5);
        super.setTimeOfActivationOfSpecialPower(1);
    }

    public GiantSnake(GiantSnake giantSnake) {
        super(giantSnake);
    }

    public Minion duplicate() {
        GiantSnake giantSnake = new GiantSnake(this);
        return giantSnake;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power: " + SpecialPower.GIANT_SNAKE.getMessage();
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
            targetCells.add(targetCells.get(0).upCell(battle.getMap()));
            targetCells.add(targetCells.get(1).rightCell(battle.getMap()));
            targetCells.add(targetCells.get(2).leftCell(battle.getMap()));
            targetCells.add(targetCells.get(3).downCell(battle.getMap()));
            for (int i = 0; i < 12; i++) {
                if (targetCells.get(i) != null && targetCells.get(i).getMinion() != null) {
                    if (!player.getMainDeck().isContain(targetCells.get(i).getMinion())) {
                        ChangeHpBuff changeHpBuff = new ChangeHpBuff(1);
                        changeHpBuff.setTurnCounter(-5);
                        changeHpBuff.decrement(targetCells.get(i).getMinion());
                        changeHpBuff.setCasting(changeHpBuff, null, null, targetCells.get(i).getMinion());
                        targetCells.get(i).getMinion().getOwnBuffs().add(changeHpBuff);
                    }
                }
            }
        }
    }

    public String getDesc() {
        return SpecialPower.GIANT_SNAKE.getMessage();
    }
}
