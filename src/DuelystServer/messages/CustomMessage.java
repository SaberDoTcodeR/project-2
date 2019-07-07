package DuelystServer.messages;

public class CustomMessage {
    private int messageId = 21432;
    private String name;
    private int ap;
    private int hp;
    private int mana;
    private int cost;
    private int range;
    private int typeOfRange;
    private int coolDownTime;
    private int activeTime;
    private boolean type;

    public CustomMessage(String name, int ap, int hp, int mana, int cost, int range, int typeOfRange, int coolDownTime, int activeTime, boolean type) {
        setActiveTime(activeTime);
        setAp(ap);
        setCoolDownTime(coolDownTime);
        setCost(cost);
        setHp(hp);
        setName(name);
        setMana(mana);
        setRange(range);
        setType(type);
        setTypeOfRange(typeOfRange);
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAp() {
        return ap;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getTypeOfRange() {
        return typeOfRange;
    }

    public void setTypeOfRange(int typeOfRange) {
        this.typeOfRange = typeOfRange;
    }

    public int getCoolDownTime() {
        return coolDownTime;
    }

    public void setCoolDownTime(int coolDownTime) {
        this.coolDownTime = coolDownTime;
    }

    public int getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(int activeTime) {
        this.activeTime = activeTime;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }
}
