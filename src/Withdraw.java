public class Withdraw {
    double withdraw(double withdraw, double balance) {
        if (balance >= withdraw)
            return balance - withdraw;
        else
            return balance;
    }
}
