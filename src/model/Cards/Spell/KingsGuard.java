package model.Cards.Spell;

import model.Battles.Battle;
import model.Cell;
import model.Menus.Account;
import view.Request;

import java.util.ArrayList;

public class KingsGuard extends Spell {

    public KingsGuard() {
        super("KingsGuard", 9, 1750);
    }

    public KingsGuard(KingsGuard kingsGuard) {
        super(kingsGuard);
    }

    @Override
    public void castSpell(Battle battle, Cell cell, Account player, Request request) {
        Cell cellOfOwnHero = null;
        outer:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (battle.getMap().get(i).get(j).getHero() != null) {
                    if (player.getMainDeck().isContain(battle.getMap().get(i).get(j).getHero())) {
                        cellOfOwnHero = battle.getMap().get(i).get(j);
                        break outer;
                    }
                }
            }
        }
        ArrayList<Cell> cells = new ArrayList<>();
        cells.add(cellOfOwnHero.downCell(battle.getMap()));
        cells.add(cellOfOwnHero.upCell(battle.getMap()));
        cells.add(cellOfOwnHero.rightCell(battle.getMap()));
        cells.add(cellOfOwnHero.leftCell(battle.getMap()));
        cells.add(cells.get(0).leftCell(battle.getMap()));
        cells.add(cells.get(1).rightCell(battle.getMap()));
        cells.add(cells.get(2).downCell(battle.getMap()));
        cells.add(cells.get(3).upCell(battle.getMap()));
        for (Cell cell1 : cells) {
            if (cell1 != null) {
                if (cell1.getMinion() != null) {
                    if (!player.getMainDeck().isContain(cell1.getMinion())) {
                        cell1.getMinion().setHp(0);
                        break;
                    }
                }
            }
        }
    }

    public Spell duplicate() {
        KingsGuard kingsGuard = new KingsGuard(this);
        return kingsGuard;
    }


    @Override
    public String getDesc() {
        return SpellWork.KINGS_GUARD.getMessage();
    }


    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.KINGS_GUARD.getMessage();
        return details;
    }
}
