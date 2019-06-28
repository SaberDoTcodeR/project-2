package DuelystClient.model.Card.Hero;

import DuelystClient.model.Account;
import DuelystClient.model.Battle.Battle;
import DuelystClient.model.Card.Minion.SpecialPower;
import DuelystClient.model.Cell;
import javafx.scene.image.Image;

public class Legend extends Hero {
    public Legend() {
        super("Legend", 3, 40, 11000, 1);
        super.setCoolDownTime(2);
        super.setMp(1);
        super.setRange(3);
        super.cardImage = new Image("DuelystClient/css/unit_gifs/f1_altgeneraltier2_breathing.gif");
    }

    public Legend(Legend legend) {
        super(legend);
    }

    public Hero duplicate() {
        Legend legend = new Legend(this);
        legend.cardImage = new Image("DuelystClient/css/unit_gifs/f1_altgeneraltier2_breathing.gif");
        return legend;
    }

    @Override
    public String showDetails() {
        String details = "Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - Class : " + this.getTypeOfHit() + " – Special power : " + SpecialPower.LEGEND.getMessage();
        return details;
    }

    public void castSpecialPower(Battle battle, Cell cell, Account player) {

     /*   if (player.getMana() >= this.getMp()) {
            if (cell.getHero() != null) {
                if (!player.getMainDeck().isContain(cell.getHero())) {
                    for (Buff buff : cell.getHero().getOwnBuffs()) {
                        if (dispelEnemyValidation(buff.getClass().getSimpleName())) {
                            buff.dispel(cell.getHero());
                        }
                    }
                } else{}// request.setError(ErrorType.INVALID_TARGET);
            } else if (cell.getMinion() != null) {
                if (!player.getMainDeck().isContain(cell.getMinion())) {
                    for (Buff buff : cell.getMinion().getOwnBuffs()) {
                        if (dispelEnemyValidation(buff.getClass().getSimpleName())) {
                            buff.dispel(cell.getMinion());
                        }
                    }
                } else{}// request.setError(ErrorType.INVALID_TARGET);
            } else {}//request.setError(ErrorType.EMPTY_CELL);
        } else {}//request.setError(ErrorType.DONT_HAVE_ENOUGH_MANA);
*/
    }

    public String getDesc() {
        return SpecialPower.LEGEND.getMessage();
    }
}
