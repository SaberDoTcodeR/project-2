package Duelyst.model.Card.Minion;

import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Buff.ChangeApBuff;
import Duelyst.model.Cell;
public class LupinLion extends Minion {
    public LupinLion() {
        super("LupinLion", 8, 1, 600, 2, 0, 0);
        super.setTimeOfActivationOfSpecialPower(0);

    }

    public LupinLion(LupinLion lupinLion) {
        super(lupinLion);
    }

    public Minion duplicate() {
        LupinLion lupinLion = new LupinLion(this);
        return lupinLion;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power: " + SpecialPower.LUPIN_LION.getMessage();
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request, int activeTime) {
        if (activeTime == 3) {
            if (cell.getHero() != null) {
                ChangeApBuff changeApBuff = new ChangeApBuff(cell.getHero().getHolyCounter());
                changeApBuff.setTurnCounter(0);
                changeApBuff.increment(this);
                changeApBuff.setCasting(changeApBuff, null, null, this);
                this.getOwnBuffs().add(changeApBuff);
            } else if (cell.getMinion() != null) {
                ChangeApBuff changeApBuff = new ChangeApBuff(cell.getMinion().getHolyCounter());
                changeApBuff.setTurnCounter(0);
                changeApBuff.increment(this);
                changeApBuff.setCasting(changeApBuff, null, null, this);
                this.getOwnBuffs().add(changeApBuff);
            }
        }
    }

    public String getDesc() {
        return SpecialPower.LUPIN_LION.getMessage();
    }
}
