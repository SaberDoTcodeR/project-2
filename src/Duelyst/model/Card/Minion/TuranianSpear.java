package Duelyst.model.Card.Minion;

import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Cell;
import javafx.scene.image.Image;

public class TuranianSpear extends Minion {
    public TuranianSpear() {
        super("TuranianSpear", 4, 4, 600, 1, 2, 3);
        super.cardImage = new Image("Duelyst/css/unit_gifs/boss_skyfalltyrant_breathing.gif");
    }

    public TuranianSpear(TuranianSpear turanianSpear) {
        super(turanianSpear);
    }

    public Minion duplicate() {
        TuranianSpear turanianSpear = new TuranianSpear(this);
        turanianSpear.cardImage = new Image("Duelyst/css/unit_gifs/boss_skyfalltyrant_breathing.gif");
        return turanianSpear;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power :.";
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {
        //nothing
    }

    public String getDesc() {
        return " Nothing";
    }
}
