package model.Cards.Spell;

import model.Battles.Battle;
import model.Cell;
import model.Menus.Account;
import view.Request;

import java.util.ArrayList;

public class AreaDispel extends Spell {

    public AreaDispel() {
        super("AreaDispel", 2, 1500);
    }

    public AreaDispel(AreaDispel areaDispel) {
        super(areaDispel);
    }

    public String getDesc() {
        return SpellWork.AREA_DISPEL.getMessage();
    }

    @Override
    public void castSpell(Battle battle, Cell cell, Account player, Request request) {
        ArrayList<Cell> cells = new ArrayList<>();
        cells.add(cell);
        cells.add(cell.rightCell(battle.getMap()));
        cells.add(cell.downCell(battle.getMap()));
        cells.add(cells.get(1).downCell(battle.getMap()));
        for (Cell cell1 : cells) {
            if (cell != null) {
                Dispel dispel = new Dispel();
                dispel.castSpell(battle, cell1, player, request);
            }
        }
    }

    public Spell duplicate() {
        AreaDispel areaDispel = new AreaDispel(this);
        return areaDispel;
    }

    @Override
    public String showDetails() {
        String details;
        details = " Type : " + getType() + " - Name : " +
                this.getClass().getSimpleName() + " - MP : " + this.getCostToUse() +
                " - Desc: " + SpellWork.AREA_DISPEL.getMessage();
        return details;
    }
}
