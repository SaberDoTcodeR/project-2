package DuelystServer.model.Buff;


import DuelystServer.model.Card.Hero.Hero;
import DuelystServer.model.Card.Minion.Minion;
import DuelystServer.model.Cell;

public class FiringEffectedCell extends Buff {

    private Cell cell;
    private Hero hero;
    private Minion minion;

    public void setCasting(Cell cell, Hero hero, Minion minion) {
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
        {
            System.out.println(cell.getX()+","+cell.getY());
            firing(cell);
        }
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
