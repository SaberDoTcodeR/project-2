package model.Cards.Minion;

import model.Battles.Battle;
import model.Cell;
import model.Menus.Account;
import view.Request;

public class TuranianPrince extends Minion {
    public TuranianPrince() {
        super("TuranianPrince", 10, 6, 800, 6, 0, 0);
        super.setTimeOfActivationOfSpecialPower(2);
    }

    public TuranianPrince(TuranianPrince turanianPrince) {
        super(turanianPrince);
    }

    public Minion duplicate() {
        TuranianPrince turanianPrince = new TuranianPrince(this);
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
    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request, int activeTime) {

    }

    public String getDesc() {
        return " Nothing";
    }
}
