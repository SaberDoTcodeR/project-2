package Duelyst.model.Card.Spell;

import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Cell;
import Duelyst.model.ErrorType;
import javafx.scene.image.Image;

public class Weakening extends Spell {

    public Weakening() {
        super("Weakening", 1, 1000);
        super.cardImage = new Image("Duelyst/css/unit_gifs/neutral_saberspinemk2_breathing.gif");
    }

    public Weakening(Weakening weakening) {
        super(weakening);
    }

    @Override
    public ErrorType castSpell(Battle battle, Cell cell, Account player) {
      /*  if (cell.getHero() == null && cell.getMinion() == null) {
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
        }*/
        return null;
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
