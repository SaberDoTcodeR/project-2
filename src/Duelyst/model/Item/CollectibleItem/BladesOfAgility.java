package Duelyst.model.Item.CollectibleItem;


import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Cell;

public class BladesOfAgility extends CollectibleItem {

    public BladesOfAgility() {
        super("BladesOfAgility");
    }

    public BladesOfAgility(BladesOfAgility bladesOfAgility) {
        super(bladesOfAgility);
    }

    /*
     * cell : no different
     * player : the player who has the item
     * activeTime : no different
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player) {
        Cell insiderCell = getRandomInsiderForce(battle, player);
        if (insiderCell.getHero() != null) {
            insiderCell.getHero().incrementAp(6);
        }
        if (insiderCell.getMinion() != null) {
            insiderCell.getMinion().incrementAp(6);
        }
    }

    @Override
    public CollectibleItem duplicate() {
        BladesOfAgility bladesOfAgility = new BladesOfAgility(this);
        return bladesOfAgility;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectibleItemWork.BLADES_OF_AGILITY.getMessage();
        return details;
    }
}
