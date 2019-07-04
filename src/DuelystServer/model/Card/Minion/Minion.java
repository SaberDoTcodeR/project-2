package DuelystServer.model.Card.Minion;


import DuelystServer.model.Account;
import DuelystServer.model.Battle.Battle;
import DuelystServer.model.Buff.Buff;
import DuelystServer.model.Card.Card;
import DuelystServer.model.Card.Hero.Hero;
import DuelystServer.model.Cell;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Minion extends Card {
    private transient static ArrayList<Minion> minions = new ArrayList<>();
    private transient static Map<String,Integer> minionsName = new HashMap<>();
    private int numberOfFlag = 0;
    private boolean flag = false;

    public static Map<String,Integer> getMinionsName() {
        return minionsName;
    }

    public void setCostToUse(int costToUse) {
        this.costToUse = costToUse;
    }

    public void setTypeOfRange(int typeOfRange) {
        this.typeOfRange = typeOfRange;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void setNumberOfAttacks(int numberOfAttacks) {
        this.numberOfAttacks = numberOfAttacks;
    }

    public int getNumberOfFlag() {
        return numberOfFlag;
    }

    public void setNumberOfFlag(int howManyFlag) {
        this.numberOfFlag = howManyFlag;
    }

    static {
        new ArzhangBogey();
        new Ashkbous();
        new Bahman();
        new BlackBogey();
        new CatapultGiant();
        new ColdGrandma();
        new Eagle();
        new Elf();
        new FieryDragon();
        new GiantColossus();
        new GiantKing();
        new GiantMagician();
        new GiantSnake();
        new Giv();
        new HogRiderBogey();
        new Iraj();
        new LupinLion();
        new Magician();
        new OneEyeGiant();
        new Panther();
        new PersianArcher();
        new PersianGeneralissimo();
        new PersianGladiator();
        new PersianHorseman();
        new PersianSpear();
        new PersianSwordsman();
        new Piran();
        new PoisonSnake();
        new Siavash();
        new SteelArmor();
        new TuranianArcher();
        new TuranianPrince();
        new TuranianSpear();
        new TuranianSpy();
        new TuranianStoneHook();
        new TuranianSwampy();
        new TwoHeadGiant();
        new WhiteWolf();
        new WildHog();
        new Wolf();
    }

    private boolean isDeathCurse;
    private int ap;
    private int hp;
    private int costToUse;
    private boolean isStunning = false;
    private int holyCounter = 0;
    private boolean counterAttack = true;
    //private SpecialPower specialPower;
    private int typeOfRange;//0 melee 1 ranged 2 hybrid
    private int range;
    private int timeOfActivationOfSpecialPower;//0 on attack 1 on spawn 2 combo 3 on death 4 passive 5 on turn 6 on defend
    private int numberOfAttacks = 0;
    private transient ArrayList<Buff> ownBuffs = new ArrayList<>();

    public ArrayList<Buff> getOwnBuffs() {
        return ownBuffs;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }


    public boolean isCounterAttack() {
        return counterAttack;
    }

    public void setCounterAttack(boolean counterAttack) {
        this.counterAttack = counterAttack;
    }

    public void moveToGame(Battle battle, int x, int y) {
        if (battle.getTurn() % 2 == 1) {
            battle.getFirstPlayerHand().getCards().remove(this);
            battle.getFirstPlayerInGameCards().add(this);
            battle.getMap().get(x - 1).get(y - 1).setMinion(this, 0);
        } else {
            battle.getSecondPlayerHand().getCards().remove(this);
            battle.getSecondPlayerInGameCards().add(this);
            battle.getMap().get(x - 1).get(y - 1).setMinion(this, 1);
        }

        this.setRemainedMoves(0);
        this.cardIdGenerator(battle);
    }

    public int getTypeOfRange() {
        return typeOfRange;
    }

    public String getDesc(){
        return  null;
    }

    public int getRange() {
        return range;
    }

    public Minion(String name, int ap, int hp, int costOfBuy, int costToUse, int typeOfRange, int range) {
        this.setName(name);
        this.setCostOfBuy(costOfBuy);
        this.ap = ap;
        this.hp = hp;
        this.costToUse = costToUse;
        this.typeOfRange = typeOfRange;
        this.range = range;
        minions.add(this);
        minionsName.put(this.getName().toLowerCase(),this.getCostOfBuy());
    }

    public String getType() {
        return "Minion";
    }

    public void setTimeOfActivationOfSpecialPower(int timeOfActivationOfSpecialPower) {
        this.timeOfActivationOfSpecialPower = timeOfActivationOfSpecialPower;
    }

    public int getTimeOfActivationOfSpecialPower() {
        return timeOfActivationOfSpecialPower;
    }

    public Minion(Minion minion) {
        this.setName(minion.getName());
        this.setCostOfBuy(minion.getCostOfBuy());
        this.ap = minion.ap;
        this.hp = minion.hp;
        this.costToUse = minion.costToUse;
        this.typeOfRange = minion.typeOfRange;
        this.range = minion.range;
        this.timeOfActivationOfSpecialPower = minion.timeOfActivationOfSpecialPower;
        for (int i = 0; i < minions.size(); i++) {
            if (minions.get(i).getName().equals(minion.getName())) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            minions.add(minion);
            minionsName.put(minion.getName().toLowerCase(),minion.getCostOfBuy());
        }
    }

    public int getAp() {
        return ap;
    }

    public int getCostToUse() {
        return costToUse;
    }

    public int getHp() {
        return hp;
    }

    public int getHolyCounter() {
        return holyCounter;
    }

    public void incrementHolyCounter() {
        this.holyCounter++;
    }

    public void setHolyCounter(int holyCounter) {
        this.holyCounter = holyCounter;
    }

    public void incrementAp(int unit) {
        this.ap += unit;
    }

    public void decrementAp(int unit) {
        if (unit > 0)
            this.ap -= unit;
    }

    public void changeAP(int unit) {
        this.ap += unit;
    }

    public void changeHP(int unit) {
        this.hp += unit;
    }

    public void incrementHp(int unit) {
        this.hp += unit;
    }

    public void decrementHp(int unit) {
        if (unit > 0)
            this.hp -= unit;
    }

    public static ArrayList<Minion> getMinions() {
        return minions;
    }

    public void setTypeOfHit(int typeOfRange) {
        this.typeOfRange = typeOfRange;
    }

    public String getTypeOfHit() {
        if (this.typeOfRange == 0)
            return "Melee";
        else if (this.typeOfRange == 1)
            return "Ranged";
        else if (this.typeOfRange == 2)
            return "Hybrid";
        else
            return null;
    }

    public boolean isStunning() {
        return isStunning;
    }

    public void setStunning(boolean stunning) {
        isStunning = stunning;
    }

    public Minion duplicate() {
        return null;
    }

    public void castSpecialPower(Battle battle, Cell cell, Account player, int activeTime){}

    public int getNumberOfAttacks() {
        return numberOfAttacks;
    }

    public boolean isDeathCurse() {
        return isDeathCurse;
    }

    public void setDeathCurse(boolean deathCurse) {
        isDeathCurse = deathCurse;
    }

    public void applyDeathCurse(Battle battle, Account player) {
        int indexI = 0;
        int indexJ = 0;
        for (int i = 0; i < 5; i++) {
            if (battle.getMap().get(i).contains(this)) {
                indexI = i;
                indexJ = battle.getMap().get(i).indexOf(this);
                break;
            }
        }
        double[][] distance = new double[5][];
        for (int i = 0; i < 5; i++) {
            distance[i] = new double[9];
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                distance[i][j] = 100;
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == indexI && j == indexJ)
                    continue;
                if (battle.getMap().get(i).get(j).getHero() != null &&
                        isEnemyHero(battle.getMap().get(i).get(j).getHero(), player)) {
                    distance[i][j] = getPow(indexI, indexJ, i, j);
                }
                if (battle.getMap().get(i).get(j).getMinion() != null &&
                        isEnemyMinion(battle.getMap().get(i).get(j).getMinion(), player)) {
                    distance[i][j] = getPow(indexI, indexJ, i, j);
                }
            }
        }
        double minValue = distance[0][0];
        int indexMinI = 0;
        int indexMinJ = 0;
        for (int j = 0; j < distance.length; j++) {
            for (int i = 0; i < distance[j].length; i++) {
                if (distance[j][i] < minValue) {
                    minValue = distance[j][i];
                    indexMinI = i;
                    indexMinJ = j;
                }
            }
        }
        if (battle.getMap().get(indexMinI).get(indexMinJ).getHero() != null) {
            battle.getMap().get(indexMinI).get(indexMinJ).getHero().decrementHp(8);
        }
        if (battle.getMap().get(indexMinI).get(indexMinJ).getMinion() != null) {
            battle.getMap().get(indexMinI).get(indexMinJ).getMinion().decrementHp(8);
        }
    }

    private boolean isEnemyHero(Hero hero, Account player) {
        return player.getMainDeck().isContain(hero);
    }

    private boolean isEnemyMinion(Minion minion, Account player) {
        return player.getMainDeck().isContain(minion);
    }

    private double getPow(int indexI, int indexJ, int i, int j) {
        return Math.pow(Math.pow(Math.abs(i - indexI), 2) + Math.pow(Math.abs(j - indexJ), 2), 1.0 / 2.0);
    }

    public void increaseNumberOfAttacks() {
        this.numberOfAttacks++;
    }
    public Image getImage(){
        return this.cardImage;
    }
}

