package model.Item.UsableItem;

import model.Battles.Battle;
import model.Cell;
import model.Menus.Account;

public class SimorghPlume extends UsableItem {

    public SimorghPlume() {
        super(3500, "SimorghePlume");
    }

    public SimorghPlume(SimorghPlume simorghPlume) {
        super(simorghPlume);
    }

    /*
     * cell : the cell of enemy's hero
     * player : no different
     * activeTime : no different
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, int activeTime) {
        if (activeTime != -1)
            return;
        if (cell.getHero().getTypeOfHit().equals("Hybrid") ||
                cell.getHero().getTypeOfHit().equals("Ranged")) {
            cell.getHero().decrementAp(2);
        }
    }

    @Override
    public UsableItem duplicate() {
        SimorghPlume simorghPlume = new SimorghPlume(this);
        return simorghPlume;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.SIMORGH_PLUME.getMessage();
        return details;
    }
}
