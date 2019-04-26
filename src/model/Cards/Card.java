package model.Cards;

public abstract class Card {
    private String name;
    private boolean isOnMap;
    private int costOfBuy;
    private long id;

    public String getName() {
        return name.toLowerCase();
    }

    public void setName(String nameOfCard) {
        this.name = nameOfCard;
    }


    public boolean isOnMap() {
        return isOnMap;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCostOfBuy() {
        return costOfBuy;
    }

    public void setCostOfBuy(int costOfBuy) {
        this.costOfBuy = costOfBuy;
    }

    public long getId() {
        return id;
    }

    abstract public String getType();

    public abstract String showDetails();
}
