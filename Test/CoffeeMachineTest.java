import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CoffeeMachineTest {
    CoffeeMachine x;
    AvailableMoney k;
    Coins c;
    String s;
    @BeforeEach
        public void init() {
            x = new CoffeeMachine();
            k = new AvailableMoney();
            c = new Coins();
        }
        class coinInsert{
            int insert(int x){
                return Math.max(x, 0);
            }
        }
        @Test
        public void coffeeStub(){
            coinInsert y = new coinInsert();
            x.despence(y.insert(5));
            assertEquals(x.k.money,5);
        }
        class doubleCoffee{
            String check(int x){
                if(x%2==0)
                    return "Order Success";
                else
                    return "Order failed";
            }
        }
        @Test
        public void stockDriver(){
            doubleCoffee y = new doubleCoffee();
            s = y.check(k.available());
            assertEquals(s,"Order Success");
            k.take();
            s = y.check(k.available());
            assertEquals(s,"Order failed");
        }
        @AfterEach
            public void clean(){
                x=null ;
            }
}