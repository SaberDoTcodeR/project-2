package DuelystServer.model.Item.CollectibleItem;

public enum CollectibleItemWork {
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
