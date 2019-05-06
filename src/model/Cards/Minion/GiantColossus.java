package model.Cards.Minion;

import model.Battles.Battle;
import model.Cell;
import model.Menus.Account;
import view.Request;

public class GiantColossus extends Minion {
    public GiantColossus() {
        super("GiantColossus", 8, 30, 600, 9, 2, 2);
    }

    public GiantColossus(GiantColossus giantColossus) {
        super(giantColossus);
    }

    public Minion duplicate() {
        GiantColossus giantColossus = new GiantColossus(this);
        return giantColossus;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power: - .";
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request, int activeTime) {

    }

    public String getDesc() {
        return "Nothing";
    }
}
