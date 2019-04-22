package model;

import java.util.ArrayList;

public class Cell {
    private int x, y;
    private boolean flag;
    private Hero hero;
    private Minion minion;
    private CollectableItem collectableItem;
    private ArrayList<Buff> cellEffect = new ArrayList<Buff>();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean hasFlag() {
        return flag;
    }

    public CollectableItem getCollectableItem() {
        return collectableItem;
    }

    public void addCellEffect(Buff buff) {
        this.cellEffect.add(buff);
    }

    public ArrayList<Buff> getCellEffect() {
        return cellEffect;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Minion getMinion() {
        return minion;
    }

    public void setMinion(Minion minion) {
        this.minion = minion;
    }


    public Cell(int x, int y, boolean flag, CollectableItem collectableItem) {
        this.x = x;
        this.y = y;
        this.flag = flag;
        this.collectableItem = collectableItem;
    }

    public void moveCardPos(int x, int y) {
        if (this.hero != null) {
            Account.getLoginAccount().getBattle().getMap().get(y - 1).get(x - 1).setHero(this.hero);
            this.hero = null;
        } else {
            Account.getLoginAccount().getBattle().getMap().get(y - 1).get(x - 1).setMinion(this.minion);
            this.minion = null;
        }
    }
}