package DuelystServer.messages;

import DuelystServer.model.Account;
import com.google.gson.Gson;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Date;

public class AuctionStartMessage {
    private int id = 53645;
    private String cardData;
    private Long starterAuthToken;
    public static ArrayList<BidMessage> bids = new ArrayList<>();
    public transient long time = new Date().getTime();


    public static void addBid(BidMessage bidMessage) {
        boolean flag = false;
        for (BidMessage bid : bids) {
            System.out.println();
            if (bid.getText().getKey() == bidMessage.getText().getKey()) {
                bids.remove(bid);
                bids.add(bidMessage);
                flag = true;
            }
        }
        if (!flag) {
            bids.add(bidMessage);
        }
    }

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
