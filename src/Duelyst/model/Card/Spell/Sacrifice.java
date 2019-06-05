package Duelyst.model.Card.Spell;
import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Buff.PowerBuff;
import Duelyst.model.Buff.WeaknessBuff;
import Duelyst.model.Cell;

import java.util.ArrayList;
public class Sacrifice extends Spell {

    public Sacrifice() {
        super("Sacrifice", 2, 1600);
    }

    public Sacrifice(Sacrifice sacrifice) {
        super(sacrifice);
    }

    @Override
    public void castSpell(Battle battle, Cell cell, Account player, Request request) {
        if (cell.getHero() == null && cell.getMinion() == null) {
            request.setError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getMinion() != null) {
                if (player.getMainDeck().isContain(cell.getMinion())) {
                    PowerBuff powerBuff = new PowerBuff(8, true);
                    powerBuff.setTurnCounter(0);
                    powerBuff.incrementAp(cell.getMinion());
                    powerBuff.setCasting(powerBuff, null, null, cell.getMinion());
                    cell.getMinion().getOwnBuffs().add(powerBuff);

                    WeaknessBuff weaknessBuff = new WeaknessBuff(6 - cell.getMinion().getHolyCounter(), false);
                    weaknessBuff.decrementAp(cell.getMinion());
                    weaknessBuff.setTurnCounter(0);
                    weaknessBuff.setCasting(weaknessBuff, null, null, cell.getMinion());
                    cell.getMinion().getOwnBuffs().add(weaknessBuff);
                } else {
                    request.setError(ErrorType.INVALID_TARGET);
                }
            }
            if (cell.getHero() != null) {
                request.setError(ErrorType.INVALID_TARGET);
            }
        }
    }

    public Spell duplicate() {
        Sacrifice sacrifice = new Sacrifice(this);
        return sacrifice;
    }

    @Override
    public String getDesc() {
        return SpellWork.SACRIFICE.getMessage();
    }


    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.SACRIFICE.getMessage();
        return details;
    }
}
