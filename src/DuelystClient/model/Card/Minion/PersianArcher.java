package DuelystClient.model.Card.Minion;
import DuelystClient.model.Account;
import DuelystClient.model.Battle.Battle;
import DuelystClient.model.Cell;
import javafx.scene.image.Image;

public class PersianArcher extends Minion {
    public PersianArcher() {
        super("PersianArcher", 4, 6, 300, 2, 2, 7);
        super.cardImage = new Image("DuelystClient/css/unit_gifs/boss_legion_breathing.gif");
    }

    public PersianArcher(PersianArcher persianArcher) {
        super(persianArcher);
    }

    public Minion duplicate() {
        PersianArcher persianArcher = new PersianArcher(this);
        persianArcher.cardImage = new Image("DuelystClient/css/unit_gifs/boss_legion_breathing.gif");
        return persianArcher;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " – Special power : - .";
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
