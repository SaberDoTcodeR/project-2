package model.Cards;

public abstract class Card {
    private String name;
    private boolean isOnMap;
    private int costOfBuy;
    private long id;
    private int countOfType = 1;
    private String CardId;
    private boolean isStunning = false;
    private boolean counterAttack = true;
    private boolean canDisarm = true;

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

    public boolean isStunning() {
        return isStunning;
    }

    public void setStunning(boolean stunning) {
        isStunning = stunning;
    }

    public boolean isCounterAttack() {
        return counterAttack;
    }

    public void setCounterAttack(boolean counterAttack) {
        this.counterAttack = counterAttack;
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

    public void cardIdGenerator(String playerName) {
        String str = playerName + "_" + this.getName() + "_" + this.getCountOfType();
        setCardId(str);
    }

    public void setCanDisarm(boolean canDisarm) {
        this.canDisarm = canDisarm;
    }

    public boolean isCanDisarm() {
        return canDisarm;
    }
}
