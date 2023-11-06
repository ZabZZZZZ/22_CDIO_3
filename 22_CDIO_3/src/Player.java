class Player {

    private String name;
    private Account account;
    int location = 25;
    int number;

    public Player (String name) {
        this.name = name;
        this.account = new Account(1000);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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
