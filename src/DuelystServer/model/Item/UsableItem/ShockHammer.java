package DuelystServer.model.Item.UsableItem;

import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Cell;

public class ShockHammer extends UsableItem {

    public ShockHammer() {
        super(15000, "ShockHammer");
    }

    public ShockHammer(ShockHammer shockHammer) {
        super(shockHammer);
    }

    /*
     * cell : cell of hero or minion is
     * player : no different
     * activeTime : 6 --> on Attack
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, int activeTime) {
        /*if (activeTime == 6) {
            if (cell.getHero() != null) {
                DisarmBuff disarmBuff = new DisarmBuff();
                disarmBuff.setTurnCounter(0);
                disarmBuff.disarm(cell.getHero());
                disarmBuff.setCasting(disarmBuff, null, cell.getHero(), null);
                cell.getHero().getOwnBuffs().add(disarmBuff);
            }
            if (cell.getMinion() != null) {
                DisarmBuff disarmBuff = new DisarmBuff();
                disarmBuff.setTurnCounter(0);
                disarmBuff.disarm(cell.getMinion());
                disarmBuff.setCasting(disarmBuff, null, null, cell.getMinion());
                cell.getMinion().getOwnBuffs().add(disarmBuff);
            }
        }*/
    }

    public UsableItem duplicate() {
        ShockHammer shockHammer = new ShockHammer(this);
        return shockHammer;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.SHOCK_HAMMER.getMessage();
        return details;
    }
}
