package Duelyst.model.Buff;

import Duelyst.model.Card.Hero.Hero;
import Duelyst.model.Card.Minion.Minion;
import Duelyst.model.Cell;

import java.util.ArrayList;
import java.util.Random;

public abstract class Buff {
    public boolean forEnemy;
    public int effectValue;
    public int delay;
    public int last;

    public abstract void castBuff();

    public abstract void setCasting( Cell cell, Hero hero, Minion minion);

    public abstract void dispel(Hero hero);

    public abstract void dispel(Minion minion);
}


