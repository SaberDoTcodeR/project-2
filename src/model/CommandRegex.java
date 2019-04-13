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
    STATS_OF_TEAM(
            "^print stats of team\\s+(\\w+)$"
    ),
    STATS_OF_PLAYER(
            "^print stats of player\\s+(\\w+)\\s+(\\w+)$"
    ),
    RENEW_CONTRACT(
            "^renew contract of\\s+(\\w+)\\s+(\\w+)\\s+for\\s+(\\d+)\\s+years$"
    ),
    TERMINATE_CONTRACT(
            "^terminate contract of\\s+(\\w+)\\s+(\\w+)$"
    ),
    SELL_PLAYER(
            "^sell player\\s+(\\w+)\\s+(\\w+)\\s+from\\s+(\\w+)\\s+to\\s+(\\w+)\\s+for\\s+(\\d+)\\$\\s+with\\s+(\\d+)\\s+years contract$"
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
