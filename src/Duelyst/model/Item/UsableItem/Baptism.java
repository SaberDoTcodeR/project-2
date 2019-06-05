package Duelyst.model.Item.UsableItem;

import Duelyst.model.Battle.Battle;
import Duelyst.model.Buff.HolyBuff;
import Duelyst.model.Cell;
import Duelyst.model.Account;

public class Baptism extends UsableItem {

    public Baptism() {
        super(20000, "Baptism");
    }

    public Baptism(Baptism baptism) {
        super(baptism);
    }

    /* should be called for any minion that want to come to the game
     * cell : cell of insider minion that has been put
     * player : no different
     * activeTime : 0 --> on Spawn
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player, int activeTime) {
        if (activeTime == 0) {
            if (cell.getMinion() != null) {
                HolyBuff holyBuff = new HolyBuff();
                holyBuff.holy(cell.getMinion());
                holyBuff.setTurnCounter(1);
                holyBuff.setCasting(holyBuff, null, null, cell.getMinion());
                cell.getMinion().getOwnBuffs().add(holyBuff);
            }
        }
    }

    @Override
    public UsableItem duplicate() {
        Baptism baptism = new Baptism(this);
        return baptism;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + UsableItemWork.BAPTISM.getMessage();
        return details;
    }
}
