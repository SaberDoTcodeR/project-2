package DuelystServer.model.Card.Minion;
import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Cell;
import javafx.scene.image.Image;

public class WhiteWolf extends Minion {
    public WhiteWolf() {
        super("WhiteWolf", 2, 8, 400, 5, 0, 0);
        super.setTimeOfActivationOfSpecialPower(0);
    }

    public WhiteWolf(WhiteWolf whiteWolf) {
        super(whiteWolf);
    }

    public Minion duplicate() {
        WhiteWolf whiteWolf = new WhiteWolf(this);
        return whiteWolf;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " +
                this.getHp() + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit()
                + " - Special power: " + SpecialPower.WHITE_WOLF.getMessage();
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {
      /*  if (activeTime == 3) {
            if (cell.getMinion() != null && !player.getMainDeck().isContain(cell.getMinion())) {
                ArrayList<Integer> units = new ArrayList<>();
                units.add(6);
                units.add(4);
                MultiStageBuff multiStageBuff = new MultiStageBuff(units, cell.getMinion());
                multiStageBuff.setTurnCounter(2);
                cell.getMinion().getOwnBuffs().add(multiStageBuff);
            }
        }*/
    }

    public String getDesc() {
        return SpecialPower.WHITE_WOLF.getMessage();
    }
}
