package DuelystClient.model.Item.UsableItem;

import DuelystClient.model.Battle.Battle;
import DuelystClient.model.Cell;
import DuelystClient.model.Account;

public class SoulEater extends UsableItem {
    public SoulEater() {
        super(25000, "SoulEater");
    }

    public SoulEater(SoulEater soulEater) {
        super(soulEater);
    }

    /*
     * cell : no different
     * player : the player that its force is dying
     * activeTime : 2 --> on Death
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, int activeTime) {
       /* if (activeTime == 2) {
            Cell insiderCell = getRandomInsiderForce(battle, player);
            if (insiderCell.getHero() != null) {
                PowerBuff powerBuff = new PowerBuff(1, true);
                powerBuff.setTurnCounter(-5);//todo --> right or not
                powerBuff.setCasting(powerBuff, null, insiderCell.getHero(), null);
                powerBuff.incrementAp(insiderCell.getHero());
                insiderCell.getHero().getOwnBuffs().add(powerBuff);
            }
            if (insiderCell.getMinion() != null) {
                PowerBuff powerBuff = new PowerBuff(1, true);
                powerBuff.setTurnCounter(-5);//todo --> right or not
                powerBuff.setCasting(powerBuff, null, null, insiderCell.getMinion());
                powerBuff.incrementAp(insiderCell.getMinion());
                insiderCell.getMinion().getOwnBuffs().add(powerBuff);
            }
        }*/
    }

    public UsableItem duplicate() {
        SoulEater soulEater = new SoulEater(this);
        return soulEater;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.SOUL_EATER.getMessage();
        return details;
    }
}
