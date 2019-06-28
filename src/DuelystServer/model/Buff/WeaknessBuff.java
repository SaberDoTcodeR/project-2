package DuelystServer.model.Buff;


import DuelystServer.model.Card.Hero.Hero;
import DuelystServer.model.Card.Minion.Minion;
import DuelystServer.model.Cell;

public class WeaknessBuff extends Buff {

    private int unit;

    private boolean apOrHp;
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

    public WeaknessBuff(int unit, boolean apOrHp) {
        this.unit = unit;
        this.apOrHp = apOrHp;
    }

    public void decrementAp(Hero hero) {
        hero.decrementAp(unit);
    }

    public void decrementHp(Hero hero) {
        hero.decrementHp(unit);
    }

    public void decrementAp(Minion minion) {
        minion.decrementAp(1);
    }

    public void decrementHp(Minion minion) {
        minion.decrementHp(1);
    }

    @Override
    public void castBuff() {
        if (apOrHp){
            if (this.hero != null){
                decrementAp(this.hero);
            }
            if (this.minion != null){
                decrementAp(this.minion);
            }
        } else {
            if (this.hero != null){
                decrementHp(this.hero);
            }
            if (this.minion != null){
                decrementHp(this.minion);
            }
        }
    }

    @Override
    public void dispel(Hero hero) {
        if (apOrHp)
            hero.incrementAp(unit);
        else
            hero.incrementHp(unit);
    }

    @Override
    public void dispel(Minion minion) {
        if (apOrHp)
            minion.incrementAp(unit);
        else
            minion.incrementHp(unit);
    }


}
