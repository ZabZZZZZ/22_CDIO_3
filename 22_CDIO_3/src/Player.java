class Player {

    private String figure;
    private int age;
    private int currentField;
    private int number;
    private Account account;
    private boolean hasJailCard;
    private boolean harfigurkort = false;

    //Constructor for figure and balance
    public Player (String figure, int balance) {
        this.figure = figure;
        this.account = new Account(balance);
        this.currentField = 0;
        this.hasJailCard = false;
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
        return this.hasJailCard;
    }
    public boolean gethasfigurecard(){
        return this.harfigurkort;
    }
    public int getNumber(){
        return this.number;
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
    public void setHarFigurKort(boolean bool){
        this.harfigurkort = bool;
    }

    public void withdraw(int amount) {
        account.withdraw(amount);
    }

    public void deposit(int amount) {
        account.deposit(amount);
    }
}

