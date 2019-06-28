package DuelystClient.model.Card.Hero;

import DuelystClient.model.Account;
import DuelystClient.model.Battle.Battle;
import DuelystClient.model.Card.Minion.SpecialPower;
import DuelystClient.model.Cell;
import javafx.scene.image.Image;

public class Dragon extends Hero {
    public Dragon() {
        super("Dragon", 4, 50, 8000, 0);
        this.cardImage = new Image("DuelystClient/css/unit_gifs/boss_wolfpunch_breathing.gif");
        super.setCoolDownTime(1);
        super.cardImage = new Image("DuelystClient/css/unit_gifs/boss_wolfpunch_breathing.gif");
        super.setMp(0);
    }

    public Dragon(Dragon dragon) {
        super(dragon);
    }

    public Hero duplicate() {
        Dragon dragon = new Dragon(this);
        dragon.cardImage = new Image("DuelystClient/css/unit_gifs/boss_wolfpunch_breathing.gif");
        return dragon;
    }

    @Override
    public String showDetails() {
        String details = "Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - Class : " + this.getTypeOfHit() + " – Special power : " + SpecialPower.DRAGON.getMessage();
        return details;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player) {

        /*if (player.getMana() >= this.getMp()) {
            if (cell.getHero() != null) {
                if (!player.getMainDeck().isContain(cell.getHero())) {
                    DisarmBuff disarmBuff = new DisarmBuff();
                    disarmBuff.setTurnCounter(1);
                    disarmBuff.disarm(cell.getHero());
                    disarmBuff.setCasting(disarmBuff, null, cell.getHero(), null);
                    cell.getHero().getOwnBuffs().add(disarmBuff);
                } else {
                    // request.setError(ErrorType.SELF_HARM);
                }
            } else if (cell.getMinion() != null) {
                if (!player.getMainDeck().isContain(cell.getMinion())) {
                    DisarmBuff disarmBuff = new DisarmBuff();
                    disarmBuff.setTurnCounter(1);
                    disarmBuff.disarm(cell.getMinion());
                    disarmBuff.setCasting(disarmBuff, null, null, cell.getMinion());
                    cell.getMinion().getOwnBuffs().add(disarmBuff);
                } else{}// request.setError(ErrorType.SELF_HARM);
            } else {}// request.setError(ErrorType.EMPTY_CELL);
        } else {}// request.setError(ErrorType.DONT_HAVE_ENOUGH_MANA);*/

    }

    public String getDesc() {
        return SpecialPower.DRAGON.getMessage();
    }
}
