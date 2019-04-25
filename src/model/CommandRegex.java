package model;

public enum CommandRegex {
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
            "^add\\s+(\\w+)\\s+to deck\\s+(\\w+)$"
    ),
    REMOVE(
            "^remove\\s+(\\w+)\\s+from deck\\s+(\\w+)$"
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
    LOAN_PLAYER(
            "^loan player\\s+(\\w+)\\s+(\\w+)\\s+from\\s+(\\w+)\\s+to\\s+(\\w+)\\s+with\\s+(\\d+)\\s+years contract$"
    ),
    PUT_IN_SQUAD(
            "^put player\\s+(\\w+)\\s+(\\w+)\\s+from\\s+(\\w+)\\s+in main squad$"
    ),
    FRIENDLY_MATCH(
            "^friendly match between\\s+(\\w+)\\s+and\\s+(\\w+)$"
    ),
    NEXT_SEASON(
            "^next season$"
    ),
    END(
            "^end$"
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
