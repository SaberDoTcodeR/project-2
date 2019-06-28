package DuelystClient.model.Buff;

import DuelystClient.model.Card.Hero.Hero;
import DuelystClient.model.Card.Minion.Minion;
import DuelystClient.model.Cell;


public class HolyBuff extends Buff {
    private boolean used = false;

    private Hero hero;
    private Minion minion;
    private Cell cell;

    public void setCasting(Cell cell, Hero hero, Minion minion) {
        this.cell = cell;
        this.hero = hero;
        this.minion = minion;
    }

    public HolyBuff(int effectValue, int delay, int last) {
        this.effectValue = effectValue;
        this.delay = delay;
        this.last = last;
        this.forEnemy = false;
    }

    @Override
    public void castBuff() {
        if (!used) {
            if (this.hero != null) {
                for (int i = 0; i < effectValue; i++)
                    this.hero.incrementHolyCounter();
            }
            if (this.minion != null) {
                for (int i = 0; i < effectValue; i++)
                    this.hero.incrementHolyCounter();
            }
            used = true;
        }
    }


    @Override
    public void dispel(Hero hero) {
        for (int i = 0; i < effectValue; i++)
            this.hero.decrementHolyCounter();
    }

    @Override
    public void dispel(Minion minion) {
        for (int i = 0; i < effectValue; i++)
            this.hero.decrementHolyCounter();
    }

}
