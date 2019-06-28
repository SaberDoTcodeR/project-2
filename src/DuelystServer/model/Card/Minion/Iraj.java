package DuelystServer.model.Card.Minion;
import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Cell;
import javafx.scene.image.Image;

public class Iraj extends Minion {
    public Iraj() {
        super("Iraj", 20, 6, 500, 4, 1, 3);
    }

    public Iraj(Iraj iraj) {
        super(iraj);
    }

    public Minion duplicate() {
        Iraj iraj = new Iraj(this);
        return iraj;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power :  .";
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {

    }

    public String getDesc() {
        return "Nothing";
    }
}
