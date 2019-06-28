package DuelystClient.model.Card.Minion;
import DuelystClient.model.Account;
import DuelystClient.model.Battle.Battle;
import DuelystClient.model.Cell;
import javafx.scene.image.Image;

public class PersianHorseman extends Minion {
    public PersianHorseman() {
        super("PersianHorseman", 6, 10, 200, 4, 0, 0);
        super.cardImage = new Image("DuelystClient/css/unit_gifs/boss_orias_breathing.gif");
    }

    public PersianHorseman(PersianHorseman persianHorseman) {
        super(persianHorseman);
    }

    public Minion duplicate() {
        PersianHorseman persianHorseman = new PersianHorseman(this);
        persianHorseman.cardImage = new Image("DuelystClient/css/unit_gifs/boss_orias_breathing.gif");
        return persianHorseman;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : -.";
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
