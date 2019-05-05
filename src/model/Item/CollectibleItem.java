package model.Item;

import model.Battles.Battle;
import model.Buffs.ChangeHpBuff;
import model.Buffs.HolyBuff;
import model.Buffs.ManaItemBuff;
import model.Buffs.PowerBuff;
import model.Cards.Hero;
import model.Cards.Minion;
import model.Cell;
import model.Menus.Account;
import view.Request;

import java.util.ArrayList;
import java.util.Random;

public abstract class CollectibleItem extends Item {
    private static ArrayList<CollectibleItem> collectibleItems = new ArrayList<>();
    private String cardId;

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

    public abstract void applyEffect(Battle battle, Cell cell, Account player);

    public CollectibleItem(String name) {
        this.setName(name);
        collectibleItems.add(this);
    }

    public void cardIdGenerator(Battle battle) {
        ArrayList<CollectibleItem> collectibleItems;
        String playerName;
        if (battle.getTurn() % 2 == 1) {
            playerName = battle.getFirstPlayer().getUserName();
            collectibleItems = battle.getFirstPlayerCollectibleItem();
        } else {
            collectibleItems = battle.getSecondPlayerCollectibleItem();
            playerName = battle.getSecondPlayer().getUserName();
        }

        int count = 1;
        for (CollectibleItem collectibleItem : collectibleItems) {
            if (collectibleItem.getName().equals(this.getName())) {
                count++;
            }
        }
        String str = playerName + "_" + this.getName() + "_" + (count);
        setCardId(str);
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }


    public String getCardId() {
        return cardId;
    }

    public CollectibleItem(CollectibleItem collectibleItem) {
        this.setName(collectibleItem.getName());
    }

    public static ArrayList<CollectibleItem> getCollectibleItems() {
        return collectibleItems;
    }

    public CollectibleItem duplicate() {
        return null;
    }
}

enum CollectibleItemWork {
    DEVASTATION("Increase 6HP a force"),
    DOUBLE_ENTENDRE_ARROW("Increase 2AP of a ranged or hybrid force"),
    ELIXIR("Increase 3HP and apply 1 powerBuff and add 3AP for minion"),
    MANA_ELECTUARY("Increase mana 3 units in the next turn"),
    PERPETUITY_ELECTUARY("Apply 10 holyBuff for insider accident force for 2 turn"),
    DEATH_CURSE("Give a ability to a accident minion that enter 8 hit to a random force that in the nearest distance to it"),
    RANDOM_DAMAGE("Give 2AP to a random force"),
    BLADES_OF_AGILITY("add 6AP to a random force"),
    CHINESE_SWORD("add 5AP to the melee forces");
    private String effect;

    public String getMessage() {
        return effect;
    }

    CollectibleItemWork(String effect) {
        this.effect = effect;
    }

}

class Devastation extends CollectibleItem {

    public Devastation() {
        super("Devastation");
    }

    public Devastation(Devastation devastation) {
        super(devastation);
    }

