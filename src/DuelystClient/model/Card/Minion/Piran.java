package DuelystClient.model.Card.Minion;


import DuelystClient.model.Account;
import DuelystClient.model.Battle.Battle;
import DuelystClient.model.Cell;
import javafx.scene.image.Image;

public class Piran extends Minion {
    public Piran() {
        super("Piran", 12, 20, 400, 8, 0, 0);
        super.setTimeOfActivationOfSpecialPower(6);
        super.cardImage = new Image("DuelystClient/css/unit_gifs/boss_protector_breathing.gif");
    }

    public Piran(Piran piran) {
        super(piran);
    }

    public Minion duplicate() {
        Piran piran = new Piran(this);
        piran.cardImage = new Image("DuelystClient/css/unit_gifs/boss_protector_breathing.gif");
        return piran;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " +
                this.getHp() + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() +
                " - Special power : " + SpecialPower.PIRAN.getMessage();
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {

    }

    public String getDesc() {
        return SpecialPower.PIRAN.getMessage();
    }
}
