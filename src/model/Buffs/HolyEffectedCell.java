package model.Buffs;

import model.Cards.Hero;
import model.Cards.Minion;
import model.Cell;

public class HolyEffectedCell extends Buff {
    public void makeCellHoly(Cell cell) {
        HolyBuff holyBuff = new HolyBuff();
        holyBuff.setTurnCounter(3);
        if (cell.getMinion() != null){
            holyBuff.holy(cell.getMinion());
        } else if (cell.getHero() != null){
            holyBuff.holy(cell.getHero());
        }
        cell.getCellEffect().add(holyBuff);
    }

    @Override
    public void dispel(Hero hero) {
        //nothing
    }

    @Override
    public void dispel(Minion minion) {
        //nothing
    }
}
