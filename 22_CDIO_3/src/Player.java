class Player {
    
    private String figure;
    private Account account;
    int location = 25;
    int number;
    boolean harfigurkort = false;
    boolean fængselskort = false;

    public Player (String figure) {
        this.figure = figure;
        this.account = new Account(1000);
    }

    public String getName() {
        return this.figure;
    }

    public void setName(String figure) {
        this.figure = figure;
    }

    public int getPoints() {
        return account.GetBalance();
    }

    public void withdraw(int amount) {
        account.withdraw(amount);
    }

    public void deposit(int amount) {
        account.deposit(amount);
    }
}
