package model.Cards;

public abstract class Card {
    private String name;
    private boolean isOnMap;
    private int costOfBuy;
    private long id;
    private int countOfType=1;
    private String CardId;
    public String getName() {
        return name.toLowerCase();
    }

    public void setName(String nameOfCard) {
        this.name = nameOfCard;
    }

    public int getCountOfType() {
        return countOfType;
    }

    public void increamentCountOfType() {
        this.countOfType++;
    }

    public String getCardId() {
        return CardId;
    }

    public void setCardId(String cardId) {
        CardId = cardId;
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
    public void cardIdGenerator(String playerName){
        String str=playerName+"_"+this.getName()+"_"+this.getCountOfType();
        setCardId(str);
    }
}
