package model.Item;

import java.util.ArrayList;

public abstract class CollectableItem extends Item {
    private static ArrayList<CollectableItem> collectableItems = new ArrayList<>();

    static {
        new BladesOfAgility();
        new ChineseSword();
        new DeathCurse();
        new Devastation();
        new DoubleEntendreArrow();
        new Elexir();
        new ManaElectuary();
        new PerpetuityElectuary();
        new RandomDamage();
    }

    public CollectableItem(String name) {
        this.setName(name);
        collectableItems.add(this);
    }

    public CollectableItem(CollectableItem collectableItem) {
        this.setName(collectableItem.getName());
    }

    public static ArrayList<CollectableItem> getCollectableItems() {
        return collectableItems;
    }

    public CollectableItem duplicate() {
        return null;
    }
}

enum CollectableItemWork {
    DEVASTATION("Increase 6HP a force"),
    DOUBLE_ENTENDRE_ARROW("Increase 2AP of a ranged or hybrid force"),
    ELEXIR("Increase 3HP and apply 1 powerBuff and add 3AP for minion"),
    MANA_ELECTUARY("Increase mana 3units in the next turn"),
    PERPETUITY_ELECTUARY("Apply 10 holyBuff for insider accident force for 2 turn"),
    DEATH_CURSE("Give a ability to a accident minion that enter 8 hit to a random force that in the nearest distance to it"),
    RANDOM_DAMAGE("Give 2AP to a random force"),
    BLADES_OF_AGILITY("add 6AP to a random force"),
    CHINESE_SWORD("add 5AP to the melee forces");
    private String effect;
    public String getMessage() {
        return effect;
    }
    CollectableItemWork(String effect) {
        this.effect = effect;
    }

}

class Devastation extends CollectableItem {

    public Devastation() {
        super("Devastation");
    }

    public Devastation(Devastation devastation) {
        super(devastation);
    }

    public CollectableItem duplicate() {
        Devastation devastation = new Devastation(this);
        return devastation;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectableItemWork.DEVASTATION.getMessage();
        return details;
    }
}

class DoubleEntendreArrow extends CollectableItem {

    public DoubleEntendreArrow() {
        super("DoubleEntendreArrow");
    }

    public DoubleEntendreArrow(DoubleEntendreArrow doubleEntendreArrow) {
        super(doubleEntendreArrow);
    }

    public CollectableItem duplicate() {
        DoubleEntendreArrow doubleEntendreArrow = new DoubleEntendreArrow(this);
        return doubleEntendreArrow;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectableItemWork.DOUBLE_ENTENDRE_ARROW.getMessage();
        return details;
    }
}

class Elexir extends CollectableItem {

    public Elexir() {
        super("Elexir");
    }

    public Elexir(Elexir elexir) {
        super(elexir);
    }

    public CollectableItem duplicate() {
        Elexir elexir = new Elexir(this);
        return elexir;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectableItemWork.ELEXIR.getMessage();
        return details;
    }
}

class ManaElectuary extends CollectableItem {

    public ManaElectuary() {
        super("ManaElectuary");
    }

    public ManaElectuary(ManaElectuary manaElectuary) {
        super(manaElectuary);
    }

    public CollectableItem duplicate() {
        ManaElectuary manaElectuary = new ManaElectuary(this);
        return manaElectuary;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectableItemWork.MANA_ELECTUARY.getMessage();
        return details;
    }
}

class PerpetuityElectuary extends CollectableItem {

    public PerpetuityElectuary() {
        super("PerpetuityElectuary");
    }

    public PerpetuityElectuary(PerpetuityElectuary perpetuityElectuary) {
        super(perpetuityElectuary);
    }

    public CollectableItem duplicate() {
        PerpetuityElectuary perpetuityElectuary = new PerpetuityElectuary(this);
        return perpetuityElectuary;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectableItemWork.PERPETUITY_ELECTUARY.getMessage();
        return details;
    }
}

class DeathCurse extends CollectableItem {

    public DeathCurse() {
        super("DeathCurse");
    }

    public DeathCurse(DeathCurse deathCurse) {
        super(deathCurse);
    }

    public CollectableItem duplicate() {
        DeathCurse deathCurse = new DeathCurse(this);
        return deathCurse;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectableItemWork.DEATH_CURSE.getMessage();
        return details;
    }
}

class RandomDamage extends CollectableItem {

    public RandomDamage() {
        super("RandomDamage");
    }

    public RandomDamage(RandomDamage randomDamage) {
        super(randomDamage);
    }

    public CollectableItem duplicate() {
        RandomDamage randomDamage = new RandomDamage(this);
        return randomDamage;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectableItemWork.RANDOM_DAMAGE.getMessage();
        return details;
    }
}

class BladesOfAgility extends CollectableItem {

    public BladesOfAgility() {
        super("BladesOfAgility");
    }

    public BladesOfAgility(BladesOfAgility bladesOfAgility) {
        super(bladesOfAgility);
    }

    public CollectableItem duplicate() {
        BladesOfAgility bladesOfAgility = new BladesOfAgility(this);
        return bladesOfAgility;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectableItemWork.BLADES_OF_AGILITY.getMessage();
        return details;
    }
}

class ChineseSword extends CollectableItem {

    public ChineseSword() {
        super("chineseSword");
    }

    public ChineseSword(ChineseSword chineseSword) {
        super(chineseSword);
    }

    public CollectableItem duplicate() {
        ChineseSword chineseSword = new ChineseSword(this);
        return chineseSword;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectableItemWork.CHINESE_SWORD.getMessage();
        return details;
    }
}
