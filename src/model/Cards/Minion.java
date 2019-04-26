package model.Cards;

import java.util.ArrayList;

public abstract class Minion extends Card {
    private static ArrayList<Minion> minions = new ArrayList<>();

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

    private int ap;
    private int hp;
    private int costToUse;
    private boolean isStunning = false;
    private boolean isHoly = false;
    //private SpecialPower specialPower;
    private int typeOfRange;//0 mellee 1 ranged 2 hybrid
    private int range;
    private int timeOfActivationOfSpecialPower;//0 on attack 1 on spawn 2 combo 3 on death 4 passive 5 on turn 6 on defend

    public int getTypeOfRange() {
        return typeOfRange;
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
    }

    public String getType() {
        return "Minioin";
    }

    public void setTimeOfActivationOfSpecialPower(int timeOfActivationOfSpecialPower) {
        this.timeOfActivationOfSpecialPower = timeOfActivationOfSpecialPower;
    }

    public Minion(Minion minion) {
        this.setName(minion.getName());
        this.setCostOfBuy(minion.getCostOfBuy());
        this.ap = minion.ap;
        this.hp = minion.hp;
//        this.specialPower = minion.specialPower;
        this.costToUse = minion.costToUse;
        this.typeOfRange = minion.typeOfRange;
        this.range = minion.range;
        this.timeOfActivationOfSpecialPower = minion.timeOfActivationOfSpecialPower;
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

    public void incrementAp(int unit){
        this.ap += unit;
    }

    public void decrementAp(int unit){
        this.ap -= unit;
    }

    public void incrementHp(int unit){
        this.hp += unit;
    }

    public void decrementHp(int unit){
        this.hp -= unit;
    }

    /*public SpecialPower getSpecialPower() {
        return specialPower;
    }*/

    public static ArrayList<Minion> getMinions() {
        return minions;
    }

    public void setTypeOfHit(int typeOfRange){
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

    public boolean isHoly() {
        return isHoly;
    }

    public void setHoly(boolean holy) {
        isHoly = holy;
    }

    public Minion duplicate() {
        return null;
    }
}

class PersianArcher extends Minion {
    public PersianArcher() {
        super("PersianArcher", 4, 6, 300, 2, 2, 7);
    }

    public PersianArcher(PersianArcher persianArcher) {
        super(persianArcher);
    }

    public Minion duplicate() {
        PersianArcher persianArcher = new PersianArcher(this);
        return persianArcher;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " – Special power : - .";
        return detail;
    }
}

class PersianSwordsman extends Minion {
    public PersianSwordsman() {
        super("PersianSwordsman", 4, 6, 400, 2, 0, 0);
        super.setTimeOfActivationOfSpecialPower(4);
    }

    public PersianSwordsman(PersianSwordsman persianSwordsman) {
        super(persianSwordsman);
    }

    public Minion duplicate() {
        PersianSwordsman persianSwordsman = new PersianSwordsman(this);
        return persianSwordsman;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType()+ " - Name : "+ this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : during attack make power stun for this turn.";
        return detail;
    }
}

class PersianSpear extends Minion {
    public PersianSpear() {
        super("PersianSpear", 3, 5, 500, 1, 2, 3);
    }

    public PersianSpear(PersianSpear persianSpear) {
        super(persianSpear);
    }

    public Minion duplicate() {
        PersianSpear persianSpear = new PersianSpear(this);
        return persianSpear;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : - .";
        return detail;
    }
}

class PersianHorseman extends Minion {
    public PersianHorseman() {
        super("PersianHorseman", 6, 10, 200, 4, 0, 0);
    }

    public PersianHorseman(PersianHorseman persianHorseman) {
        super(persianHorseman);
    }

    public Minion duplicate() {
        PersianHorseman persianHorseman = new PersianHorseman(this);
        return persianHorseman;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : -.";
        return detail;
    }
}

class PersianGladiator extends Minion {
    public PersianGladiator() {
        super("PersianGladiator", 6, 24, 600, 9, 0, 0);
        super.setTimeOfActivationOfSpecialPower(0);
    }

    public PersianGladiator(PersianGladiator persianGladiator) {
        super(persianGladiator);
    }

    public Minion duplicate() {
        PersianGladiator persianGladiator = new PersianGladiator(this);
        return persianGladiator;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : ";
        return detail;
    }
}

class PersianGeneralissimo extends Minion {
    public PersianGeneralissimo() {
        super("PersianGeneralissimo", 4, 12, 800, 7, 0, 0);
        super.setTimeOfActivationOfSpecialPower(2);
    }

    public PersianGeneralissimo(PersianGeneralissimo persianGeneralissimo) {
        super(persianGeneralissimo);
    }

    public Minion duplicate() {
        PersianGeneralissimo persianGeneralissimo = new PersianGeneralissimo(this);
        return persianGeneralissimo;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power :   .";
        return detail;
    }
}

class TuranianArcher extends Minion {
    public TuranianArcher() {
        super("TuranianArcher", 4, 3, 500, 1, 1, 5);
    }

    public TuranianArcher(TuranianArcher turanianArcher) {
        super(turanianArcher);
    }

    public Minion duplicate() {
        TuranianArcher turanianArcher = new TuranianArcher(this);
        return turanianArcher;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType()+ " - Name : "+ this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : -";
        return detail;
    }
}

class TuranianStoneHook extends Minion {
    public TuranianStoneHook() {
        super("TuranianStoneHook", 2, 4, 600, 1, 1, 7);
    }

    public TuranianStoneHook(TuranianStoneHook turanianStoneHook) {
        super(turanianStoneHook);
    }

    public Minion duplicate() {
        TuranianStoneHook turanianStoneHook = new TuranianStoneHook(this);
        return turanianStoneHook;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType()+ " - Name : "+this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : - ";
        return detail;
    }
}

class TuranianSpear extends Minion {
    public TuranianSpear() {
        super("TuranianSpear", 4, 4, 600, 1, 2, 3);
    }

    public TuranianSpear(TuranianSpear turanianSpear) {
        super(turanianSpear);
    }

    public Minion duplicate() {
        TuranianSpear turanianSpear = new TuranianSpear(this);
        return turanianSpear;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType()+ " - Name : "+ this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power :.";
        return detail;
    }
}

class TuranianSpy extends Minion {
    public TuranianSpy() {
        super("TuranianSpy", 6, 6, 700, 4, 0, 0);
        super.setTimeOfActivationOfSpecialPower(0);
    }

    public TuranianSpy(TuranianSpy turanianSpy) {
        super(turanianSpy);
    }

    public Minion duplicate() {
        TuranianSpy turanianSpy = new TuranianSpy(this);
        return turanianSpy;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType()+ " - Name : "+ this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : disarm enemy force for one turn and poison it for 4 turns.";
        return detail;
    }
}

class TuranianSwampy extends Minion {
    public TuranianSwampy() {
        super("TuranianSwampy", 10, 3, 450, 2, 0, 0);
    }

    public TuranianSwampy(TuranianSwampy turanianSwampy) {
        super(turanianSwampy);
    }

    public Minion duplicate() {
        TuranianSwampy turanianSwampy = new TuranianSwampy(this);
        return turanianSwampy;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType()+ " - Name : "+ this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power :- .";
        return detail;
    }
}

class TuranianPrince extends Minion {
    public TuranianPrince() {
        super("TuranianPrince", 10, 6, 800, 6, 0, 0);
        super.setTimeOfActivationOfSpecialPower(2);
    }

    public TuranianPrince(TuranianPrince turanianPrince) {
        super(turanianPrince);
    }

    public Minion duplicate() {
        TuranianPrince turanianPrince = new TuranianPrince(this);
        return turanianPrince;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : "+ this.getType()+ " - Name : "+ this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : .";
        return detail;
    }
}

class BlackBogey extends Minion {
    public BlackBogey() {
        super("BlackBogey", 10, 14, 300, 9, 2, 7);
    }

    public BlackBogey(BlackBogey blackBogey) {
        super(blackBogey);
    }

    public Minion duplicate() {
        BlackBogey blackBogey = new BlackBogey(this);
        return blackBogey;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power :-.";
        return detail;
    }
}

class CatapultGiant extends Minion {
    public CatapultGiant() {
        super("CatapultGiant", 12, 12, 300, 9, 1, 7);
    }

    public CatapultGiant(CatapultGiant catapultGiant) {
        super(catapultGiant);
    }

    public Minion duplicate() {
        CatapultGiant catapultGiant = new CatapultGiant(this);
        return catapultGiant;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power: .";
        return detail;
    }
}

class Eagle extends Minion {
    public Eagle() {
        super("Eagle", 2, 0, 200, 2, 1, 3);
        super.setTimeOfActivationOfSpecialPower(4);
    }

    public Eagle(Eagle eagle) {
        super(eagle);
    }

    public Minion duplicate() {
        Eagle eagle = new Eagle(this);
        return eagle;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power: has power buff with 10 units increasing health.";
        return detail;
    }
}

class HogRiderBogey extends Minion {
    public HogRiderBogey() {
        super("HogRiderBogey", 8, 16, 300, 6, 0, 0);
    }

    public HogRiderBogey(HogRiderBogey hogRiderBogey) {
        super(hogRiderBogey);
    }

    public Minion duplicate() {
        HogRiderBogey hogRiderBogey = new HogRiderBogey(this);
        return hogRiderBogey;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power:    .";
        return detail;
    }
}

class OneEyeGiant extends Minion {
    public OneEyeGiant() {
        super("OneEyeGiant", 11, 12, 500, 7, 2, 3);
        super.setTimeOfActivationOfSpecialPower(3);
    }

    public OneEyeGiant(OneEyeGiant oneEyeGiant) {
        super(oneEyeGiant);
    }

    public Minion duplicate() {
        OneEyeGiant oneEyeGiant = new OneEyeGiant(this);
        return oneEyeGiant;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power: hit the minions in 8 cells around it" +
                " with 2 units hit when its death comes.";
        return detail;
    }
}

class PoisonSnake extends Minion {
    public PoisonSnake() {
        super("PoisonSnake", 6, 5, 300, 4, 1, 4);
        super.setTimeOfActivationOfSpecialPower(0);
    }

    public PoisonSnake(PoisonSnake poisonSnake) {
        super(poisonSnake);
    }

    public Minion duplicate() {
        PoisonSnake poisonSnake = new PoisonSnake(this);
        return poisonSnake;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType()+ " - Name : "+ this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power: poison enemy force until 3 turns.";
        return detail;
    }
}

class FieryDragon extends Minion {
    public FieryDragon() {
        super("FieryDragon", 5, 9, 250, 5, 1, 4);
    }

    public FieryDragon(FieryDragon fieryDragon) {
        super(fieryDragon);
    }

    public Minion duplicate() {
        FieryDragon fieryDragon = new FieryDragon(this);
        return fieryDragon;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power:";
        return detail;
    }
}

class LupinLion extends Minion {
    public LupinLion() {
        super("LupinLion", 8, 1, 600, 2, 0, 0);
        super.setTimeOfActivationOfSpecialPower(0);
    }

    public LupinLion(LupinLion lupinLion) {
        super(lupinLion);
    }

    public Minion duplicate() {
        LupinLion lupinLion = new LupinLion(this);
        return lupinLion;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power: holy buff doesn't have any effect on its attack.";
        return detail;
    }
}

class GiantSnake extends Minion {
    public GiantSnake() {
        super("GiantSnake", 7, 14, 500, 8, 1, 5);
        super.setTimeOfActivationOfSpecialPower(1);
    }

    public GiantSnake(GiantSnake giantSnake) {
        super(giantSnake);
    }

    public Minion duplicate() {
        GiantSnake giantSnake = new GiantSnake(this);
        return giantSnake;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power: minions which have 2 or less than 2 distance" +
                " from it hit 1 more unit while its attack forever.";
        return detail;
    }
}

class WhiteWolf extends Minion {
    public WhiteWolf() {
        super("WhiteWolf", 2, 8, 400, 5, 0, 0);
        super.setTimeOfActivationOfSpecialPower(0);
    }

    public WhiteWolf(WhiteWolf whiteWolf) {
        super(whiteWolf);
    }

    public Minion duplicate() {
        WhiteWolf whiteWolf = new WhiteWolf(this);
        return whiteWolf;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType()+ " - Name : "+ this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power: when it hits a minion in the next turn" +
                " 6 units and the turn next of that 4 units will be diminished from that minion's health.";
        return detail;
    }
}

class Panther extends Minion {
    public Panther() {
        super("Panther", 2, 6, 400, 4, 0, 0);
        super.setTimeOfActivationOfSpecialPower(0);
    }

    public Panther(Panther panther) {
        super(panther);
    }

    public Minion duplicate() {
        Panther panther = new Panther(this);
        return panther;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power: when it hits a minion in the next turn 8" +
                " units will be diminished from that minion's health.";
        return detail;
    }
}

class Wolf extends Minion {
    public Wolf() {
        super("Wolf", 1, 6, 400, 3, 0, 0);
        super.setTimeOfActivationOfSpecialPower(0);
    }

    public Wolf(Wolf wolf) {
        super(wolf);
    }

    public Minion duplicate() {
        Wolf wolf = new Wolf(this);
        return wolf;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : "+ this.getType()+ " - Name : "+ this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power: in the next turn 6 units will be diminished" +
                " from the minion's health.";
        return detail;
    }
}

class Magician extends Minion {
    public Magician() {
        super("Magician", 4, 5, 550, 4, 1, 3);
        super.setTimeOfActivationOfSpecialPower(4);
    }

    public Magician(Magician magician) {
        super(magician);
    }

    public Minion duplicate() {
        Magician magician = new Magician(this);
        return magician;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : gives itself and all the relative minions which" +
                " they are in 8 cells around it a power with 2 units increase of hit power and a weakness with 1 unit decrease of health.";
        return detail;
    }
}

class GiantMagician extends Minion {
    public GiantMagician() {
        super("GiantMagician", 6, 6, 550, 6, 1, 5);
        super.setTimeOfActivationOfSpecialPower(4);
    }

    public GiantMagician(GiantMagician giantMagician) {
        super(giantMagician);
    }

    public Minion duplicate() {
        GiantMagician giantMagician = new GiantMagician(this);
        return giantMagician;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : gives to all relative minions which they're" +
                " in 8 cells around it a power with 2 units increase of hit power and a holy buff.";
        return detail;
    }
}

class Elf extends Minion {
    public Elf() {
        super("Elf", 4, 10, 500, 5, 1, 4);
        super.setTimeOfActivationOfSpecialPower(4);
    }

    public Elf(Elf elf) {
        super(elf);
    }

    public Minion duplicate() {
        Elf elf = new Elf(this);
        return elf;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : gives to all relative minions power buff " +
                "with 1 unit increase of hit power in passive mode.";
        return detail;
    }
}

class WildHog extends Minion {
    public WildHog() {
        super("WildHog", 14, 10, 500, 6, 0, 0);
        super.setTimeOfActivationOfSpecialPower(6);
    }

    public WildHog(WildHog wildHog) {
        super(wildHog);
    }

    public Minion duplicate() {
        WildHog wildHog = new WildHog(this);
        return wildHog;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType()+ " - Name : "+ this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : don't disarm.";
        return detail;
    }
}

class Piran extends Minion {
    public Piran() {
        super("Piran", 12, 20, 400, 8, 0, 0);
        super.setTimeOfActivationOfSpecialPower(6);
    }

    public Piran(Piran piran) {
        super(piran);
    }

    public Minion duplicate() {
        Piran piran = new Piran(this);
        return piran;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType()+ " - Name : "+this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : don't be poisoned.";
        return detail;
    }
}

class Giv extends Minion {
    public Giv() {
        super("Giv", 7, 5, 450, 4, 1, 5);
        super.setTimeOfActivationOfSpecialPower(6);
    }

    public Giv(Giv giv) {
        super(giv);
    }

    public Minion duplicate() {
        Giv giv = new Giv(this);
        return giv;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : don't take negative effect from cards.";
        return detail;
    }
}

class Bahman extends Minion {
    public Bahman() {
        super("Bahman", 9, 16, 450, 8, 0, 0);
        super.setTimeOfActivationOfSpecialPower(1);
    }

    public Bahman(Bahman bahman) {
        super(bahman);
    }

    public Minion duplicate() {
        Bahman bahman = new Bahman(this);
        return bahman;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + super.getName() + "Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : randomly decrease 16 units from the health of " +
                "one of the enemy's minions.";
        return detail;
    }
}

class Ashkbous extends Minion {
    public Ashkbous() {
        super("Ashkbous", 8, 14, 400, 7, 0, 0);
        super.setTimeOfActivationOfSpecialPower(6);
    }

    public Ashkbous(Ashkbous ashkbous) {
        super(ashkbous);
    }

    public Minion duplicate() {
        Ashkbous ashkbous = new Ashkbous(this);
        return ashkbous;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : don't be attacked from forces that " +
                "have less health than it.";
        return detail;
    }
}

class Iraj extends Minion {
    public Iraj() {
        super("Iraj", 20, 6, 500, 4, 1, 3);
    }

    public Iraj(Iraj iraj) {
        super(iraj);
    }

    public Minion duplicate() {
        Iraj iraj = new Iraj(this);
        return iraj;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power :  .";
        return detail;
    }
}

class GiantColossus extends Minion {
    public GiantColossus() {
        super("GiantColossus", 8, 30, 600, 9, 2, 2);
    }

    public GiantColossus(GiantColossus giantColossus) {
        super(giantColossus);
    }

    public Minion duplicate() {
        GiantColossus giantColossus = new GiantColossus(this);
        return giantColossus;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power: - .";
        return detail;
    }
}

class TwoHeadGiant extends Minion {
    public TwoHeadGiant() {
        super("TwoHeadGiant", 4, 10, 550, 4, 0, 0);
        super.setTimeOfActivationOfSpecialPower(4);
    }

    public TwoHeadGiant(TwoHeadGiant twoHeadGiant) {
        super(twoHeadGiant);
    }

    public Minion duplicate() {
        TwoHeadGiant twoHeadGiant = new TwoHeadGiant(this);
        return twoHeadGiant;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType()+ " - Name : "+ this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : deactivate all the positive effects of" +
                " every force that this minion attack to it.";
        return detail;
    }
}

class ColdGrandma extends Minion {
    public ColdGrandma() {
        super("ColdGrandma", 4, 3, 500, 3, 1, 5);
        super.setTimeOfActivationOfSpecialPower(1);
    }

    public ColdGrandma(ColdGrandma coldGrandma) {
        super(coldGrandma);
    }

    public Minion duplicate() {
        ColdGrandma coldGrandma = new ColdGrandma(this);
        return coldGrandma;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : enemy minions which are in 8 cells around it" +
                " will be stun for a turn.";
        return detail;
    }
}

class SteelArmor extends Minion {
    public SteelArmor() {
        super("SteelArmor", 1, 1, 650, 3, 0, 0);
        super.setTimeOfActivationOfSpecialPower(1);
    }

    public SteelArmor(SteelArmor steelArmor) {
        super(steelArmor);
    }

    public Minion duplicate() {
        SteelArmor steelArmor = new SteelArmor(this);
        return steelArmor;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType()+ " - Name : "+ this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : change itself randomly to one of the " +
                "enemy minions.";
        return detail;
    }
}

class Siavash extends Minion {
    public Siavash() {
        super("Siavash", 5, 8, 350, 4, 0, 0);
        super.setTimeOfActivationOfSpecialPower(3);
    }

    public Siavash(Siavash siavash) {
        super(siavash);
    }

    public Minion duplicate() {
        Siavash siavash = new Siavash(this);
        return siavash;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType()+ " - Name : "+ this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power : when its death comes it hits enemy's" +
                " hero with 6 units hit.";
        return detail;
    }
}

class GiantKing extends Minion {
    public GiantKing() {
        super("GiantKing", 4, 10, 600, 5, 0, 0);
        super.setTimeOfActivationOfSpecialPower(2);
    }

    public GiantKing(GiantKing giantKing) {
        super(giantKing);
    }

    public Minion duplicate() {
        GiantKing giantKing = new GiantKing(this);
        return giantKing;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power:  .";
        return detail;
    }
}

class ArzhangBogey extends Minion {
    public ArzhangBogey() {
        super("ArzhangBogey", 6, 6, 600, 3, 0, 0);
        super.setTimeOfActivationOfSpecialPower(2);
    }

    public ArzhangBogey(ArzhangBogey arzhangBogey) {
        super(arzhangBogey);
    }

    public Minion duplicate() {
        ArzhangBogey arzhangBogey = new ArzhangBogey(this);
        return arzhangBogey;
    }

    @Override
    public String showDetails() {
        String detail;
        detail = "Type : " + this.getType() + " - Name : " + this.getName() + " - AP : " + this.getAp() + " - HP : " + this.getHp()
                + " - MP : " + this.getCostToUse() + " - Class : " + this.getTypeOfHit() + " - Special power:.";
        return detail;
    }
}