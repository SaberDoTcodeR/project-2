package DuelystServer.model.Item.UsableItem;

import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Cell;

public class ShameEmblem extends UsableItem {

    public ShameEmblem() {
        super(4000, "ShameEmblem");
    }

    public ShameEmblem(ShameEmblem shameEmblem) {
        super(shameEmblem);
    }

    /*
     * cell --> The cell of insider hero
     * player --> no different at all but the player who has this item
     * activeTime --> no different
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, int activeTime) {
       /* if (activeTime != -1)
            return;
        for (int i = 0; i < 12; i++) {
            HolyBuff holyBuff = new HolyBuff();
            holyBuff.setCasting(holyBuff, null, cell.getHero(), null);
            holyBuff.setTurnCounter(-5);
            holyBuff.castBuff();
            cell.getHero().getOwnBuffs().add(holyBuff);
        }*/
    }

    @Override
    public UsableItem duplicate() {
        ShameEmblem shameEmblem = new ShameEmblem(this);
        return shameEmblem;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.SHAME_EMBLEM.getMessage();
        return details;
    }
}
