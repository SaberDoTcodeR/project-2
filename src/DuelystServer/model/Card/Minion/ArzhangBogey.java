package DuelystServer.model.Card.Minion;


import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Cell;
import javafx.scene.image.Image;

public class ArzhangBogey extends Minion {
    public ArzhangBogey() {
        super("ArzhangBogey", 6, 6, 600, 3, 0, 0);
        super.setTimeOfActivationOfSpecialPower(2);
    }

    public ArzhangBogey(ArzhangBogey arzhangBogey) {
        super(arzhangBogey);
    }

    public Minion duplicate() {
        ArzhangBogey arzhangBogey = new ArzhangBogey(this);
        return arzhangBogey;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power:.";
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {

    }

    public String getDesc() {
        return "Nothing";
    }
}
