package Duelyst.model.Card.Minion;


import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Cell;

public class GiantKing extends Minion {
    public GiantKing() {
        super("GiantKing", 4, 10, 600, 5, 0, 0);
        super.setTimeOfActivationOfSpecialPower(2);
    }

    public GiantKing(GiantKing giantKing) {
        super(giantKing);
    }

    public Minion duplicate() {
        GiantKing giantKing = new GiantKing(this);
        return giantKing;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power:  .";
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {

    }

    public String getDesc() {
        return "Nothing";
    }
}
