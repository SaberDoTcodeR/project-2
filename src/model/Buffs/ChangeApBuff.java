package model.Buffs;

import model.Cards.*;
import model.Cell;

public class ChangeApBuff extends Buff {
    private int unit;
    private boolean isIncremented;

    private ChangeApBuff changeApBuff;
    private Cell cell;
    private Hero hero;
    private Minion minion;

    public void setCasting(ChangeApBuff changeApBuff,Cell cell,Hero hero,Minion minion) {
        this.changeApBuff = changeApBuff;
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
        if (this.hero != null){
            if (isIncremented)
                this.hero.incrementAp(unit);
            else
                this.hero.decrementAp(unit);
        }
        if (this.minion != null){
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

    public ChangeApBuff getChangeApBuff() {
        return changeApBuff;
    }

}