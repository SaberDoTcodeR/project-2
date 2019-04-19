package model;

import java.util.ArrayList;

public abstract class Card {
    private String name;
    private boolean isOnMap;
    private int costOfBuy;
    private Cell currentCell;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String nameOfCard) {
        this.name = nameOfCard;
    }


    public boolean isOnMap() {
        return isOnMap;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCostOfBuy() {
        return costOfBuy;
    }

    public void setCostOfBuy(int costOfBuy) {
        this.costOfBuy = costOfBuy;
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public void moveCard(String string) {//up down right left
        if (string.equals("up")) {
            this.currentCell = currentCell.getUpCell();
        } else if (string.equals("down")) {
            this.currentCell = currentCell.getDownCell();
        } else if (string.equals("left")) {
            this.currentCell = currentCell.getLeftCell();
        } else {
            this.currentCell = currentCell.getRightCell();
        }
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return this.getClass().getSimpleName();
    }

}

