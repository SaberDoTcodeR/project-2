package DuelystClient.model.Buff;

import DuelystClient.model.Card.Hero.Hero;
import DuelystClient.model.Card.Minion.Minion;
import DuelystClient.model.Cell;


public class PoisonBuff extends Buff {

    public void poison(Hero hero) {
        hero.decrementHp(effectValue);
    }

    public void poison(Minion minion) {
        if (!minion.getClass().getSimpleName().equals("Piran"))
            minion.decrementHp(effectValue);
    }
    public PoisonBuff(int effectValue, int delay, int last) {
        this.effectValue = effectValue;
        this.delay = delay;
        this.last = last;
        this.forEnemy = true;
    }
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


}
