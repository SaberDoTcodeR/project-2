package model;

import model.Cards.Buff;
import model.Cards.Hero;
import model.Cards.Minion;
import model.Item.CollectableItem;

import java.util.ArrayList;

public class Cell {
    private int x, y;
    private boolean flag;
    private Hero hero;
    private Minion minion;
    private CollectableItem collectableItem;
    private int whichPlayerIsInCell;
    private ArrayList<Buff> cellEffect = new ArrayList<>();

    public int getWhichPlayerIsInCell() {
        return whichPlayerIsInCell;
    }

    public void setWhichPlayerIsInCell(int whichPlayerIsInCell) {
        this.whichPlayerIsInCell = whichPlayerIsInCell;
    }

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

    public void setHero(Hero hero,int whichPlayerIsInCell) {
        this.hero = hero;
        this.whichPlayerIsInCell=whichPlayerIsInCell;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Minion getMinion() {
        return minion;
    }

    public void setMinion(Minion minion,int whichPlayerIsInCell) {
        this.minion = minion;
        this.whichPlayerIsInCell=whichPlayerIsInCell;
    }


    public Cell(int x, int y, boolean flag, int indexOfCollect) {
        this.x = x;
        this.y = y;
        this.flag = flag;
        if(indexOfCollect!=-1){
            this.collectableItem = CollectableItem.getCollectableItems().get(indexOfCollect).duplicate();
        }

    }

    /*public void moveCardPos(int x, int y) {
        if (this.hero != null) {
            Account.getLoginAccount().getBattle().getMap().get(y - 1).get(x - 1).setHero(this.hero);
            this.hero = null;
        } else {
            Account.getLoginAccount().getBattle().getMap().get(y - 1).get(x - 1).setMinion(this.minion);
            this.minion = null;
        }
    }*/
}