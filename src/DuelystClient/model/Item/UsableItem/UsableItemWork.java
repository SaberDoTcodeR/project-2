package DuelystClient.model.Item.UsableItem;

public enum UsableItemWork {
    CROWN_OF_WISDOM("Increase mana in 3 first turns"),
    SHAME_EMBLEM("Active 12 holyBuff in insider force"),
    DAMOL_ARCHERY("Insider force can disarm enemy force's hit in ranged and hybrid mood"),
    SIMORGH_PLUME("Reduce 2Ap of enemy force's hit in hybrid and ranged mood"),
    TERROR_HOOD("in its hit, apply weaknessBuff and reduce 2AP on enemy accident force for 1 turn"),
    KING_WISDOM("Increase mana 1unit in all turns"),
    ASSASSINATION_DAGGER("Hit enemy Hero 1AP when you put it"),
    POISONOUS_DAGGER("apply poisonBuff on enemy accident force for 1 turn when insider force hitting"),
    SHOCK_HAMMER("Insider hero disarm enemy force for 1 turn whenr hitting"),
    SOUL_EATER("when insider force die,apply a power buff and 1AP on an insider force"),
    BAPTISM("Any minion when spawning,get holyBuff for 2 turns");
    private String effect;

    public String getMessage() {
        return effect;
    }

    UsableItemWork(String effect) {
        this.effect = effect;
    }

}
