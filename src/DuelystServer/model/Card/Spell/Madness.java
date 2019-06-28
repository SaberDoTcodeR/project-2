package DuelystServer.model.Card.Spell;

import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Cell;
import DuelystServer.model.ErrorType;
import javafx.scene.image.Image;

public class Madness extends Spell {

    public Madness() {
        super("Madness", 0, 650);
    }

    public Madness(Madness madness) {
        super(madness);
    }

    @Override
    public ErrorType castSpell(Battle battle, Cell cell, Account player) {
      /*  if (cell.getHero() == null && cell.getMinion() == null) {
            //request.setError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getHero() != null) {
                if (player.getMainDeck().isContain(cell.getHero())) {
                    DisarmBuff disarmBuff = new DisarmBuff();
                    disarmBuff.setTurnCounter(2);
                    disarmBuff.disarm(cell.getHero());
                    disarmBuff.setCasting(disarmBuff, null, cell.getHero(), null);
                    ChangeApBuff changeAp = new ChangeApBuff(4);
                    changeAp.setTurnCounter(2);
                    changeAp.increment(cell.getHero());
                    changeAp.setCasting(changeAp, null, cell.getHero(), null);
                    cell.getHero().getOwnBuffs().add(disarmBuff);
                    cell.getHero().getOwnBuffs().add(changeAp);
                }
            } else {
                // request.setError(ErrorType.INVALID_TARGET);
            }
        }
        if (cell.getMinion() != null) {
            if (player.getMainDeck().isContain(cell.getMinion())) {
                DisarmBuff disarmBuff = new DisarmBuff();
                disarmBuff.setTurnCounter(2);
                disarmBuff.disarm(cell.getMinion());
                disarmBuff.setCasting(disarmBuff, null, null, cell.getMinion());
                ChangeApBuff changeAp = new ChangeApBuff(4);
                changeAp.setTurnCounter(2);
                changeAp.increment(cell.getMinion());
                changeAp.setCasting(changeAp, null, null, cell.getMinion());
                cell.getMinion().getOwnBuffs().add(disarmBuff);
                cell.getMinion().getOwnBuffs().add(changeAp);
            } else {
                //request.setError(ErrorType.INVALID_TARGET);
            }
        }*/
        return null;
    }

    public Spell duplicate() {
        Madness madness = new Madness(this);
        return madness;
    }


    @Override
    public String getDesc() {
        return SpellWork.MADNESS.getMessage();
    }


    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.MADNESS.getMessage();
        return details;
    }
}
