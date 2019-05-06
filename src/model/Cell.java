package model;

import model.Battles.Battle;
import model.Buffs.Buff;
import model.Cards.Card;
import model.Cards.Hero.Hero;
import model.Cards.Minion.Minion;
import model.Item.CollectibleItem.CollectibleItem;

import java.util.ArrayList;

public class Cell {
    private int x, y;
    private boolean flag;
    private Hero hero;
    private Minion minion;
    private CollectibleItem collectibleItem;
    private int whichPlayerIsInCell;//0 for first player  1 for second player
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

    public CollectibleItem getCollectibleItem() {
        return collectibleItem;
    }

    public void setCollectibleItem(CollectibleItem collectibleItem) {
        this.collectibleItem = collectibleItem;
    }

    public void addCellEffect(Buff buff) {
        this.cellEffect.add(buff);
    }

    public ArrayList<Buff> getCellEffect() {
        return cellEffect;
    }

    public Cell rightCell(ArrayList<ArrayList<Cell>> map) {
        if (this == null)
            return null;
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).size(); j++) {
                if (map.get(i).get(j).equals(this)) {
                    return map.get(i).get(j + 1);
                }
            }
        }
        return null;
    }

    public Cell leftCell(ArrayList<ArrayList<Cell>> map) {
        if (this == null)
            return null;
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).size(); j++) {
                if (map.get(i).get(j).equals(this)) {
                    return map.get(i).get(j - 1);
                }
            }
        }
        return null;
    }

    public Cell downCell(ArrayList<ArrayList<Cell>> map) {

        if (this == null)
            return null;
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).size(); j++) {
                if (map.get(i).get(j).equals(this)) {
                    return map.get(i + 1).get(j);
                }
            }
        }
        return null;
    }

    public Cell upCell(ArrayList<ArrayList<Cell>> map) {
        if (this == null)
            return null;
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).size(); j++) {
                if (map.get(i).get(j).equals(this)) {
                    return map.get(i - 1).get(j);
                }
            }
        }
        return null;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero, int whichPlayerIsInCell) {
        this.hero = hero;
        this.minion = null;//ezafe shod
        this.whichPlayerIsInCell = whichPlayerIsInCell;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Minion getMinion() {
        return minion;
    }

    public void setMinion(Minion minion, int whichPlayerIsInCell) {
        this.minion = minion;
        this.hero = null;//ezafe shod
        this.whichPlayerIsInCell = whichPlayerIsInCell;
    }


    public Cell(int x, int y, boolean flag, int indexOfCollect) {
        this.x = x;
        this.y = y;
        this.flag = flag;
        if (indexOfCollect != -1) {
            this.collectibleItem = CollectibleItem.getCollectibleItems().get(indexOfCollect).duplicate();
        }

    }

    public int manhataniDistance(int x, int y) {
        x--;
        y--;
        return abs(this.x - x) + abs(this.y - y);
    }

    public int abs(int x) {
        return Math.abs(x);
    }

    public void moveCardPos(int x, int y, Battle battle) {
        int who = battle.getMap().get(x).get(y).whichPlayerIsInCell;
        if (this.hero != null) {
            battle.getMap().get(x - 1).get(y - 1).setHero(this.hero, who);
            this.hero = null;
        } else {
            battle.getMap().get(x - 1).get(y - 1).setMinion(this.minion, who);
            this.minion = null;
        }
    }

    public Cell getCellOfCard(Card card, Battle battle) {
        for (int i = 0; i < 5; i++) {
            for (Cell cell : battle.getMap().get(i)) {
                if (cell.getMinion() != null && cell.getMinion().getCardId().equals(card.getCardId()))
                    return cell;
                else if (cell.getHero() != null && cell.getHero().getCardId().equals(card.getCardId()))
                    return cell;
            }
        }
        return null;

    }
}