    /*
     * cell : no different
     * player : the player who has the item
     * activeTime : no different
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player) {
        Cell insiderCell = getRandomInsiderForce(battle, player);
        if (insiderCell.getMinion() != null) {
            cell.getMinion().incrementHp(6);
        }
        if (insiderCell.getHero() != null) {
            cell.getHero().incrementHp(6);
        }
    }

    public CollectibleItem duplicate() {
        Devastation devastation = new Devastation(this);
        return devastation;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectibleItemWork.DEVASTATION.getMessage();
        return details;
    }
}

class DoubleEntendreArrow extends CollectibleItem {

    public DoubleEntendreArrow() {
        super("DoubleEntendreArrow");
    }

    public DoubleEntendreArrow(DoubleEntendreArrow doubleEntendreArrow) {
        super(doubleEntendreArrow);
    }

    /*
     * cell : no different
     * player : the player who has the item
     * activeTime : no different
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player) {
        Cell insiderCell = getRandomForce(battle, player);
        if (insiderCell.getHero() != null)
            insiderCell.getHero().incrementAp(2);
        if (insiderCell.getMinion() != null)
            insiderCell.getMinion().incrementAp(2);
    }

    private Cell getRandomForce(Battle battle, Account player) {
        ArrayList<Cell> insiderCells = new ArrayList<>();
        if (battle.getFirstPlayer().getUserName().equals(player.getUserName())) { // Insider is firstPlayer
            addCellToList(battle, insiderCells, battle.getFirstPlayer());
        } else { // Insider is secondPlayer
            addCellToList(battle, insiderCells, battle.getSecondPlayer());
        }
        Random random = new Random(insiderCells.size() - 1);
        return insiderCells.get(random.nextInt());
    }

    private void addCellToList(Battle battle, ArrayList<Cell> cells, Account player) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (battle.getMap().get(i).get(j).getHero() != null &&
                        player.getMainDeck().isContain(battle.getMap().get(i).get(j).getHero()) &&
                        checkRightType(battle.getMap().get(i).get(j)))
                    cells.add(battle.getMap().get(i).get(j));
                if (battle.getMap().get(i).get(j).getMinion() != null &&
                        player.getMainDeck().isContain(battle.getMap().get(i).get(j).getMinion()) &&
                        checkRightType(battle.getMap().get(i).get(j)))
                    cells.add(battle.getMap().get(i).get(j));
            }
        }
    }

    private boolean checkRightType(Cell cell) {
        if (cell.getHero() != null)
            if (cell.getHero().getTypeOfHit().equals("Hybrid") ||
                    cell.getHero().getTypeOfHit().equals("Ranged"))
                return true;
        if (cell.getMinion() != null)
            if (cell.getMinion().getTypeOfHit().equals("Hybrid") ||
                    cell.getMinion().getTypeOfHit().equals("Ranged"))
                return true;
        return false;
    }

    public CollectibleItem duplicate() {
        DoubleEntendreArrow doubleEntendreArrow = new DoubleEntendreArrow(this);
        return doubleEntendreArrow;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectibleItemWork.DOUBLE_ENTENDRE_ARROW.getMessage();
        return details;
    }
}

class Elexir extends CollectibleItem {

    public Elexir() {
        super("Elexir");
    }

    public Elexir(Elexir elexir) {
        super(elexir);
    }

    /*
     * cell : no different
     * player : the player who has the item
     * activeTime : no different
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player) {
        Cell insiderCell = getRandomInsiderForce(battle, player);
        while (insiderCell.getMinion() == null) {
            insiderCell = getRandomInsiderForce(battle, player);
        }
        if (insiderCell.getMinion() != null) {
            insiderCell.getMinion().incrementHp(3);
            PowerBuff powerBuff = new PowerBuff(3, true);
            powerBuff.setCasting(powerBuff, null, null, insiderCell.getMinion());
            powerBuff.setTurnCounter(-5);
            powerBuff.incrementAp(insiderCell.getMinion());
            insiderCell.getMinion().getOwnBuffs().add(powerBuff);
        }

    }

    public CollectibleItem duplicate() {
        Elexir elexir = new Elexir(this);
        return elexir;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectibleItemWork.ELIXIR.getMessage();
        return details;
    }
}

class ManaElectuary extends CollectibleItem {

    public ManaElectuary() {
        super("ManaElectuary");
    }

    public ManaElectuary(ManaElectuary manaElectuary) {
        super(manaElectuary);
    }

    /*
     * cell :
     * player :
     * activeTime :
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player) {
        ManaItemBuff manaItemBuff = new ManaItemBuff(player, 3);
        manaItemBuff.setTurnCounter(1);
        player.getOwnBuffs().add(manaItemBuff);
    }

    public CollectibleItem duplicate() {
        ManaElectuary manaElectuary = new ManaElectuary(this);
        return manaElectuary;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectibleItemWork.MANA_ELECTUARY.getMessage();
        return details;
    }
}

class PerpetuityElectuary extends CollectibleItem {

    public PerpetuityElectuary() {
        super("PerpetuityElectuary");
    }

    public PerpetuityElectuary(PerpetuityElectuary perpetuityElectuary) {
        super(perpetuityElectuary);
    }

    /*
     * cell : no different
     * player : player who has the item
     * activeTime : no different
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player) {
        Cell insiderCell = getRandomInsiderForce(battle, player);
        if (insiderCell.getHero() != null) {
            for (int i = 0; i < 10; i++) {
                HolyBuff holyBuff = new HolyBuff();
                holyBuff.setCasting(holyBuff, null, insiderCell.getHero(), null);
                holyBuff.setTurnCounter(1);
                holyBuff.holy(insiderCell.getHero());
                insiderCell.getHero().getOwnBuffs().add(holyBuff);
            }
        }
        if (insiderCell.getMinion() != null) {
            for (int i = 0; i < 10; i++) {
                HolyBuff holyBuff = new HolyBuff();
                holyBuff.setCasting(holyBuff, null, null, insiderCell.getMinion());
                holyBuff.setTurnCounter(1);
                holyBuff.holy(insiderCell.getMinion());
                insiderCell.getMinion().getOwnBuffs().add(holyBuff);
            }
        }
    }

    public CollectibleItem duplicate() {
        PerpetuityElectuary perpetuityElectuary = new PerpetuityElectuary(this);
        return perpetuityElectuary;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectibleItemWork.PERPETUITY_ELECTUARY.getMessage();
        return details;
    }
}

class DeathCurse extends CollectibleItem {

    public DeathCurse() {
        super("DeathCurse");
    }

    public DeathCurse(DeathCurse deathCurse) {
        super(deathCurse);
    }

    /*
     * cell : no different
     * player : the player who has the item
     * activeTime : 2 --> on Death
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player) {
        Cell insiderCell = getRandomInsiderForce(battle, player);
        while (insiderCell.getMinion() == null) {
            insiderCell = getRandomInsiderForce(battle, player);
        }
        insiderCell.getMinion().setDeathCurse(true);
    }

    @Override
    public CollectibleItem duplicate() {
        DeathCurse deathCurse = new DeathCurse(this);
        return deathCurse;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectibleItemWork.DEATH_CURSE.getMessage();
        return details;
    }
}

class RandomDamage extends CollectibleItem {

    public RandomDamage() {
        super("RandomDamage");
    }

    public RandomDamage(RandomDamage randomDamage) {
        super(randomDamage);
    }

    /*
     * cell : no different
     * player : the player who has the item
     * activeTime : no different
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player) {
        Cell insiderCell = getRandomInsiderForce(battle, player);
        if (insiderCell.getHero() != null) {
            insiderCell.getHero().incrementAp(2);
        }
        if (insiderCell.getMinion() != null)
            insiderCell.getMinion().incrementAp(2);
    }

    @Override
    public CollectibleItem duplicate() {
        RandomDamage randomDamage = new RandomDamage(this);
        return randomDamage;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectibleItemWork.RANDOM_DAMAGE.getMessage();
        return details;
    }
}

class BladesOfAgility extends CollectibleItem {

    public BladesOfAgility() {
        super("BladesOfAgility");
    }

    public BladesOfAgility(BladesOfAgility bladesOfAgility) {
        super(bladesOfAgility);
    }

    /*
     * cell : no different
     * player : the player who has the item
     * activeTime : no different
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player) {
        Cell insiderCell = getRandomInsiderForce(battle, player);
        if (insiderCell.getHero() != null) {
            insiderCell.getHero().incrementAp(6);
        }
        if (insiderCell.getMinion() != null) {
            insiderCell.getMinion().incrementAp(6);
        }
    }

    @Override
    public CollectibleItem duplicate() {
        BladesOfAgility bladesOfAgility = new BladesOfAgility(this);
        return bladesOfAgility;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectibleItemWork.BLADES_OF_AGILITY.getMessage();
        return details;
    }
}

class ChineseSword extends CollectibleItem {

    public ChineseSword() {
        super("chineseSword");
    }

    public ChineseSword(ChineseSword chineseSword) {
        super(chineseSword);
    }

    /*
     * cell : no different
     * player : the player who has the item
     * activeTime : no different
     * */
    @Override
    public void applyEffect(Battle battle, Cell cell, Account player) {
        ArrayList<Cell> meleeForces = getRandomForce(battle, player);
        for (Cell newCell : meleeForces) {
            if (newCell.getHero() != null) {
                newCell.getHero().incrementAp(5);
            }
            if (newCell.getMinion() != null) {
                newCell.getMinion().incrementAp(5);
            }
        }
    }

