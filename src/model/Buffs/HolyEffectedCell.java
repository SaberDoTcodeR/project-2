package model.Buffs;

import model.Cards.Hero.Hero;
import model.Cards.Minion.Minion;
import model.Cell;

public class HolyEffectedCell extends Buff {
    public void holy(Hero hero) {
        hero.incrementHp(1);
    }

    public void holy(Minion minion) {
        minion.incrementHp(1);
    }

    private HolyEffectedCell holyEffectedCell;
    private Cell cell;
    private Hero hero;
    private Minion minion;

    public void setCasting(HolyEffectedCell holyEffectedCell, Cell cell, Hero hero, Minion minion) {
        this.holyEffectedCell = holyEffectedCell;
        this.cell = cell;
        this.hero = hero;
        this.minion = minion;
    }

    public Cell getCell() {
        return cell;
    }

    public Hero getHero() {
        return hero;
    }

    public Minion getMinion() {
        return minion;
    }

    @Override
    public void castBuff() {
        if (this.cell != null) {
            if (this.cell.getMinion() != null) {
                holy(this.cell.getMinion());
            }
            if (this.cell.getHero() != null) {
                holy(this.cell.getHero());
            }
        }
    }

    @Override
    public void dispel(Hero hero) {
        //Nothing
    }

    @Override
    public void dispel(Minion minion) {
        //Nothing
    }

    public HolyEffectedCell getPoisonEffectedCell() {
        return holyEffectedCell;
    }
}