package Duelyst.model.Buff;

import Duelyst.model.Card.Hero.Hero;
import Duelyst.model.Card.Minion.Minion;
import Duelyst.model.Cell;

public class ChangeApBuff extends Buff {
    private int unit;
    private boolean isIncremented;

    private Cell cell;
    private Hero hero;
    private Minion minion;

    public void setCasting( Cell cell, Hero hero, Minion minion) {
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

    public ChangeApBuff(int unit) {
        this.unit = unit;
    }

    public void increment(Hero hero) {
        hero.incrementAp(unit);
        this.isIncremented = true;
    }

    public void decrement(Hero hero) {
        hero.decrementAp(unit);
        this.isIncremented = false;
    }

    public void increment(Minion minion) {
        minion.incrementAp(unit);
        this.isIncremented = true;
    }

    public void decrement(Minion minion) {
        minion.decrementAp(unit);
        this.isIncremented = false;
    }

    @Override
    public void castBuff() {
        if (this.hero != null) {
            if (isIncremented)
                this.hero.incrementAp(unit);
            else
                this.hero.decrementAp(unit);
        }
        if (this.minion != null) {
            if (isIncremented)
                this.minion.incrementAp(unit);
            else
                this.minion.decrementAp(unit);
        }
    }

    @Override
    public void dispel(Hero hero) {
        if (isIncremented) {
            hero.decrementAp(unit);
        } else {
            hero.incrementAp(unit);
        }
    }

    @Override
    public void dispel(Minion minion) {
        if (isIncremented) {
            minion.decrementAp(unit);
        } else {
            minion.incrementAp(unit);
        }
    }


}