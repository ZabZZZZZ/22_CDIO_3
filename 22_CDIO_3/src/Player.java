class Player {

    private String figure;
    private int playerNumber;
    private int age;
    private int currentField;
    private Account account;
    private boolean hasJailCard;
    private boolean hasFigureCard;

    //Constructor for figure and balance
    public Player (String figure, int playerNumber, int balance) {
        this.figure = figure;
        this.playerNumber = playerNumber;
        this.account = new Account(balance);
        this.currentField = 0;
        this.hasJailCard = false;
        this.hasFigureCard = false;
    }

    //Constructor for age
    public Player(int age) {
        this.age = age;
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

