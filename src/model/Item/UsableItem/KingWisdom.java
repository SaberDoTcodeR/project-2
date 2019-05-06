package model.Item.UsableItem;

import model.Battles.Battle;
import model.Buffs.ManaItemBuff;
import model.Cell;
import model.Menus.Account;

public class KingWisdom extends UsableItem {

    public KingWisdom() {
        super(9000, "KingWisdom");
    }

    public KingWisdom(KingWisdom kingWisdom) {
        super(kingWisdom);
    }

    /* --->>> should be applied on every turn
     * cell --> no different
     * player --> The player who has this item
     * activeTime : no different
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, int activeTime) {
        if (activeTime != -1)
            return;
        ManaItemBuff manaItemBuff = new ManaItemBuff(player, 1);
        manaItemBuff.setTurnCounter(-5);
        manaItemBuff.castBuff();
        player.getOwnBuffs().add(manaItemBuff);
    }

    public UsableItem duplicate() {
        KingWisdom kingWisdom = new KingWisdom(this);
        return kingWisdom;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.KING_WISDOM.getMessage();
        return details;
    }
}
