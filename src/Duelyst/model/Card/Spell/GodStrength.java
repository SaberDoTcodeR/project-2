package Duelyst.model.Card.Spell;

import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Cell;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class GodStrength extends Spell {

    public GodStrength() {
        super("GodStrength", 2, 450);
        super.cardImage = new Image("Duelyst/css/unit_gifs/f4_tier2general_breathing.gif");
    }

    public GodStrength(GodStrength godStrength) {
        super(godStrength);
    }

    @Override
    public void castSpell(Battle battle, Cell cell, Account player) {
        /*if (cell.getHero() == null && cell.getMinion() == null) {
            //request.setError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getHero() != null) {
                if (player.getMainDeck().isContain(cell.getHero())) {
                    cell.getHero().incrementAp(4);
                } else {
                    // request.setError(ErrorType.INVALID_TARGET);
                }
            }
            if (cell.getMinion() != null) {
                // request.setError(ErrorType.INVALID_TARGET);
            }
        }*/
    }

    public Spell duplicate() {
        GodStrength godStrength = new GodStrength(this);
        godStrength.cardImage = new Image("Duelyst/css/unit_gifs/f4_tier2general_breathing.gif");
        return godStrength;
    }


    @Override
    public String getDesc() {
        return SpellWork.GOD_STRENGTH.getMessage();
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.GOD_STRENGTH.getMessage();
        return details;
    }
}
