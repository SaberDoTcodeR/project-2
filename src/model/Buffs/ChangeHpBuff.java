package model.Buffs;

import model.Cards.Hero.Hero;
import model.Cards.Minion.Minion;
import model.Cell;

public class ChangeHpBuff extends Buff {
    private int unit;
    private boolean isIncremented;

    private ChangeHpBuff changeHpBuff;
    private Cell cell;
    private Hero hero;
    private Minion minion;

    public void setCasting(ChangeHpBuff changeHpBuff,Cell cell,Hero hero,Minion minion) {
        this.changeHpBuff = changeHpBuff;
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


    public ChangeHpBuff(int unit) {
        this.unit = unit;
    }

    public void increment(Hero hero) {
        hero.incrementHp(unit);
        this.isIncremented = true;
    }

    public void decrement(Hero hero) {
        hero.decrementHp(unit);
        this.isIncremented = false;
    }

    public void increment(Minion minion) {
        minion.incrementHp(unit);
        this.isIncremented = true;
    }

    public void decrement(Minion minion) {
        minion.decrementHp(unit);
        this.isIncremented = false;
    }

    @Override
    public void castBuff() {
        if (this.hero != null){
            if (isIncremented)
                this.hero.incrementHp(unit);
            else
                this.hero.decrementHp(unit);
        }
        if (this.minion != null){
            if (isIncremented)
                this.minion.incrementHp(unit);
            else
                this.minion.decrementHp(unit);
        }
    }

    @Override
    public void dispel(Hero hero) {
        if (isIncremented) {
            hero.decrementHp(unit);
        } else {
            hero.incrementHp(unit);
        }
    }

    @Override
    public void dispel(Minion minion) {
        if (isIncremented) {
            minion.decrementHp(unit);
        } else {
            minion.incrementHp(unit);
        }
    }

    public ChangeHpBuff getChangeHpBuff() {
        return changeHpBuff;
    }
}
