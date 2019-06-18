package Duelyst.model.Card.Spell;


import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Buff.DisarmBuff;
import Duelyst.model.Cell;
import javafx.scene.image.Image;

import java.util.ArrayList;
public class TotalDisarm extends Spell {

    public TotalDisarm() {
        super("TotalDisarm", 0, 1000);
    }

    @Override
    public void castSpell(Battle battle, Cell cell, Account player) {
        if (cell.getMinion() == null && cell.getHero() == null) {
            //request.setError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getHero() != null) {
                if (!player.getMainDeck().isContain(cell.getHero())) {
                    DisarmBuff disarmBuff = new DisarmBuff();
                    disarmBuff.setTurnCounter(-5);//-5 means until end of game
                    disarmBuff.disarm(cell.getHero());
                    disarmBuff.setCasting(disarmBuff, null, cell.getHero(), null);
                    cell.getHero().getOwnBuffs().add(disarmBuff);
                } else {
                    //request.setError(ErrorType.INVALID_TARGET);
                }
            }
            if (cell.getMinion() != null) {
                if (!player.getMainDeck().isContain(cell.getMinion())) {
                    DisarmBuff disarmBuff = new DisarmBuff();
                    disarmBuff.setTurnCounter(-5);
                    disarmBuff.disarm(cell.getMinion());
                    disarmBuff.setCasting(disarmBuff, null, null, cell.getMinion());
                    cell.getMinion().getOwnBuffs().add(disarmBuff);
                } else {
                    //request.setError(ErrorType.INVALID_TARGET);
                }
            }
        }
    }

    public TotalDisarm(TotalDisarm totalDisarm) {
        super(totalDisarm);
    }

    public Spell duplicate() {
        TotalDisarm totalDisarm = new TotalDisarm(this);

        totalDisarm.cardImage=new Image("Duelyst/css/unit_gifs/neutral_zyxfestive_breathing.gif");
        return totalDisarm;
    }


    @Override
    public String getDesc() {
        return SpellWork.TOTAL_DISARM.getMessage();
    }


    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.TOTAL_DISARM.getMessage();
        return details;
    }
}
