public class ATM {
    double balance = 0;
    Withdraw w = new Withdraw();
    Deposit d = new Deposit();
    public double operate(int x, double amount) {
        switch(x) {
            case 1:
                this.balance =w.withdraw(amount,balance);
            case 2:
                this.balance = d.deposit(amount,balance);
        }
        return balance;}
}
