package DuelystClient.Messages;

public class AuctionStartMessage {
    private int id = 53645;
    private String cardData;
    private Long starterAuthToken;

    public Long getStarterAuthToken() {
        return starterAuthToken;
    }

    public void setStarterAuthToken(Long starterAuthToken) {
        this.starterAuthToken = starterAuthToken;
    }

    public String getCardData() {
        return cardData;
    }

    public void setCardData(String cardData) {
        this.cardData = cardData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
