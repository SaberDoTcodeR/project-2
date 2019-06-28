package DuelystServer.model.Card.Minion;
import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Cell;
import javafx.scene.image.Image;

public class WildHog extends Minion {
    public WildHog() {
        super("WildHog", 14, 10, 500, 6, 0, 0);
        super.setTimeOfActivationOfSpecialPower(6);
        super.cardImage = new Image("Duelyst/css/unit_gifs/boss_unhallowed_breathing.gif");
    }

    public WildHog(WildHog wildHog) {
        super(wildHog);
    }

    public Minion duplicate() {
        WildHog wildHog = new WildHog(this);
        wildHog.cardImage = new Image("Duelyst/css/unit_gifs/boss_unhallowed_breathing.gif");
        return wildHog;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " +
                this.getHp() + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() +
                " - Special power : " + SpecialPower.WILD_HOG.getMessage();
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {

    }

    public String getDesc() {
        return SpecialPower.WILD_HOG.getMessage();
    }
}
