class Player {

    private String figure;
    private int age;
    private int currentField;
    private Account account;
    private boolean hasCard;

    //Constructor for figure and balance
    public Player (String figure, int balance) {
        this.figure = figure;
        this.account = new Account(balance);
        this.currentField = 0;
        this.hasCard = false;
    }

    //Constructor for age
    public Player(int age) {
        this.age = age;
    }

    //Getters
    public String getFigure() {
        return this.figure;
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

    public boolean getHasCard() {
        return this.hasCard;
    }

    //Setter
    public void setFigure(String figure) {
        this.figure = figure;
    }

    public void withdraw(int amount) {
        account.withdraw(amount);
    }

    public void deposit(int amount) {
        account.deposit(amount);
    }
}
