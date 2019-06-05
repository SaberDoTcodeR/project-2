package Duelyst.model.Buff;


import Duelyst.model.Card.Hero.Hero;
import Duelyst.model.Card.Minion.Minion;
import Duelyst.model.Cell;

public class StunBuff extends Buff {

    public void stun(Hero hero) {
        hero.setStunning(true);
    }

    public void stun(Minion minion) {
        minion.setStunning(true);
    }

    private StunBuff stunBuff;
    private Cell cell;
    private Hero hero;
    private Minion minion;

    public void setCasting(StunBuff stunBuff,Cell cell,Hero hero,Minion minion) {
        this.stunBuff = stunBuff;
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

    public StunBuff getStunBuff() {
        return stunBuff;
    }

}