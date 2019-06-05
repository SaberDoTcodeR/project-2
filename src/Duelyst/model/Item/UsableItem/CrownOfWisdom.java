package Duelyst.model.Item.UsableItem;

import Duelyst.model.Battle.Battle;
import Duelyst.model.Buff.ManaItemBuff;
import Duelyst.model.Cell;
import Duelyst.model.Account;

public class CrownOfWisdom extends UsableItem {

    public CrownOfWisdom() {
        super(300, "CrownOfWisdom");
    }

    public CrownOfWisdom(CrownOfWisdom crownOfWisdom) {
        super(crownOfWisdom);
    }

    /*
     * cell --> no different
     * player --> The player who has this item
     * activeTime : no different
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, int activeTime) {
        if (activeTime != -1)
            return;
        ManaItemBuff manaItemBuff = new ManaItemBuff(player, 1);
        manaItemBuff.setTurnCounter(2);
        manaItemBuff.castBuff();
        player.getOwnBuffs().add(manaItemBuff);
    }

    @Override
    public UsableItem duplicate() {
        CrownOfWisdom crownOfWisdom = new CrownOfWisdom(this);
        return crownOfWisdom;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.CROWN_OF_WISDOM.getMessage();
        return details;
    }
}
