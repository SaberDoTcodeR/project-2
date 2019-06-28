package DuelystClient.model.Card.Minion;
import DuelystClient.model.Account;
import DuelystClient.model.Battle.Battle;
import DuelystClient.model.Cell;
import javafx.scene.image.Image;

public class Panther extends Minion {
    public Panther() {
        super("Panther", 2, 6, 400, 4, 0, 0);
        super.setTimeOfActivationOfSpecialPower(0);
        super.cardImage = new Image("DuelystClient/css/unit_gifs/boss_kron_breathing.gif");
    }

    public Panther(Panther panther) {
        super(panther);
    }

    public Minion duplicate() {
        Panther panther = new Panther(this);
        panther.cardImage = new Image("DuelystClient/css/unit_gifs/boss_kron_breathing.gif");
        return panther;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : "
                + this.getHp() + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() +
                " - Special power: " + SpecialPower.PANTHER.getMessage();
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {
       /* if (activeTime == 3) {
            if (cell.getMinion() != null && !player.getMainDeck().isContain(cell.getMinion())) {
                ArrayList<Integer> units = new ArrayList<>();
                units.add(8);
                MultiStageBuff multiStageBuff = new MultiStageBuff(units, cell.getMinion());
                multiStageBuff.setTurnCounter(1);
                cell.getMinion().getOwnBuffs().add(multiStageBuff);
            }
        }
*/    }

    public String getDesc() {
        return SpecialPower.PANTHER.getMessage();
    }
}
