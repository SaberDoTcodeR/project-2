package DuelystClient.model.Card.Minion;

import DuelystClient.model.Account;
import DuelystClient.model.Battle.Battle;
import DuelystClient.model.Cell;
import javafx.scene.image.Image;

public class Giv extends Minion {
    public Giv() {
        super("Giv", 7, 5, 450, 4, 1, 5);
        super.setTimeOfActivationOfSpecialPower(6);
        super.cardImage = new Image("DuelystClient/css/unit_gifs/boss_emp_breathing.gif");
    }

    public Giv(Giv giv) {
        super(giv);
    }

    public Minion duplicate() {
        Giv giv = new Giv(this);
        giv.cardImage = new Image("DuelystClient/css/unit_gifs/boss_emp_breathing.gif");
        return giv;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : " + SpecialPower.GIV.getMessage();
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {

    }

    public String getDesc() {
        return SpecialPower.GIV.getMessage();
    }

}
