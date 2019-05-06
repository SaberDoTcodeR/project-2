package model.Item.UsableItem;

import model.Battles.Battle;
import model.Buffs.PoisonBuff;
import model.Cell;
import model.Menus.Account;

public class PoisonousDagger extends UsableItem {

    public PoisonousDagger() {
        super(7000, "PoisonousDagger");
    }

    public PoisonousDagger(PoisonousDagger poisonousDagger) {
        super(poisonousDagger);
    }

    /*
     * cell : no different
     * player : the player that its enemy is attacking
     * activeTime : 3 or 6 --> on Attack
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, int activeTime) {
        if (activeTime == 3 || activeTime == 6) {
            Cell enemyCell = getRandomEnemyForce(battle, player);
            if (enemyCell.getHero() != null) {
                PoisonBuff poisonBuff = new PoisonBuff();
                poisonBuff.setCasting(poisonBuff, null, enemyCell.getHero(), null);
                poisonBuff.poison(enemyCell.getHero());
                poisonBuff.setTurnCounter(0);
                enemyCell.getHero().getOwnBuffs().add(poisonBuff);
            }
            if (enemyCell.getMinion() != null) {
                PoisonBuff poisonBuff = new PoisonBuff();
                poisonBuff.setCasting(poisonBuff, null, null, enemyCell.getMinion());
                poisonBuff.poison(enemyCell.getMinion());
                poisonBuff.setTurnCounter(0);
                enemyCell.getMinion().getOwnBuffs().add(poisonBuff);
            }
        }
    }

    public UsableItem duplicate() {
        PoisonousDagger poisonousDagger = new PoisonousDagger(this);
        return poisonousDagger;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.POISONOUS_DAGGER.getMessage();
        return details;
    }
}
