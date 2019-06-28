package DuelystServer.model.Item.UsableItem;

import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Cell;

public class TerrorHood extends UsableItem {

    public TerrorHood() {
        super(5000, "TerrorHood");
    }

    public TerrorHood(TerrorHood terrorHood) {
        super(terrorHood);
    }

    /*
     * cell : no different
     * player : th player who its force want to attack on enemy
     * activeTime : 3 or 6 --> on Attack
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, int activeTime) {

       /* if (activeTime == 3 || activeTime == 6) {
            Cell enemyCell = getRandomEnemyForce(battle, player);
            if (enemyCell.getHero() != null) {
                WeaknessBuff weaknessBuff = new WeaknessBuff(2, true);
                weaknessBuff.setCasting(weaknessBuff, null, enemyCell.getHero(), null);
                weaknessBuff.decrementAp(enemyCell.getHero());
                weaknessBuff.setTurnCounter(0);
                enemyCell.getHero().getOwnBuffs().add(weaknessBuff);
            }
            if (enemyCell.getMinion() != null) {
                WeaknessBuff weaknessBuff = new WeaknessBuff(2, true);
                weaknessBuff.setCasting(weaknessBuff, null, null, enemyCell.getMinion());
                weaknessBuff.decrementAp(enemyCell.getMinion());
                weaknessBuff.setTurnCounter(0);
                enemyCell.getMinion().getOwnBuffs().add(weaknessBuff);
            }
        }
*/
    }

    public UsableItem duplicate() {
        TerrorHood terrorHood = new TerrorHood(this);
        return terrorHood;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.TERROR_HOOD.getMessage();
        return details;
    }
}
