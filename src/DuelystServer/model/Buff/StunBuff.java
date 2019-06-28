package DuelystServer.model.Buff;


import DuelystServer.model.Card.Hero.Hero;
import DuelystServer.model.Card.Minion.Minion;
import DuelystServer.model.Cell;

public class StunBuff extends Buff {

    public void stun(Hero hero) {
        hero.setStunning(true);
    }

    public void stun(Minion minion) {
        minion.setStunning(true);
    }

    private Cell cell;
    private Hero hero;
    private Minion minion;

    public void setCasting(Cell cell, Hero hero, Minion minion) {
        this.cell = cell;
        this.hero = hero;
        this.minion = minion;
    }
    public StunBuff(int effectValue, int delay, int last) {
        this.effectValue = effectValue;
        this.delay = delay;
        this.last = last;
        this.forEnemy = true;
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
        if (this.hero != null){
            stun(this.hero);
        }
        if (this.minion != null){
            stun(this.minion);
        }
    }

    @Override
    public void dispel(Hero hero) {
        hero.setStunning(false);
    }

    @Override
    public void dispel(Minion minion) {
        minion.setStunning(false);
    }


}