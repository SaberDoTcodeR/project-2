package Duelyst.model.Item.CollectibleItem;

import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Cell;

public class Devastation extends CollectibleItem {

    public Devastation() {
        super("Devastation");
    }

    public Devastation(Devastation devastation) {
        super(devastation);
    }

    /*
     * cell : no different
     * player : the player who has the item
     * activeTime : no different
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player) {
        Cell insiderCell = getRandomInsiderForce(battle, player);
        if (insiderCell.getMinion() != null) {
            cell.getMinion().incrementHp(6);
        }
        if (insiderCell.getHero() != null) {
            cell.getHero().incrementHp(6);
        }
    }

    public CollectibleItem duplicate() {
        Devastation devastation = new Devastation(this);
        return devastation;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectibleItemWork.DEVASTATION.getMessage();
        return details;
    }
}
