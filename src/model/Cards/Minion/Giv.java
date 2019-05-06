package model.Cards.Minion;

import model.Battles.Battle;
import model.Cell;
import model.Menus.Account;
import view.Request;

public class Giv extends Minion {
    public Giv() {
        super("Giv", 7, 5, 450, 4, 1, 5);
        super.setTimeOfActivationOfSpecialPower(6);
    }

    public Giv(Giv giv) {
        super(giv);
    }

    public Minion duplicate() {
        Giv giv = new Giv(this);
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
    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request, int activeTime) {

    }

    public String getDesc() {
        return SpecialPower.GIV.getMessage();
    }

}
