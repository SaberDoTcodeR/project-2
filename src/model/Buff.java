package model;

import java.util.Random;

public class Buff {

    private Random random = new Random(50);
    private int randomNumber = random.nextInt();
    public int getRandomNumber(){
        return randomNumber;
    }

}
class HolyBuff extends Buff{
    public void holyHero(Cell cell) {
        cell.getHero().setHoly(true);
    }

    public void holyMinion(Cell cell) {
        cell.getMinion().setHoly(true);
    }
}

class PowerBuff extends Buff{
    public void powerHero(Cell cell) {
        if (getRandomNumber() % 2 == 0)
            cell.getHero().incrementAp(1);
        else
            cell.getMinion().incrementHp(1);
    }

    public void powerMinion(Cell cell) {
        if (getRandomNumber() % 2 == 0)
            cell.getHero().incrementAp(1);
        else
            cell.getMinion().incrementHp(1);
    }
}

class PoisionBuff extends Buff{
    public void poisionHero(Cell cell) {
        cell.getHero().decrementHp(1);
    }

    public void poisionMinion(Cell cell) {
        cell.getMinion().decrementHp(1);
    }
}

class WeaknessBuff extends Buff{
    public void weaknessHero(Cell cell){
        if (getRandomNumber() % 2 == 0)
            cell.getHero().decrementHp(1);
        else
            cell.getHero().decrementAp(1);
    }

    public void weaknessMinion(Cell cell){
        if (getRandomNumber() % 2 == 0)
            cell.getMinion().decrementAp(1);
        else
            cell.getMinion().decrementHp(1);
    }
}

class StunBuff extends Buff{
    public void stunHero(Cell cell) {
        cell.getHero().setStunning(true);
    }

    public void stunMinion(Cell cell) {
        cell.getMinion().setStunning(true);
    }
}

class DisarmBuff extends Buff{
    public void disarmHero(Cell cell) {
        cell.getHero().setTypeOfHit(3);
    }

    public void disarmMinion(Cell cell) {
        cell.getMinion().setTypeOfHit(3);
    }
}