import java.util.Scanner;
public class CoffeeMachine{
    Coins c = new Coins();
    AvailableMoney k = new AvailableMoney();
    public void coffee(int s){ k.refill(s); }
    void despence(int x){
        while(x>0 && k.checkStock()){
            System.out.println("coffee"); c.addCoin();
            k.take();
            x--;
        }
        if (x!=0)
            System.out.println("machine empty");
    }
    void status(){
        System.out.println("there are "+k.checkStock()+" coffees in stock\n"
                +"there are "+c.checkCoins()+" coins\n");
    }
}