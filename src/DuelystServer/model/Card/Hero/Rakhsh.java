package DuelystServer.model.Card.Hero;

import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Card.Minion.SpecialPower;
import DuelystServer.model.Cell;
import javafx.scene.image.Image;

public class Rakhsh extends Hero {
    public Rakhsh() {
        super("Rakhsh", 4, 50, 8000, 0);
        super.setCoolDownTime(2);
        super.setMp(1);
    }

    public Rakhsh(Rakhsh rakhsh) {
        super(rakhsh);
    }

    public Hero duplicate() {
        Rakhsh rakhsh = new Rakhsh(this);
        return rakhsh;
    }

    @Override
    public String showDetails() {
        String details = "Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - Class : " + this.getTypeOfHit() + " – Special power : " + SpecialPower.RAKHSH.getMessage();
        return details;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player) {


     /*  if (player.getMana() >= this.getMp()) {      if (cell.getHero() != null) {
                if (!player.getMainDeck().isContain(cell.getHero())) {
                    StunBuff stunBuff = new StunBuff();
                    stunBuff.setTurnCounter(1);
                    stunBuff.stun(cell.getHero());
                    stunBuff.setCasting(stunBuff, null, cell.getHero(), null);
                    cell.getHero().getOwnBuffs().add(stunBuff);
                } else {}//request.setError(ErrorType.SELF_HARM);
            } else if (cell.getMinion() != null) {
                if (!player.getMainDeck().isContain(cell.getMinion())) {
                    StunBuff stunBuff = new StunBuff();
                    stunBuff.setTurnCounter(1);
                    stunBuff.stun(cell.getMinion());
                    stunBuff.setCasting(stunBuff, null, null, cell.getMinion());
                    cell.getMinion().getOwnBuffs().add(stunBuff);
                } else{}// request.setError(ErrorType.SELF_HARM);
            } else{}// request.setError(ErrorType.EMPTY_CELL);
        } else{}// request.setError(ErrorType.DONT_HAVE_ENOUGH_MANA);*/

    }

    public String getDesc() {
        return SpecialPower.RAKHSH.getMessage();
    }
}
