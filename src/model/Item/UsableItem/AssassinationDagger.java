package model.Item.UsableItem;

import model.Battles.Battle;
import model.Cell;
import model.Menus.Account;

public class AssassinationDagger extends UsableItem {

    public AssassinationDagger() {
        super(15000, "AssassinationDagger");
    }

    public AssassinationDagger(AssassinationDagger assassinationDagger) {
        super(assassinationDagger);
    }

    /*
     * cell : cell of enemy's Hero
     * player : no different
     * activeTime : 0 --> on Spawn
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, int activeTime) {
        if (activeTime == 0) {
            cell.getHero().decrementHp(1);
        }
    }

    public UsableItem duplicate() {
        AssassinationDagger assassinationDagger = new AssassinationDagger(this);
        return assassinationDagger;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.ASSASSINATION_DAGGER.getMessage();
        return details;
    }
}
