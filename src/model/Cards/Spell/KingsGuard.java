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
        Cell cellOfOwnHero = battle.getMap().get(0).get(0).getCellOfCard(player.getMainDeck().getHero(),battle);
        ArrayList<Cell> cells = new ArrayList<>();
        if (cellOfOwnHero.getX() < 4)
            cells.add(cellOfOwnHero.downCell(battle.getMap()));
        if (cellOfOwnHero.getX()  >= 1)
            cells.add(cellOfOwnHero.upCell(battle.getMap()));
        if (cellOfOwnHero.getY() >= 1)
            cells.add(cellOfOwnHero.leftCell(battle.getMap()));
        if (cellOfOwnHero.getY() < 8)
            cells.add(cellOfOwnHero.rightCell(battle.getMap()));
        if (cellOfOwnHero.getY() < 8 && cellOfOwnHero.getX() < 4)
            cells.add(battle.getMap().get(cellOfOwnHero.getX()+1).get(cellOfOwnHero.getY()+1));
        if (cellOfOwnHero.getY() < 8 && cellOfOwnHero.getX()  >= 1)
            cells.add(battle.getMap().get(cellOfOwnHero.getX()-1).get(cellOfOwnHero.getY() +1));
        if (cellOfOwnHero.getX()  >= 1 && cellOfOwnHero.getY()  >= 1)
            cells.add(battle.getMap().get(cellOfOwnHero.getX() - 1).get(cellOfOwnHero.getY() - 1));
        if (cellOfOwnHero.getX() < 4 && cellOfOwnHero.getY() - 1 >= 0)
            cells.add(battle.getMap().get(cellOfOwnHero.getX() +1).get(cellOfOwnHero.getY()-1));
        for (Cell cell1 : cells) {
            if (cell1.getMinion() != null &&
                    !player.getMainDeck().isContain(cell1.getMinion())) {
                cell1.getMinion().setHp(0);
                cell.getMinion().deadChecker(battle);
                break;
            }
        }
    }

    @Override
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
