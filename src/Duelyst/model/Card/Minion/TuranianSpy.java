package Duelyst.model.Card.Minion;

import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Buff.DisarmBuff;
import Duelyst.model.Buff.PoisonBuff;
import Duelyst.model.Cell;
public class TuranianSpy extends Minion {
    public TuranianSpy() {
        super("TuranianSpy", 6, 6, 700, 4, 0, 0);
        super.setTimeOfActivationOfSpecialPower(0);
    }

    public TuranianSpy(TuranianSpy turanianSpy) {
        super(turanianSpy);
    }

    public Minion duplicate() {
        TuranianSpy turanianSpy = new TuranianSpy(this);
        return turanianSpy;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : " + SpecialPower.TURANIAN_SPY.getMessage();
        return detail;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime) {
        if (activeTime == 3) {
            if (cell.getHero() != null) {
                DisarmBuff disarmBuff = new DisarmBuff();
                disarmBuff.setTurnCounter(1 + 1 - 1);
                disarmBuff.disarm(cell.getHero());
                disarmBuff.setCasting(disarmBuff, null, cell.getHero(), null);
                cell.getHero().getOwnBuffs().add(disarmBuff);
                PoisonBuff poisonBuff = new PoisonBuff();
                poisonBuff.setTurnCounter(4);
                poisonBuff.poison(cell.getHero());
                poisonBuff.setCasting(poisonBuff, null, cell.getHero(), null);
                cell.getHero().getOwnBuffs().add(poisonBuff);
            } else if (cell.getMinion() != null) {
                DisarmBuff disarmBuff = new DisarmBuff();
                disarmBuff.setTurnCounter(1 + 1 - 1);
                disarmBuff.disarm(cell.getMinion());
                disarmBuff.setCasting(disarmBuff, null, null, cell.getMinion());
                cell.getMinion().getOwnBuffs().add(disarmBuff);
                PoisonBuff poisonBuff = new PoisonBuff();
                poisonBuff.setTurnCounter(4);
                poisonBuff.poison(cell.getMinion());
                poisonBuff.setCasting(poisonBuff, null, null, cell.getMinion());
                cell.getMinion().getOwnBuffs().add(poisonBuff);
            }
        }
    }

    public String getDesc() {
        return SpecialPower.TURANIAN_SPY.getMessage();
    }
}
