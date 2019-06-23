package Duelyst.model.Card.Spell;

import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Cell;
import Duelyst.model.ErrorType;
import javafx.scene.image.Image;

public class Shock extends Spell {

    public Shock() {
        super("Shock", 1, 1200);
        super.cardImage = new Image("Duelyst/css/unit_gifs/neutral_saberspinemk2_breathing.gif");
    }

    public Shock(Shock shock) {
        super(shock);
    }

    @Override
    public ErrorType castSpell(Battle battle, Cell cell, Account player) {
       /* if (cell.getMinion() == null && cell.getHero() == null) {
            //request.setError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getHero() != null) {
                if (!player.getMainDeck().isContain(cell.getHero())) {
                    StunBuff stunBuff = new StunBuff();
                    stunBuff.stun(cell.getHero());
                    stunBuff.setTurnCounter(1);
                    stunBuff.setCasting(stunBuff, null, cell.getHero(), null);
                    cell.getHero().getOwnBuffs().add(stunBuff);
                } else {
                    //   view.printError(ErrorType.INVALID_TARGET);
                }
            }
            if (cell.getMinion() != null) {
                if (!player.getMainDeck().isContain(cell.getMinion())) {
                    StunBuff stunBuff = new StunBuff();
                    stunBuff.stun(cell.getMinion());
                    stunBuff.setTurnCounter(1);
                    stunBuff.setCasting(stunBuff, null, null, cell.getMinion());
                    cell.getMinion().getOwnBuffs().add(stunBuff);
                } else {
                    //  view.printError(ErrorType.INVALID_TARGET);
                }
            }
        }*/
        return null;
    }

    public Spell duplicate() {
        Shock shock = new Shock(this);
        shock.cardImage = new Image("Duelyst/css/unit_gifs/neutral_saberspinemk2_breathing.gif");
        return shock;
    }

    @Override
    public String getDesc() {
        return SpellWork.SHOCK.getMessage();
    }


    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.SHOCK.getMessage();
        return details;
    }
}
