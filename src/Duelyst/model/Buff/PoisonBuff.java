package Duelyst.model.Buff;

import Duelyst.model.Card.Hero.Hero;
import Duelyst.model.Card.Minion.Minion;
import Duelyst.model.Cell;


public class PoisonBuff extends Buff {

    public void poison(Hero hero) {
        hero.decrementHp(1);
    }

    public void poison(Minion minion) {
        if (!minion.getClass().getSimpleName().equals("Piran"))
            minion.decrementHp(1);
    }

    private PoisonBuff poisonBuff;
    private Cell cell;
    private Hero hero;
    private Minion minion;

    public void setCasting(PoisonBuff poisonBuff, Cell cell, Hero hero, Minion minion) {
        this.poisonBuff = poisonBuff;
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
        if (this.hero != null)
            poison(this.hero);
        if (this.minion != null)
            poison(this.minion);
    }

    @Override
    public void dispel(Hero hero) {
        //nothing
    }

    @Override
    public void dispel(Minion minion) {
        //nothing
    }

    public PoisonBuff getPoisonBuff() {
        return poisonBuff;
    }

}
