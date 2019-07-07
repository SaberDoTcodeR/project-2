package DuelystClient.Messages;

public class GameRequest {
    private  int id=72386;
    private boolean cancel;

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    public long getAuthToken() {
        return authToken;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthToken(long authToken) {
        this.authToken = authToken;
    }

    private long authToken;

}
