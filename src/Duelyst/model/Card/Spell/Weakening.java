package Duelyst.model.Card.Spell;

import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Buff.WeaknessBuff;
import Duelyst.model.Cell;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Weakening extends Spell {

    public Weakening() {
        super("Weakening", 1, 1000);
        super.cardImage = new Image("Duelyst/css/unit_gifs/neutral_saberspinemk2_breathing.gif");
    }

    public Weakening(Weakening weakening) {
        super(weakening);
    }

    @Override
    public void castSpell(Battle battle, Cell cell, Account player) {
        if (cell.getHero() == null && cell.getMinion() == null) {
            // request.setError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getMinion() != null) {
                if (!player.getMainDeck().isContain(cell.getMinion())) {
                    WeaknessBuff weaknessBuff = new WeaknessBuff(4, true);
                    weaknessBuff.decrementAp(cell.getMinion());
                    weaknessBuff.setCasting(weaknessBuff, null, null, cell.getMinion());
                    weaknessBuff.setTurnCounter(0);
                    cell.getMinion().getOwnBuffs().add(weaknessBuff);
                } else {
                    // request.setError(ErrorType.INVALID_TARGET);
                }
            }
            if (cell.getHero() != null) {
                //  request.setError(ErrorType.INVALID_TARGET);
            }
        }
    }

    public Spell duplicate() {
        Weakening weakening = new Weakening(this);
        weakening.cardImage = new Image("Duelyst/css/unit_gifs/neutral_saberspinemk2_breathing.gif");
        return weakening;
    }

    @Override
    public String getDesc() {
        return SpellWork.WEAKENING.getMessage();
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.WEAKENING.getMessage();
        return details;
    }
}
