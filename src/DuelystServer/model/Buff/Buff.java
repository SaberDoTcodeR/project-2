package DuelystServer.model.Buff;

import DuelystServer.model.Card.Hero.Hero;
import DuelystServer.model.Card.Minion.Minion;
import DuelystServer.model.Cell;

public abstract class Buff {
    public boolean forEnemy;
    public int effectValue;
    public int delay;
    public int last;

    public abstract void castBuff();

    public abstract void setCasting(Cell cell, Hero hero, Minion minion);

    public abstract void dispel(Hero hero);

    public abstract void dispel(Minion minion);
}