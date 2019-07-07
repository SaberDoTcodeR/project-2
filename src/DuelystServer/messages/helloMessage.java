package DuelystServer.messages;

public class helloMessage {
    private String hello = "hello";
    private int messageId = 65432;

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

}
