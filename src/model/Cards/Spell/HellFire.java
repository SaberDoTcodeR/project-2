package model.Cards.Spell;

import model.Battles.Battle;
import model.Buffs.FiringEffectedCell;
import model.Cell;
import model.Menus.Account;
import view.Request;

import java.util.ArrayList;

public class HellFire extends Spell {

    public HellFire() {
        super("HellFire", 3, 600);
    }

    public HellFire(HellFire hellFire) {
        super(hellFire);
    }

    @Override
    public void castSpell(Battle battle, Cell cell, Account player, Request request) {
        ArrayList<Cell> cells = new ArrayList<>();
        cells.add(cell);
        if (cell.getX() < 5 && cell.getY() < 9)
            cells.add(request.getBattle().getMap().get(cell.getX()).get(cell.getY()));
        if (cell.getY() < 9)
            cells.add(cell.rightCell(battle.getMap()));
        if (cell.getX() < 5)
            cells.add(cell.downCell(battle.getMap()));
        for (Cell cell1 : cells) {
            if (cell1 != null) {
                FiringEffectedCell firingEffectedCell = new FiringEffectedCell();
                firingEffectedCell.setTurnCounter(1);
                firingEffectedCell.firing(cell1);
                firingEffectedCell.setCasting(firingEffectedCell, cell1, null, null);
                cell1.getCellEffect().add(firingEffectedCell);
            }
        }
    }

    @Override
    public Spell duplicate() {
        HellFire hellFire = new HellFire(this);
        return hellFire;
    }

    @Override
    public String getDesc() {
        return SpellWork.HELL_FIRE.getMessage();
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.HELL_FIRE.getMessage();
        return details;
    }
}
