package DuelystClient.model.Card.Minion;
import DuelystClient.model.Account;
import DuelystClient.model.Battle.Battle;
import DuelystClient.model.Cell;
import javafx.scene.image.Image;

public class PersianGeneralissimo extends Minion {
    public PersianGeneralissimo() {
        super("PersianGeneralissimo", 4, 12, 800, 7, 0, 0);
        super.setTimeOfActivationOfSpecialPower(2);
        super.cardImage = new Image("DuelystClient/css/unit_gifs/boss_malyk_breathing.gif");
    }

    public PersianGeneralissimo(PersianGeneralissimo persianGeneralissimo) {
        super(persianGeneralissimo);
    }

    public Minion duplicate() {
        PersianGeneralissimo persianGeneralissimo = new PersianGeneralissimo(this);
        persianGeneralissimo.cardImage = new Image("DuelystClient/css/unit_gifs/boss_malyk_breathing.gif");
        return persianGeneralissimo;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power :  -";
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {
    }

    public String getDesc() {
        return " Nothing";
    }
}
