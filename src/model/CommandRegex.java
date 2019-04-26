package model;

public enum CommandRegex {
    GAME_INFO(
            "^game info$"
            ),
    SHOW_OPP_MINIONS(
            "^game info$"),
    SHOW_MY_MINIONS(
            "^show opponent minions$"
    ),
    START_GAME(
            "^start game\\s+(\\w+)\\s+([1-3])\\s+(\\d+)?$"//todo checked
    )
    ,SELECT_USER(
            "^select user\\s+(\\w+)$"
    ),START_MULTIPLAYER_GAME(
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
