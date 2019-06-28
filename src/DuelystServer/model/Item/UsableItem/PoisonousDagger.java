package DuelystServer.model.Item.UsableItem;

import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Cell;

public class PoisonousDagger extends UsableItem {

    public PoisonousDagger() {
        super(7000, "PoisonousDagger");
    }

    public PoisonousDagger(PoisonousDagger poisonousDagger) {
        super(poisonousDagger);
    }

    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, int activeTime) {
     /*   if (activeTime == 3 || activeTime == 6) {
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
        }*/
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