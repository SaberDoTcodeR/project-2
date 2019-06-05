package Duelyst.model.Battle;


public class FlagsBattle extends Battle {
    private boolean playWithAI;
    private Account secondPlayer;
    private Hand secondPlayerHand = new Hand();
    private int flags;

    public int getFlags() {
        return flags;
    }

    public FlagsBattle(Deck opponentDeck, Deck myDeck, Account player, int flags, int reward) {
        super(player, myDeck, opponentDeck);
        this.playWithAI = true;
        Account account = new Account(1);
        account.setMainDeck(opponentDeck);
        this.secondPlayer = account;
        this.flags = flags;
        this.setMap();
        this.setReward(reward);
        this.getMap().get(2).get(0).getHero().setCardId(player.getUserName() + "_" + this.getMap().get(2).get(0).getHero().getName() + "_" + (1));
        this.getMap().get(2).get(8).getHero().setCardId(account.getUserName() + "_" + this.getMap().get(2).get(8).getHero().getName() + "_" + (1));
        this.getSecondPlayerInGameCards().add(this.getMap().get(2).get(8).getHero());
        this.getFirstPlayerInGameCards().add(this.getMap().get(2).get(0).getHero());
        if (this.getMap().get(2).get(8).getNumberOfFlag() > 0) {
            this.getMap().get(2).get(8).getHero().setNumberOfFlag(this.getMap().get(2).get(8).getHero().getNumberOfFlag() + this.getMap().get(2).get(8).getNumberOfFlag());
            this.getMap().get(2).get(8).setNumberOfFlag(0);
        } else if (this.getMap().get(2).get(0).getNumberOfFlag() > 0) {
            this.getMap().get(2).get(0).getHero().setNumberOfFlag(this.getMap().get(2).get(0).getHero().getNumberOfFlag() + this.getMap().get(2).get(0).getNumberOfFlag());
            this.getMap().get(2).get(0).setNumberOfFlag(0);
        }
        if (this.getMap().get(2).get(8).getCollectibleItem()!=null) {
            this.getSecondPlayerCollectibleItem().add(this.getMap().get(2).get(8).getCollectibleItem());
            this.increamentTurn();
            this.getSecondPlayerCollectibleItem().get(this.getSecondPlayerCollectibleItem().size()-1).cardIdGenerator(this);
            this.decreamentTurn();
            this.getMap().get(2).get(8).setCollectibleItem(null);
        } else if (this.getMap().get(2).get(0).getCollectibleItem() !=null) {
            this.getFirstPlayerCollectibleItem().add(this.getMap().get(2).get(0).getCollectibleItem());
            this.getFirstPlayerCollectibleItem().get(this.getFirstPlayerCollectibleItem().size()-1).cardIdGenerator(this);

            this.getMap().get(2).get(0).setCollectibleItem(null);
        }
    }

    public FlagsBattle(Deck opponentDeck, Deck myDeck, Account player, Account player2, int flags, int reward) {
        super(player, myDeck, opponentDeck);
        this.secondPlayer = player2;
        this.playWithAI = false;
        this.flags = flags;
        this.setMap();
        this.setReward(reward);
        this.getMap().get(2).get(0).getHero().setCardId(player.getUserName() + "_" + this.getMap().get(2).get(0).getHero().getName() + "_" + (1));
        this.getMap().get(2).get(8).getHero().setCardId(player2.getUserName() + "_" + this.getMap().get(2).get(8).getHero().getName() + "_" + (1));
        this.getSecondPlayerInGameCards().add(this.getMap().get(2).get(8).getHero());
        this.getFirstPlayerInGameCards().add(this.getMap().get(2).get(0).getHero());
        if (this.getMap().get(2).get(8).getNumberOfFlag() > 0) {
            this.getMap().get(2).get(8).getHero().setNumberOfFlag(this.getMap().get(2).get(8).getHero().getNumberOfFlag() + this.getMap().get(2).get(8).getNumberOfFlag());
            this.getMap().get(2).get(8).setNumberOfFlag(0);
        } else if (this.getMap().get(2).get(0).getNumberOfFlag() > 0) {
            this.getMap().get(2).get(0).getHero().setNumberOfFlag(this.getMap().get(2).get(0).getHero().getNumberOfFlag() + this.getMap().get(2).get(0).getNumberOfFlag());
            this.getMap().get(2).get(0).setNumberOfFlag(0);
        }
        if (this.getMap().get(2).get(8).getCollectibleItem()!=null) {
            this.getSecondPlayerCollectibleItem().add(this.getMap().get(2).get(8).getCollectibleItem());
            this.increamentTurn();
            this.getSecondPlayerCollectibleItem().get(this.getSecondPlayerCollectibleItem().size()-1).cardIdGenerator(this);
            this.decreamentTurn();
            this.getMap().get(2).get(8).setCollectibleItem(null);
        } else if (this.getMap().get(2).get(0).getCollectibleItem() !=null) {
            this.getFirstPlayerCollectibleItem().add(this.getMap().get(2).get(0).getCollectibleItem());
            this.getFirstPlayerCollectibleItem().get(this.getFirstPlayerCollectibleItem().size()-1).cardIdGenerator(this);

            this.getMap().get(2).get(0).setCollectibleItem(null);
        }
    }

    public void setMap() {
        Random random = new Random();
        getMap().add(new ArrayList<>());
        getMap().add(new ArrayList<>());
        getMap().add(new ArrayList<>());
        getMap().add(new ArrayList<>());
        getMap().add(new ArrayList<>());
        ArrayList<Integer> integers = new ArrayList<>();
        int counter = 0;
        while (counter < this.flags) {
            int x = random.nextInt(45);
            if (!integers.contains(x)) {
                integers.add(x);
                counter++;
            }

        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (random.nextInt(100) < 25) {
                    getMap().get(i).add(new Cell(i, j, 0, random.nextInt(CollectibleItem.getCollectibleItems().size())));
                } else {
                    getMap().get(i).add(new Cell(i, j, 0, -1));
                }
                if (i == 2 && j == 0) {
                    getMap().get(2).get(0).setHero(getFirstPlayerDeck().getHero().duplicate(), 0);

                }
                if (i == 2 && j == 8) {
                    getMap().get(2).get(8).setHero(getSecondPlayerDeck().getHero().duplicate(), 1);
                }

            }
        }
        for (int j = 0; j < this.flags; j++) {
            getMap().get(integers.get(j) % 5).get(integers.get(j) % 9).setNumberOfFlag(1);
            //System.out.println(integers.get(j) % 5 + " " + integers.get(j) % 9);
        }


    }

    @Override
    public String getType() {
        return "FlagsBattle";
    }

    @Override
    public Account getSecondPlayer() {
        return secondPlayer;
    }

    @Override
    public boolean isPlayWithAI() {
        return playWithAI;
    }

    @Override
    public void showDetailedInfo() {
        View view = View.getInstance();
        view.showDetailedInfoFlagsMode(this);
    }

    @Override
    public Hand getSecondPlayerHand() {
        return secondPlayerHand;
    }
}
