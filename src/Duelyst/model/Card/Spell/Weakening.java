package Duelyst.model.Card.Spell;


import Duelyst.model.Account;

public class Weakening extends Spell {

    public Weakening() {
        super("Weakening", 1, 1000);
    }

    public Weakening(Weakening weakening) {
        super(weakening);
    }

    @Override
    public void castSpell(Battle battle, Cell cell, Account player, Request request) {
        if (cell.getHero() == null && cell.getMinion() == null) {
            request.setError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getMinion() != null) {
                if (!player.getMainDeck().isContain(cell.getMinion())) {
                    WeaknessBuff weaknessBuff = new WeaknessBuff(4, true);
                    weaknessBuff.decrementAp(cell.getMinion());
                    weaknessBuff.setCasting(weaknessBuff, null, null, cell.getMinion());
                    weaknessBuff.setTurnCounter(0);
                    cell.getMinion().getOwnBuffs().add(weaknessBuff);
                } else {
                    request.setError(ErrorType.INVALID_TARGET);
                }
            }
            if (cell.getHero() != null) {
                request.setError(ErrorType.INVALID_TARGET);
            }
        }
    }

    public Spell duplicate() {
        Weakening weakening = new Weakening(this);
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
