package DuelystServer.model.Card.Spell;

import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Cell;
import DuelystServer.model.ErrorType;
import javafx.scene.image.Image;

public class Dispel extends Spell {

    public Dispel() {
        super("Dispel", 0, 2100);
        super.cardImage = new Image("Duelyst/css/unit_gifs/f3_zirixfestive_breathing.gif");
    }

    public Dispel(Dispel dispel) {
        super(dispel);
    }

    @Override
    public ErrorType castSpell(Battle battle, Cell cell, Account player) {
       /* if (cell.getHero() == null && cell.getMinion() == null) {
            //request.setError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getHero() != null) {
                if (!player.getMainDeck().isContain(cell.getHero())) {
                    for (Buff buff : cell.getHero().getOwnBuffs()) {
                        if (dispelEnemyValidation(buff.getClass().getSimpleName())) {
                            buff.dispel(cell.getHero());
                            //todo --> check Working
                        }
                    }
                } else {
                    for (Buff buff : cell.getHero().getOwnBuffs()) {
                        if (dispelInsiderValidation(buff.getClass().getSimpleName())) {
                            buff.dispel(cell.getHero());
                            //todo --> check Working
                        }
                    }
                }
            }
            if (cell.getMinion() != null) {
                if (!player.getMainDeck().isContain(cell.getMinion())) {
                    for (Buff buff : cell.getMinion().getOwnBuffs()) {
                        if (dispelEnemyValidation(buff.getClass().getSimpleName())) {
                            buff.dispel(cell.getMinion());
                            //todo --> check Working
                        }
                    }
                } else {
                    for (Buff buff : cell.getMinion().getOwnBuffs()) {
                        if (dispelInsiderValidation(buff.getClass().getSimpleName())) {
                            buff.dispel(cell.getMinion());
                            //todo --> check Working
                        }
                    }
                }
            }
        }*/
       return null;
    }

    public Spell duplicate() {
        Dispel dispel = new Dispel(this);
        dispel.cardImage = new Image("Duelyst/css/unit_gifs/f3_zirixfestive_breathing.gif");
        return dispel;
    }

    @Override
    public String getDesc() {
        return SpellWork.DISPEL.getMessage();
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.DISPEL.getMessage();
        return details;
    }
}
