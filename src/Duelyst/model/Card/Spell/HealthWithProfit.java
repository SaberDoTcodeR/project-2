package Duelyst.model.Card.Spell;

import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Buff.HolyBuff;
import Duelyst.model.Buff.WeaknessBuff;
import Duelyst.model.Cell;

import java.util.ArrayList;
public class HealthWithProfit extends Spell {

    public HealthWithProfit() {
        super("HealthWithProfit", 0, 2250);
    }

    public HealthWithProfit(HealthWithProfit healthWithProfit) {
        super(healthWithProfit);
    }

    @Override
    public void castSpell(Battle battle, Cell cell, Account player) {
        if (cell.getHero() == null && cell.getMinion() == null) {
            //request.setError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getHero() != null) {
                if (player.getMainDeck().isContain(cell.getHero())) {
                    WeaknessBuff weaknessBuff = new WeaknessBuff(6 - cell.getHero().getHolyCounter(), false);
                    weaknessBuff.decrementHp(cell.getHero());
                    weaknessBuff.setTurnCounter(2);
                    weaknessBuff.setCasting(weaknessBuff, null, cell.getHero(), null);
                    cell.getHero().getOwnBuffs().add(weaknessBuff);
                    for (int i = 0; i < 2; i++) {
                        HolyBuff holyBuff = new HolyBuff();
                        holyBuff.holy(cell.getHero());
                        holyBuff.setTurnCounter(2);
                        holyBuff.setCasting(holyBuff, null, cell.getHero(), null);
                        cell.getHero().getOwnBuffs().add(holyBuff);
                    }
                }
            } else {
                //request.setError(ErrorType.INVALID_TARGET);
            }
        }
        if (cell.getMinion() != null) {
            if (player.getMainDeck().isContain(cell.getMinion())) {
                WeaknessBuff weaknessBuff = new WeaknessBuff(6 - cell.getMinion().getHolyCounter(), false);
                weaknessBuff.decrementHp(cell.getMinion());
                weaknessBuff.setTurnCounter(2);
                weaknessBuff.setCasting(weaknessBuff, null, null, cell.getMinion());
                cell.getMinion().getOwnBuffs().add(weaknessBuff);

                for (int i = 0; i < 2; i++) {
                    HolyBuff holyBuff = new HolyBuff();
                    holyBuff.holy(cell.getMinion());
                    holyBuff.setTurnCounter(2);
                    holyBuff.setCasting(holyBuff, null, null, cell.getMinion());
                    cell.getMinion().getOwnBuffs().add(holyBuff);
                }
            } else {
                //request.setError(ErrorType.INVALID_TARGET);
            }
        }
    }

    public Spell duplicate() {
        HealthWithProfit healthWithProfit = new HealthWithProfit(this);
        return healthWithProfit;
    }

    @Override
    public String getDesc() {
        return SpellWork.HEALTH_WITH_PROFIT.getMessage();
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.HEALTH_WITH_PROFIT.getMessage();
        return details;
    }
}