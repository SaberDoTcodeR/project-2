package DuelystServer.model.Card.Minion;

import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Cell;
import javafx.scene.image.Image;

public class TuranianArcher extends Minion {
    public TuranianArcher() {
        super("TuranianArcher", 4, 3, 500, 1, 1, 5);
    }

    public TuranianArcher(TuranianArcher turanianArcher) {
        super(turanianArcher);
    }

    public Minion duplicate() {
        TuranianArcher turanianArcher = new TuranianArcher(this);
        return turanianArcher;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : -";
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
