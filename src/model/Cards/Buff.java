package model.Cards;

import model.Cell;

import java.util.ArrayList;
import java.util.Random;

public class Buff {

    private Random random = new Random(50);

    private int turnCounter;

    public int getRandomNumber() {
        int randomNumber = random.nextInt();
        return randomNumber;
    }

    public int getTurnCounter() {
        return turnCounter;
    }

    public void setTurnCounter(int turnCounter) {
        this.turnCounter = turnCounter;
    }

    public void decrementTurnCounter(int number) {
        this.turnCounter -= number;
    }

    public void incrementTurnCounter(int number) {
        this.turnCounter += number;
    }
}

class HolyBuff extends Buff {

    public void holy(Cell cell) {
        if (cell.getHero() != null)
            cell.getHero().setHoly(true);
        if (cell.getMinion() != null)
            cell.getMinion().setHoly(true);

    }

    public void holy(ArrayList<Cell> cells) {
        for (Cell cell : cells) {
            if (cell.getHero() != null)
                cell.getHero().setHoly(true);
            if (cell.getMinion() != null)
                cell.getMinion().setHoly(true);
        }
    }
}

class PowerBuff extends Buff {
    public void power(Cell cell) {
        if (cell.getHero() != null) {
            if (getRandomNumber() % 2 == 0)
                cell.getHero().incrementAp(1);
            else
                cell.getMinion().incrementHp(1);
        }
        if (cell.getMinion() != null) {
            if (getRandomNumber() % 2 == 0)
                cell.getHero().incrementAp(1);
            else
                cell.getMinion().incrementHp(1);
        }
    }

    public void power(ArrayList<Cell> cells) {
        for (Cell cell : cells) {
           power(cell);
        }
    }
}

class PosionBuff extends Buff {
    public void posion(Cell cell) {
        if (cell.getHero() != null)
            cell.getHero().decrementHp(1);
        if (cell.getMinion() != null)
            cell.getMinion().decrementHp(1);
    }

    public void posion(ArrayList<Cell> cells) {
        for (Cell cell : cells) {
            if (cell.getHero() != null)
                cell.getHero().decrementHp(1);
            if (cell.getMinion() != null)
                cell.getMinion().decrementHp(1);
        }
    }
}

class WeaknessBuff extends Buff {
    public void weakness(Cell cell) {
        if (cell.getHero() != null) {
            if (getRandomNumber() % 2 == 0)
                cell.getHero().decrementHp(1);
            else
                cell.getHero().decrementAp(1);
        }
        if (cell.getMinion() != null) {
            if (getRandomNumber() % 2 == 0)
                cell.getMinion().decrementAp(1);
            else
                cell.getMinion().decrementHp(1);
        }
    }

    public void weakness(ArrayList<Cell> cells) {
        for (Cell cell : cells) {
            weakness(cell);
        }
    }
}

class StunBuff extends Buff {

    public void stun(Cell cell) {
        if (cell.getHero() != null)
            cell.getHero().setStunning(true);
        if (cell.getMinion() != null)
            cell.getMinion().setStunning(true);
    }

    public void stun(ArrayList<Cell> cells) {
        for (Cell cell : cells) {
            if (cell.getHero() != null)
                cell.getHero().setStunning(true);
            if (cell.getMinion() != null)
                cell.getMinion().setStunning(true);
        }
    }

}

class DisarmBuff extends Buff {

    public void disarm(Cell cell) {
        if (cell.getHero() != null)
            cell.getHero().setTypeOfHit(3);
        if (cell.getMinion() != null)
            cell.getMinion().setTypeOfHit(3);
    }
    public void disarm(ArrayList<Cell> cells) {
        for (Cell cell : cells) {
            if (cell.getHero() != null)
                cell.getHero().setTypeOfHit(3);
            if (cell.getMinion() != null)
                cell.getMinion().setTypeOfHit(3);
        }
    }
}

class ChangeApBuff extends Buff {
    private int unit;

    public ChangeApBuff(int unit) {
        this.unit = unit;
    }

    public void changeAP(Cell cell) {
        if (cell.getHero() != null)
            cell.getHero().changeAP(this.unit);
        if (cell.getMinion() != null)
            cell.getMinion().changeAP(this.unit);
    }

    public void changeAP(ArrayList<Cell> cells) {
        for (Cell cell : cells) {
            if (cell.getHero() != null)
                cell.getHero().changeAP(this.unit);
            if (cell.getMinion() != null)
                cell.getMinion().changeAP(this.unit);
        }
    }
}

class ChangeHpBuff extends Buff {
    private int unit;

    public ChangeHpBuff(int unit) {
        this.unit = unit;
    }

    public void changeHP(Cell cell) {
        if (cell.getHero() != null)
            cell.getHero().changeHP(this.unit);
        if (cell.getMinion() != null)
            cell.getMinion().changeHP(this.unit);
    }

    public void changeHP(ArrayList<Cell> cells) {
        for (Cell cell : cells) {
            if (cell.getHero() != null)
                cell.getHero().changeHP(this.unit);
            if (cell.getMinion() != null)
                cell.getMinion().changeHP(this.unit);
        }
    }
}

class FiringEffectedCell extends Buff {
    public void decrementHp(Cell cell) {
        if (cell.getHero() != null)
            cell.getHero().decrementHp(2);
        if (cell.getMinion() != null)
            cell.getMinion().decrementHp(2);
    }

    public void changeHP(ArrayList<Cell> cells) {
        for (Cell cell : cells) {
            if (cell.getHero() != null)
                cell.getHero().decrementHp(2);
            if (cell.getMinion() != null)
                cell.getMinion().decrementHp(2);
        }
    }
}