class Account{
    private int balance;

    public Account(int balance){
        this.balance = balance;
    }
    public int GetBalance(){
        return this.balance;
    }

    public int withdraw(int amount) {
        this.balance -= Math.abs(amount);

        if (this.balance < 0)
        this.balance = 0;

        return this.balance;
    }

    public int deposit(int amount) {
        return this.balance += amount;
    }
}