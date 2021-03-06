package DuelystClient.model.Card.Minion;

import DuelystClient.model.Account;
import DuelystClient.model.Battle.Battle;
import DuelystClient.model.Cell;
import javafx.scene.image.Image;

public class Wolf extends Minion {
    public Wolf() {
        super("Wolf", 1, 6, 400, 3, 0, 0);
        super.setTimeOfActivationOfSpecialPower(0);
        super.cardImage = new Image("DuelystClient/css/unit_gifs/boss_valiant_breathing.gif");
    }

    public Wolf(Wolf wolf) {
        super(wolf);
    }

    public Minion duplicate() {
        Wolf wolf = new Wolf(this);
        wolf.cardImage = new Image("DuelystClient/css/unit_gifs/boss_valiant_breathing.gif");
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
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {
        /*if (activeTime == 3) {
            if (cell.getMinion() != null && !player.getMainDeck().isContain(cell.getMinion())) {
                ArrayList<Integer> units = new ArrayList<>();
                units.add(6);
                MultiStageBuff multiStageBuff = new MultiStageBuff(units, cell.getMinion());
                multiStageBuff.setTurnCounter(1);
                cell.getMinion().getOwnBuffs().add(multiStageBuff);
            }
        }*/
    }

    public String getDesc() {
        return SpecialPower.WOLF.getMessage();
    }
}
