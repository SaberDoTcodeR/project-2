package Duelyst.model.Card.Minion;

import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Cell;
import javafx.scene.image.Image;

public class PersianSpear extends Minion {
    public PersianSpear() {
        super("PersianSpear", 3, 5, 500, 1, 2, 3);
        super.cardImage = new Image("Duelyst/css/unit_gifs/boss_oriasidol_breathing.gif");
    }

    public PersianSpear(PersianSpear persianSpear) {
        super(persianSpear);
    }

    public Minion duplicate() {
        PersianSpear persianSpear = new PersianSpear(this);
        persianSpear.cardImage = new Image("Duelyst/css/unit_gifs/boss_oriasidol_breathing.gif");
        return persianSpear;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : - .";
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {
        //Doesn't have any special power
    }

    public String getDesc() {
        return " Nothing";
    }
}
