public class Coins {
    int c=0;
    void empty(int c){ c =0; }
    void addCoin(){ c++; }
    boolean checkCoins(){
        if(c>0)
            return true;
        else
            return false;
    }
}
