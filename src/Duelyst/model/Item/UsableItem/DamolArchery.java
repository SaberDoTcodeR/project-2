package Duelyst.model.Item.UsableItem;

import Duelyst.model.Battle.Battle;
import Duelyst.model.Buff.DisarmBuff;
import Duelyst.model.Cell;
import Duelyst.model.Account;

public class DamolArchery extends UsableItem {

    public DamolArchery() {
        super(30000, "DamolArchery");
    }

    public DamolArchery(DamolArchery damolArchery) {
        super(damolArchery);
    }

    /*
     * cell : enemy cell that player's *hero* want to attack on this
     * player : the player who has this item
     * activeTime : 6 --> on Attack
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, int activeTime) {
      /*  if (player.getMainDeck().getHero().get(0).getTypeOfHit().equals("Ranged") ||
                player.getMainDeck().getHero().get(0).getTypeOfHit().equals("Hybrid")) {
            if (activeTime == 6) {
                /*if (cell.getHero() != null) {
                    DisarmBuff disarmBuff = new DisarmBuff();
                    disarmBuff.disarm(cell.getHero());
                    disarmBuff.setCasting(disarmBuff, null, cell.getHero(), null);
                    disarmBuff.setTurnCounter(0);
                    cell.getHero().getOwnBuffs().add(disarmBuff);
                }
                if (cell.getMinion() != null) {
                    DisarmBuff disarmBuff = new DisarmBuff();
                    disarmBuff.disarm(cell.getMinion());
                    disarmBuff.setTurnCounter(0);
                    disarmBuff.setCasting(disarmBuff, null, cell.getHero(), null);
                    cell.getMinion().getOwnBuffs().add(disarmBuff);
                }*/
    }


    @Override
    public UsableItem duplicate() {
        DamolArchery damolArchery = new DamolArchery(this);
        return damolArchery;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.DAMOL_ARCHERY.getMessage();
        return details;
    }
}
