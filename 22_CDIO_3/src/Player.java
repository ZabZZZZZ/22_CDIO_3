class Player {

    private String figure;
    private int playerNumber;
    private int age;
    private int currentField;
    private Account account;
    private boolean hasJailCard;
    private boolean isJailed;
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
        this.isJailed = false;
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

    public boolean getIsJailed() {
        return this.isJailed;
    }

    public void getStatus() {
        System.out.println(System.lineSeparator() + "Spiller " + this.playerNumber + ", " + this.figure + ", har " + this.getPoints() + "M, og staar paa felt nummer " + (this.currentField + 1));
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

    public void move(int n) {
        this.currentField += n;

        if (this.currentField > 23) { //Player has passed start
            this.currentField -= 23;
            if (this.currentField != 0) {
                this.deposit(2);
                System.out.println("Du har passeret start, saa du modtager 2M");
            }
        }
    }

    public void setJail() {
        this.currentField = 6;
        this.isJailed = true;
    }

    public void unJail() {
        this.isJailed = false;
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

