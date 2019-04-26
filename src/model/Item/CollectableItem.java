package model.Item;

import java.util.ArrayList;

public abstract class CollectableItem extends Item {

    public CollectableItem(String name) {
        this.setName(name);
    }

    public CollectableItem(CollectableItem collectableItem) {
        this.setName(collectableItem.getName());
    }

    private static ArrayList<CollectableItem> collectableItems = new ArrayList<>();

    public static ArrayList<CollectableItem> getCollectableItems() {
        return collectableItems;
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

    CollectableItemWork(String effect) {
        this.effect = effect;
    }

}

class Devastation extends CollectableItem {

    public Devastation(String name) {
        super(name);
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
                " - Desc: " + CollectableItemWork.DEVASTATION;
        return details;
    }
}

class DoubleEntendreArrow extends CollectableItem {

    public DoubleEntendreArrow(String name) {
        super(name);
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
                " - Desc: " + CollectableItemWork.DOUBLE_ENTENDRE_ARROW;
        return details;
    }
}

class Elexir extends CollectableItem {

    public Elexir(String name) {
        super(name);
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
                " - Desc: " + CollectableItemWork.ELEXIR;
        return details;
    }
}

class ManaElectuary extends CollectableItem {

    public ManaElectuary(String name) {
        super(name);
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
                " - Desc: " + CollectableItemWork.MANA_ELECTUARY;
        return details;
    }
}

class PerpetuityElectuary extends CollectableItem {

    public PerpetuityElectuary(String name) {
        super(name);
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
                " - Desc: " + CollectableItemWork.PERPETUITY_ELECTUARY;
        return details;
    }
}

class DeathCurse extends CollectableItem {

    public DeathCurse(String name) {
        super(name);
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
                " - Desc: " + CollectableItemWork.DEATH_CURSE;
        return details;
    }
}

class RandomDamage extends CollectableItem {

    public RandomDamage(String name) {
        super(name);
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
                " - Desc: " + CollectableItemWork.RANDOM_DAMAGE;
        return details;
    }
}

class BladesOfAgility extends CollectableItem {

    public BladesOfAgility(String name) {
        super(name);
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
                " - Desc: " + CollectableItemWork.BLADES_OF_AGILITY;
        return details;
    }
}

class ChineseSword extends CollectableItem {

    public ChineseSword(String name) {
        super(name);
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
                " - Desc: " + CollectableItemWork.CHINESE_SWORD;
        return details;
    }
}
