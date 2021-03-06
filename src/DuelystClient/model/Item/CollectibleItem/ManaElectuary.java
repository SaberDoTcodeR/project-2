package DuelystClient.model.Item.CollectibleItem;


import DuelystClient.model.Account;
import DuelystClient.model.Battle.Battle;
import DuelystClient.model.Cell;

public class ManaElectuary extends CollectibleItem {

    public ManaElectuary() {
        super("ManaElectuary");
    }

    public ManaElectuary(ManaElectuary manaElectuary) {
        super(manaElectuary);
    }

    /*
     * cell :
     * player :
     * activeTime :
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player) {
    /*    ManaItemBuff manaItemBuff = new ManaItemBuff(player, 3);
        manaItemBuff.setTurnCounter(1);
        player.getOwnBuffs().add(manaItemBuff);*/
    }

    public CollectibleItem duplicate() {
        ManaElectuary manaElectuary = new ManaElectuary(this);
        return manaElectuary;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectibleItemWork.MANA_ELECTUARY.getMessage();
        return details;
    }
}
