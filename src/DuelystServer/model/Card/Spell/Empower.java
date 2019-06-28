package DuelystServer.model.Card.Spell;

import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Cell;
import DuelystServer.model.ErrorType;
import javafx.scene.image.Image;

public class Empower extends Spell {

    public Empower() {
        super("Empower", 1, 250);
        super.cardImage = new Image("Duelyst/css/unit_gifs/f4_altgeneraltier2_breathing.gif");
    }

    public Empower(Empower empower) {
        super(empower);
    }

    @Override
    public ErrorType castSpell(Battle battle, Cell cell, Account player) {
        if (cell.getHero() == null && cell.getMinion() == null) {
            return ErrorType.INVALID_TARGET;
        } else {
            if (cell.getHero() != null) {
                if (player.getMainDeck().isContain(cell.getHero())) {
                    cell.getHero().incrementAp(2);
                    return ErrorType.SUCCESSFUL_INSERT;
                } else {
                    return ErrorType.INVALID_TARGET;
                }
            }
            if (cell.getMinion() != null) {
                if (player.getMainDeck().isContain(cell.getMinion())) {
                    cell.getMinion().incrementAp(2);
                    return ErrorType.SUCCESSFUL_INSERT;
                } else {
                    return ErrorType.INVALID_TARGET;
                }
            }
        }
        return null;
    }

    public Spell duplicate() {
        Empower empower = new Empower(this);
        empower.cardImage = new Image("Duelyst/css/unit_gifs/f4_altgeneraltier2_breathing.gif");
        return empower;
    }

    public String getDesc() {
        return SpellWork.EMPOWER.getMessage();
    }


    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.EMPOWER.getMessage();
        return details;
    }
}
