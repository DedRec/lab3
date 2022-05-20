public class CoffeeMachine {
    enum On_off {
        ON,
        OFF
    }

    enum State {
        COFFEE,
        COCOA,
        MONEY,
        OFF
    }

    enum State1 {
        BUSY,
        IDLE
    }

    enum Money {
        EMPTY,
        NOT_EMPTY
    }

    int m = 0, L = 1;
    Money money;

    String currentState;
    int outputCoins;
    String outputTimeRemaining;

    public String modifyState(String in) {

        State state = State.OFF;
        State1 state1 = State1.IDLE;
        money = Money.EMPTY;
        char[] inString = in.toCharArray();
        for (char input : inString) {
            switch (state) {
                case OFF:
                    if (input == 'c') {
                        state = State.COCOA;
                        state1 = State1.IDLE;
                        money = Money.EMPTY;
                    } else if (input == 'f') {
                        state = State.COFFEE;
                        state1 = State1.IDLE;
                        money = Money.EMPTY;
                    }
                    break;

                case COCOA:
                    if (input == 'o') {
                        state = State.OFF;
                        state1 = State1.IDLE;
                    } else if (input == 'b' && m > 0) {
                        decrementm();
                        state1 = State1.BUSY;
                        modify_busy(state1, state);
                    } else if (input == 'f') {
                        state = State.COFFEE;
                        state1 = State1.IDLE;
                    }
                    break;
                case COFFEE:
                    if (input == 'o') {
                        state = State.OFF;
                        state1 = State1.IDLE;
                    } else if (input == 'b' && m > 0) {
                        decrementm();
                        state1 = State1.BUSY;
                        modify_busy(state1, state);
                    } else if (input == 'c') {
                        state = State.COCOA;
                        state1 = State1.IDLE;
                    }
                    break;
                case MONEY:
                    if (input == 'a'){
                        incrementm();
                        money = Money.NOT_EMPTY;
                    }

            }
        }
        outputCoins = m;
        outputTimeRemaining= "30 sec";
        currentState = state.name();

        return currentState;
    }

    public String modify_busy(State1 state1, State state){
        String message;
        switch (state1){
            case BUSY:
                System.out.println("30 seconds remaining");
                state1 = State1.IDLE;
                if(state == State.COCOA){
                    message = "Your Cocoa is ready!";
                } else{
                    message = "Your Coffee is ready!";
                }
                System.out.println(message);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + state1);
        }
        
        return message;
    }

    public int decrementm(){
        m-=1;
        if(m==0){
            money = Money.EMPTY;
        }
        return m;
    }
    public int incrementm(){
        m+=1;
        return m;
    }
}
