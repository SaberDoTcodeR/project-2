package Duelyst.model.Buff;

import Duelyst.model.Card.Hero.Hero;
import Duelyst.model.Card.Minion.Minion;
import Duelyst.model.Cell;

public class DisarmBuff extends Buff {

    public void disarm(Hero hero) {
        hero.setCounterAttack(false);
    }

    public DisarmBuff(int effectValue, int delay, int last) {
        this.effectValue = effectValue;
        this.delay = delay;
        this.last = last;
        this.forEnemy = true;
    }

    public void disarm(Minion minion) {
        if (!minion.getClass().getSimpleName().equals("WildHog")) {
            minion.setCounterAttack(false);
        }
    }

    private Cell cell;
    private Hero hero;
    private Minion minion;

    public void setCasting(Cell cell,Hero hero,Minion minion) {
        this.cell = cell;
        this.hero = hero;
        this.minion = minion;
    }

    @Override
    public void castBuff() {
        if (this.minion != null)
            disarm(this.minion);
        if (this.hero != null)
            disarm(this.hero);
    }

    @Override
    public void dispel(Hero hero) {
        hero.setCounterAttack(true);
    }

    @Override
    public void dispel(Minion minion) {
        minion.setCounterAttack(true);
    }

}
