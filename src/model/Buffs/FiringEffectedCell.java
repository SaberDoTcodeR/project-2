package model.Buffs;

import model.Cards.Hero.Hero;
import model.Cards.Minion.Minion;
import model.Cell;

public class FiringEffectedCell extends Buff {

    private FiringEffectedCell firingEffectedCell;
    private Cell cell;
    private Hero hero;
    private Minion minion;

    public void setCasting(FiringEffectedCell firingEffectedCell,Cell cell,Hero hero,Minion minion) {
        this.firingEffectedCell = firingEffectedCell;
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

    public void firing(Cell cell){
        if (cell.getHero() != null){
            cell.getHero().decrementHp(2);
        }
        if (cell.getMinion() != null){
            cell.getMinion().decrementHp(2);
        }
    }

    @Override
    public void castBuff() {
        if (this.cell != null)
            firing(cell);
    }

    @Override
    public void dispel(Hero hero) {
        //nothing
    }

    @Override
    public void dispel(Minion minion) {
        //nothing
    }

    public FiringEffectedCell getFiringEffectedCell() {
        return firingEffectedCell;
    }

}
