public class AvailableMoney {
    int money=10;
    void refill(int k){ money +=k; }
    void take(){ money -=1; }
    void empty(){ money =0; }
    int available(){ return money; }
    boolean checkStock(){
        if(money>0)
            return true;
        else
            return false;
    }
}
