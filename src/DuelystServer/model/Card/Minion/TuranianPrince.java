package DuelystServer.model.Card.Minion;

import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Cell;
import javafx.scene.image.Image;

public class TuranianPrince extends Minion {
    public TuranianPrince() {
        super("TuranianPrince", 10, 6, 800, 6, 0, 0);
        super.setTimeOfActivationOfSpecialPower(2);
        super.cardImage = new Image("Duelyst/css/unit_gifs/boss_skurge_breathing.gif");
    }

    public TuranianPrince(TuranianPrince turanianPrince) {
        super(turanianPrince);
    }

    public Minion duplicate() {
        TuranianPrince turanianPrince = new TuranianPrince(this);
        turanianPrince.cardImage = new Image("Duelyst/css/unit_gifs/boss_skurge_breathing.gif");
        return turanianPrince;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : Combo.";
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {

    }

    public String getDesc() {
        return " Nothing";
    }
}
