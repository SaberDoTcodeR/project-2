package model;

import java.util.Random;

public class Buff {

    private Random random = new Random(50);
    private int randomNumber = random.nextInt();

    public void holyHero(Hero hero) {
        hero.setHoly(true);
    }

    public void holyMinion(Minion minion) {
        minion.setHoly(true);
    }
//..........................
    public void powerHero(Hero hero) {
        if (randomNumber % 2 == 0)
            hero.incrementAp(1);
        else
            hero.incrementHp(1);
    }

    public void powerMinion(Minion minion) {
        if (randomNumber % 2 == 0)
            minion.incrementAp(1);
        else
            minion.incrementHp(1);
    }
//..........................
    public void poisionHero(Hero hero) {
        hero.decrementHp(1);
    }

    public void poisionMinion(Minion minion) {
        minion.decrementHp(1);
    }
//..........................
    public void weaknessHero(Hero hero){
        if (randomNumber % 2 == 0)
            hero.decrementHp(1);
        else
            hero.decrementAp(1);
    }

    public void weaknessMinion(Minion minion){
        if (randomNumber % 2 == 0)
            minion.decrementAp(1);
        else
            minion.decrementHp(1);
    }
//..........................
    public void stunHero(Hero hero) {
        hero.setStunning(true);
    }

    public void stunMinion(Minion minion) {
        minion.setStunning(true);
    }
//..........................
    public void disarmHero(Hero hero) {
        hero.setTypeOfHit(3);
    }

    public void disarmMinion(Minion minion) {
        minion.setTypeOfHit(3);
    }
}
