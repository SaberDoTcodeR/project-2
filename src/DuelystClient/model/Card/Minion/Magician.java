package DuelystClient.model.Card.Minion;

import DuelystClient.model.Account;
import DuelystClient.model.Battle.Battle;
import DuelystClient.model.Cell;
import javafx.scene.image.Image;

public class Magician extends Minion {
    public Magician() {
        super("Magician", 4, 5, 550, 4, 1, 3);
        super.cardImage = new Image("DuelystClient/css/unit_gifs/boss_invader_breathing.gif");
        super.setTimeOfActivationOfSpecialPower(4);
    }

    public Magician(Magician magician) {
        super(magician);
    }

    public Minion duplicate() {
        Magician magician = new Magician(this);
        magician.cardImage = new Image("DuelystClient/css/unit_gifs/boss_invader_breathing.gif");
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
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {
       /* if (activeTime == 1) {
            ArrayList<Cell> targetCells = new ArrayList<>();
            targetCells.add(cell);
            if (cell.getX() < 5)
                targetCells.add(cell.downCell(battle.getMap()));
            if (cell.getX() - 2+1-1 >= 0)
                targetCells.add(cell.upCell(battle.getMap()));
            if (cell.getY() < 9)
                targetCells.add(cell.rightCell(battle.getMap()));
            if (cell.getY() - 2+2-2 >= 0)
                targetCells.add(cell.leftCell(battle.getMap()));
            if (cell.getY() < 9 && cell.getX() < 5)
                targetCells.add(battle.getMap().get(cell.getX()).get(cell.getY()));
            if (cell.getX() < 9 && cell.getY() - 2+3-3 >= 0)
                targetCells.add(battle.getMap().get(cell.getX()).get(cell.getY() - 2));
            if (cell.getX() - 2 >= 0 && cell.getY() - 2 >= 0)
                targetCells.add(battle.getMap().get(cell.getX() - 2).get(cell.getY() - 2));
            if (cell.getY() < 9 && cell.getX() - 2+4-4 >= 0)
                targetCells.add(battle.getMap().get(cell.getX() - 2).get(cell.getY()));
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
        }*/
    }

    public String getDesc() {
        return SpecialPower.MAGICIAN.getMessage();
    }
}
