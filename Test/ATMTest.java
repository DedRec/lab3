import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ATMTest {
    ATM x;
    Deposit d;
    Withdraw w;
    String s;
    @BeforeEach
    public void init() {
        x = new ATM();
        d = new Deposit();
        w = new Withdraw();
    }
    class moneyGrabber{
        int insert(int x){
            return Math.max(x, 0);
        }
    }
    @Test public void ATMStub(){
        moneyGrabber y = new moneyGrabber();
        x.operate(2,y.insert(5000));
        assertEquals(x.balance,5000);
    }
    @Test public void withdrawStub(){
        moneyGrabber y = new moneyGrabber();
        double z =w.withdraw(2000,y.insert(5000));
        assertEquals(z,3000); }
    @Test public void depositStub(){
        moneyGrabber y = new moneyGrabber();
        double z =d.deposit(2000,y.insert(5000));
        assertEquals(z,7000);
    }
    @AfterEach
    public void clean(){ x=null ; }

}