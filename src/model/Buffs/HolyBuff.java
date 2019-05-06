package model.Buffs;

import model.Cards.Hero.Hero;
import model.Cards.Minion.Minion;
import model.Cell;

public class HolyBuff extends Buff {

    public void holy(Hero hero) {
        hero.incrementHolyCounter();
    }

    public void holy(Minion minion) {
        minion.incrementHolyCounter();
    }

    private HolyBuff holyBuff;
    private Cell cell;
    private Hero hero;
    private Minion minion;

    public void setCasting(HolyBuff holyBuff,Cell cell,Hero hero,Minion minion) {
        this.holyBuff = holyBuff;
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
            holy(this.hero);
        }
        if (this.minion != null){
            holy(this.minion);
        }
    }

    @Override
    public void dispel(Hero hero) {
        hero.setHolyCounter(0);
    }

    @Override
    public void dispel(Minion minion) {
        minion.setHolyCounter(0);
    }

    public HolyBuff getHolyBuff() {
        return holyBuff;
    }

}
