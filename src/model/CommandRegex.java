package model;

public enum CommandRegex {
    SHOW_RECORDED_MATCH("show recorded match"),
    END_GAME("end game"),
    USE_COLLECTIBLE("use \\(([1-5]),([1-9])\\)$"),

    SHOW_INFO("^show info$"),

    SELECT_COLLECTIBLE("^select collectible\\s+(\\w+)$"),

    SHOW_COLLECTIBLES("^show collectibles$"),

    SHOW_CARDS("^show cards$"),

    ENTER_GRAVE_YARD("^enter graveyard$"),

    SHOW_NEXT_CARD("^show next card$"),

    SPECIAL_POWER("^use special power \\(([1-5]),([1-9])\\)$"),

    ATTACK_COMBO("^attack combo\\s+((\\w+)?\\s)+$"),//todo check

    ATTACK("^attack\\s+(\\w+)$"),

    INSERT_CARD("^insert\\s+(\\w+)\\s+in\\s+\\(([1-5]),([1-9])\\)$"),

    SHOW_HAND("^show hand$"),

    MOVE_CARD(
            "^move to\\s+\\(([1-5]),([1-9])\\)$"
    ),

    SELECT_CARD_ID(
            "^select\\s+(\\w+)$"),

    GAME_INFO(
            "^game info$"
    ),

    SHOW_OPP_MINIONS(
            "^show opponent minions$"),

    END_TURN(
            "^end turn"
    ),

    SHOW_CARD_INFO(
            "^show card info\\s+(\\w+)$"),

    SHOW_MY_MINIONS(
            "^show my minions$"
    ),

    START_GAME(
            "^start game\\s+(\\w+)\\s+([1-3])\\s+(\\d+)?$"//todo checked
    ), SELECT_USER(
            "^select user\\s+(\\w+)$"
    ),

    START_MULTIPLAYER_GAME(
            "^start multiplayer game\\s+([1-3])\\s+(\\d+)?$"//todo checked
    ),

    SHOW(
            "^show$"
    ),

    SEARCH(
            "^search\\s+(\\w+)$"
    ),

    CREATE_DECK(
            "^create deck\\s+(\\w+)$"
    ),

    DELETE_DECK(
            "^delete deck\\s+(\\w+)$"
    ),

    ADD(
            "^add\\s+(\\d+)\\s+to deck\\s+(\\w+)$"
    ),

    REMOVE(
            "^remove\\s+(\\d+)\\s+from deck\\s+(\\w+)$"
    ),

    VALIDATE_DECK(
            "^validate deck\\s+(\\w+)$"
    ),

    SELECT_DECK(
            "^select deck\\s+(\\w+)$"
    ),

    SHOW_ALL_DECKS(
            "^show all decks$"
    ),

    SHOW_DECK(
            "^show deck\\s+(\\w+)$"
    ),

    ENTER_COLLECTION(
            "^enter collection$"
    ),

    ENTER_BATTLE(
            "^enter battle$"
    ),

    ENTER_SHOP(
            "^enter shop$"
    ),

    EXIT(
            "^exit$"
    ),

    HELP(
            "^help$"
    ),

    CREATE_ACCOUNT(
            "^create account\\s+(\\w+)$"
    ),

    LOGIN(
            "^login\\s+(\\w+)$"
    ),

    SHOW_LEADERBOARD(
            "^show leaderboard$"
    ),

    SAVE(
            "^save$"
    ),

    LOGOUT(
            "^logout$"
    ),

    SHOW_COLLECTION(
            "^show collection$"
    ),

    SEARCH_COLLECTION(
            "^search collection\\s+(\\w+)$"
    ),

    BUY(
            "^buy\\s+(\\w+)$"
    ),

    SELL(
            "^sell\\s+(\\d+)$"
    );

    String regex;

    CommandRegex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
