package Duelyst.model.Card.Spell;

import Duelyst.model.Account;
import Duelyst.model.Battle.Battle;
import Duelyst.model.Cell;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class FireBall extends Spell {

    public FireBall() {
        super("FireBall", 1, 400);
        super.cardImage = new Image("Duelyst/css/unit_gifs/f4_maehvmk2_breathing.gif");
    }

    public FireBall(FireBall fireBall) {
        super(fireBall);
    }

    @Override
    public void castSpell(Battle battle, Cell cell, Account player) {
     /*   if (cell.getHero() == null && cell.getMinion() == null) {
            //request.setError(ErrorType.INVALID_TARGET);
        } else {
            if (cell.getHero() != null) {
                if (!player.getMainDeck().isContain(cell.getHero())) {
                    cell.getHero().decrementHp(4 - cell.getHero().getHolyCounter());
                } else {
                    //request.setError(ErrorType.INVALID_TARGET);
                }
            } else if (cell.getMinion() != null) {
                if (!player.getMainDeck().isContain(cell.getMinion())) {
                    cell.getMinion().decrementHp(4 - cell.getMinion().getHolyCounter());
                } else {
                    //request.setError(ErrorType.INVALID_TARGET);
                }
            }
        }*/
    }

    public Spell duplicate() {
        FireBall fireBall = new FireBall(this);
        fireBall.cardImage = new Image("Duelyst/css/unit_gifs/f4_maehvmk2_breathing.gif");
        return fireBall;
    }


    @Override
    public String getDesc() {
        return SpellWork.FIREBALL.getMessage();
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.FIREBALL.getMessage();
        return details;
    }
}
