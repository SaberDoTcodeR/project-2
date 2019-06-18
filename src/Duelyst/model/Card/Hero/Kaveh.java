package Duelyst.model.Card.Hero;

import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Buff.HolyEffectedCell;
import Duelyst.model.Card.Minion.SpecialPower;
import Duelyst.model.Cell;
import javafx.scene.image.Image;

public class Kaveh extends Hero {
    public Kaveh() {
        super("Kaveh", 4, 50, 8000, 0);
        super.setCoolDownTime(3);
        super.setMp(1);
        super.cardImage = new Image("Duelyst/css/unit_gifs/boss_wujin_breathing.gif");
    }

    public Kaveh(Kaveh kaveh) {
        super(kaveh);
    }

    public Hero duplicate() {
        Kaveh kaveh = new Kaveh(this);
        kaveh.cardImage = new Image("Duelyst/css/unit_gifs/boss_wujin_breathing.gif");
        return kaveh;
    }

    @Override
    public String showDetails() {
        String details = "Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - Class : " + this.getTypeOfHit() + " – Special power : " + SpecialPower.KAVEH.getMessage();
        return details;
    }

    @Override
    public void castSpecialPower(Battle battle, Cell cell, Account player) {

        if (player.getMana() >= this.getMp()) {
            HolyEffectedCell holyEffectedCell = new HolyEffectedCell();
            holyEffectedCell.setTurnCounter(3);
            if (cell.getHero() != null) {
                holyEffectedCell.holy(cell.getHero());
            } else if (cell.getMinion() != null) {
                holyEffectedCell.holy(cell.getMinion());
            }
            holyEffectedCell.setCasting(holyEffectedCell, cell, null, null);
            cell.getCellEffect().add(holyEffectedCell);
        } else{}// request.setError(ErrorType.DONT_HAVE_ENOUGH_MANA);

    }

    public String getDesc() {
        return SpecialPower.KAVEH.getMessage();
    }
}
