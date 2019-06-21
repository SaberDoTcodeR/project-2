package Duelyst.model.Buff;

import Duelyst.model.Card.Hero.Hero;
import Duelyst.model.Card.Minion.Minion;

import java.util.ArrayList;
import java.util.Random;

public abstract class Buff {
    protected boolean forEnemy;
    protected int effectValue;
    protected int delay;
    protected int last;
    public abstract void castBuff();

    public abstract void dispel(Hero hero);

    public abstract void dispel(Minion minion);
}


