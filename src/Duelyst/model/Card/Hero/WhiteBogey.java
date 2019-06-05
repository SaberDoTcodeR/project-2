package Duelyst.model.Card.Hero;

import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Buff.ChangeApBuff;
import Duelyst.model.Card.Minion.SpecialPower;
import Duelyst.model.Cell;

public class WhiteBogey extends Hero {
    public WhiteBogey() {
        super("WhiteBogey", 4, 50, 8000, 0);
        super.setCoolDownTime(2);
        super.setMp(1);
    }

    public WhiteBogey(WhiteBogey whiteBogey) {
        super(whiteBogey);
    }

    public Hero duplicate() {
        WhiteBogey whiteBogey = new WhiteBogey(this);
        return whiteBogey;
    }

    @Override
    public String showDetails() {
        String details = "Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - Class : " + this.getTypeOfHit() + " – Special power : " + SpecialPower.WHITE_BOGEY.getMessage();
        return details;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player, Request request) {
        if (player.getMana() >= this.getMp()) {
            ChangeApBuff changeApBuff = new ChangeApBuff(4);
            changeApBuff.increment(this);
            changeApBuff.setTurnCounter(-5);
            changeApBuff.setCasting(changeApBuff, null, this, null);
            this.getOwnBuffs().add(changeApBuff);
            player.setMana(player.getMana() - this.getMp());
        } else request.setError(ErrorType.DONT_HAVE_ENOUGH_MANA);

    }

    @Override
    public String getDesc() {
        return SpecialPower.WHITE_BOGEY.getMessage();
    }
}
