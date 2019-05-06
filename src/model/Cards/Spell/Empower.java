package model.Cards.Spell;

import model.Battles.Battle;
import model.Cell;
import model.ErrorType;
import model.Menus.Account;
import view.Request;

public class Empower extends Spell {

    public Empower() {
        super("Empower", 1, 250);
    }

    public Empower(Empower empower) {
        super(empower);
    }

    @Override
    public void castSpell(Battle battle, Cell cell, Account player, Request request) {
        if (cell.getHero() == null && cell.getMinion() == null) {
            request.setError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getHero() != null) {
                if (player.getMainDeck().isContain(cell.getHero())) {
                    cell.getHero().incrementAp(2);
                } else {
                    request.setError(ErrorType.INVALID_TARGET);
                }
            }
            if (cell.getMinion() != null) {
                if (player.getMainDeck().isContain(cell.getMinion())) {
                    cell.getMinion().incrementAp(2);
                } else {
                    request.setError(ErrorType.INVALID_TARGET);
                }
            }
        }
    }

    public Spell duplicate() {
        Empower empower = new Empower(this);
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
