package model;

public abstract class Battle {
    private Account firstPlayer;
    private Deck firstPlayerDeck=new Deck();
    private Deck secondPlayerDeck=new Deck();
    protected Battle(Account firstPlayer,Deck deck,Deck deck2){
        this.firstPlayer=firstPlayer;
        this.firstPlayerDeck=deck;
        this.secondPlayerDeck=deck2;
    }
}
class HeroBattle extends Battle{
    private boolean playWithAI;
    private Account secondPlayer;
    public HeroBattle(Deck opponentDeck,Deck myDeck,Account player){
        super(player,myDeck,opponentDeck);
        this.playWithAI=true;
    }
    public HeroBattle(Deck opponentDeck,Deck myDeck,Account player,Account player2){
        super(player,myDeck,opponentDeck);
        this.secondPlayer=player2;
        this.playWithAI=false;
    }
}
class OneFlagBattle extends Battle{
    private boolean playWithAI;
    private Account secondPlayer;
    public OneFlagBattle(Deck opponentDeck,Deck myDeck,Account player){
        super(player,myDeck,opponentDeck);
        this.playWithAI=true;
    }
    public OneFlagBattle(Deck opponentDeck,Deck myDeck,Account player,Account player2){
        super(player,myDeck,opponentDeck);
        this.secondPlayer=player2;
        this.playWithAI=false;
    }
}
class FlagsBattle extends Battle{
    private boolean playWithAI;
    private Account secondPlayer;
    private int flags;
    public FlagsBattle(Deck opponentDeck,Deck myDeck,Account player,int flags){
        super(player,myDeck,opponentDeck);
        this.playWithAI=true;
        this.flags=flags;
    }
    public FlagsBattle(Deck opponentDeck,Deck myDeck,Account player,Account player2,int flags){
        super(player,myDeck,opponentDeck);
        this.secondPlayer=player2;
        this.playWithAI=false;
        this.flags=flags;
    }
}