    private ArrayList<Cell> getRandomForce(Battle battle, Account player) {
        ArrayList<Cell> enemyCells = new ArrayList<>();
        if (battle.getSecondPlayer().getUserName().equals(player.getUserName())) { // Insider is secondPlayer
            addCellToList(battle, enemyCells, battle.getSecondPlayer());
        } else { // Insider is firstPlayer
            addCellToList(battle, enemyCells, battle.getFirstPlayer());
        }
        return enemyCells;
    }

    private void addCellToList(Battle battle, ArrayList<Cell> cells, Account player) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (battle.getMap().get(i).get(j).getHero() != null &&
                        player.getMainDeck().isContain(battle.getMap().get(i).get(j).getHero()) &&
                        battle.getMap().get(i).get(j).getHero().getTypeOfHit().equals("Melee"))
                    cells.add(battle.getMap().get(i).get(j));
                if (battle.getMap().get(i).get(j).getMinion() != null &&
                        player.getMainDeck().isContain(battle.getMap().get(i).get(j).getMinion()) &&
                        battle.getMap().get(i).get(j).getHero().getTypeOfHit().equals("Melee"))
                    cells.add(battle.getMap().get(i).get(j));
            }
        }
    }

    @Override
    public CollectibleItem duplicate() {
        ChineseSword chineseSword = new ChineseSword(this);
        return chineseSword;
    }

    @Override
    public String showDetails() {
        String details;
        details = "Name : " + this.getClass().getSimpleName() +
                " - Desc: " + CollectibleItemWork.CHINESE_SWORD.getMessage();
        return details;
    }
}
