package model;

public enum CommandRegex {
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
    CREATE_ACCOUNT (
            "^create account\\s+(\\w+)$"
    ),
    LOGIN (
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
    );

    String regex;

    CommandRegex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
