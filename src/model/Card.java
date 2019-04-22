package model;

public abstract class Card {
    private String name;
    private boolean isOnMap;
    private int costOfBuy;
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

    public int getId() {
        return id;
    }

    public String getType() {
        return this.getClass().getSimpleName();
    }

    public abstract String showDetails();
}
