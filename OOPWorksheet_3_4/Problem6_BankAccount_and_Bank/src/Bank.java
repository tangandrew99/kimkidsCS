import java.util.ArrayList;

public class Bank {
    private ArrayList<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public double getTotalDeposits() {
        double total = 0;

        for (__________ account : __________) { // TODO: type and collection
            total += account.__________(); // TODO: getter
        }

        return __________; // TODO
    }

    public void printOverdraftRisk(double threshold) {
        for (int i = 0; i < accounts.__________(); __________) { // TODO
            BankAccount acc = accounts.get(__________); // TODO

            if (acc.getBalance() __________ threshold) { // TODO: comparison
                System.out.println(acc.__________() // TODO: owner getter
                    + " is at risk. Balance: " + acc.getBalance());
            }
        }
    }
}
