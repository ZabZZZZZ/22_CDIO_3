class Player {

    private String figure;
    private int playerNumber;
    private int age;
    private int currentField;
    private Account account;
    private boolean hasJailCard;
    private boolean hasFigureCard;

    //Constructor
    public Player(int amountOfPlayers) {
        this.figure = "";
        this.playerNumber = 0;
        this.age = 0;

        switch (amountOfPlayers) {
            case 2:
            this.account = new Account(20);
            break;

            case 3:
            this.account = new Account(18);
            break;

            case 4:
            this.account = new Account(16);
            break;
        }

        this.currentField = 0;
        this.hasJailCard = false;
        this.hasFigureCard = false;
    }

    //Getters
    public String getFigure() {
        return this.figure;
    }

    public int getPlayerNumber() {
        return this.playerNumber;
    }

    public int getAge() {
        return this.age;
    }

    public int getPoints() {
        return account.GetBalance();
    }

    public int getCurrentField() {
        return this.currentField;
    }

    public boolean getHasJailCard() {
        return this.hasJailCard;
    }

    public boolean getHasFigureCard() {
        return this.hasFigureCard;
    }

    //Setters
    public void setFigure(String figure) {
        this.figure = figure;
    }

    public void setPlayerNumber(int playerNum) {
        this.playerNumber = playerNum;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPosition(int n) {
        this.currentField = n;
    }

    public void setHasJailCard(boolean bool) {
        this.hasJailCard = bool;
    }

    public void setHasFigureCard(boolean bool) {
        this.hasFigureCard = bool;
    }
    public void withdraw(int amount) {
        account.withdraw(amount);
    }

    public void deposit(int amount) {
        account.deposit(amount);
    }
}

