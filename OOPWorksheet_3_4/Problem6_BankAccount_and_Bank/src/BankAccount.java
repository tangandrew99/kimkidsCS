public class BankAccount {
    private String owner;
    private double balance;

    public BankAccount(String owner, double initialBalance) {
        this.owner   = owner;
        this.balance = __________; // TODO
    }

    public void deposit(double amount) {
        if (amount __________ 0) { // TODO: comparison operator
            balance __________= amount; // TODO: compound assignment
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= __________) { // TODO: field name
            balance -= amount;
        }
    }

    public double getBalance() { return balance; }
    public String getOwner()   { return owner;   }
}
