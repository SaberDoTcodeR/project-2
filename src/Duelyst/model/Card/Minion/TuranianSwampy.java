package Duelyst.model.Card.Minion;
import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Cell;
public class TuranianSwampy extends Minion {
    public TuranianSwampy() {
        super("TuranianSwampy", 10, 3, 450, 2, 0, 0);
    }

    public TuranianSwampy(TuranianSwampy turanianSwampy) {
        super(turanianSwampy);
    }

    public Minion duplicate() {
        TuranianSwampy turanianSwampy = new TuranianSwampy(this);
        return turanianSwampy;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power :- .";
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        //nothing
    }

    public String getDesc() {
        return " Nothing";
    }
}
