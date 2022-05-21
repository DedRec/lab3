public class HandWatch {
    enum State {
        NORMAL,
        ALARM,
        UPDATE
    }

    enum State1 {
        TIME,
        DATE,
        ALARM,
        CHIME,
        MIN,
        HOUR,
        DAY,
        MONTH,
        YEAR
    }

    int m = 0, h = 0, D = 1, M = 1, Y = 2000;

    String outputState;
    String outputTime;
    String outputDate;
    State state = State.NORMAL;
    State1 state1 = State1.TIME;

    public String modifyState(String in) {

        char[] inString = in.toCharArray();

        for (char input : inString) {
            switch (state) {
                case NORMAL:
                    if (input == 'c') {
                        state = State.UPDATE;
                        state1= State1.MIN;
                    } else if (input == 'b') {
                        state = State.ALARM;
                        state1 = State1.ALARM;
                    } else if (input == 'a') {
                        if (state1 == State1.TIME) state1 = state1.DATE;
                        else
                            state1 = state1.TIME;
                    }
                    break;
                case UPDATE:
                    if (input == 'a'){
                        if(state1 == State1.MIN){
                            state1 = State1.HOUR;
                        }
                        else if(state1 == State1.HOUR){
                            state1 = State1.DAY;
                        }
                        else if(state1 == State1.DAY){
                            state1 = State1.MONTH;
                        }
                        else if(state1 == State1.MONTH){
                            state1 = State1.YEAR;
                        }
                        else{
                            state = State.NORMAL;
                            state1 = State1.TIME;
                        }
                    }
                    else if(input == 'b'){
                        if(state1 == State1.MIN){
                            incrementm60();
                        }
                        else if(state1 == State1.HOUR){
                            incrementh24();
                        }
                        else if(state1 == State1.DAY){
                            incrementD31();
                        }
                        else if(state1 == State1.MONTH){
                            incrementM12();
                        }
                        else if(state1 == State1.YEAR){
                            incrementY100();
                        }
                    }
                    else if(input == 'd'){
                        state = State.NORMAL;
                        state1 = State1.TIME;
                    }
                    break;
                case ALARM:
                    if(input == 'a' && state1 == State1.ALARM){
                        state1 = State1.CHIME;
                    }
                    else if(input == 'd'){
                        state = State.NORMAL;
                        state1 = State1.TIME;
                    }
            }
            Output(state, state1);
        }
        DisplayState();
        DisplayTIME();
        DisplayDate();
        String output = outputState + " " + outputDate + " " + outputTime;
        return output;
    }
    public int incrementm60(){
        m+=1;
        if(m==60){
            incrementh24();
            m=0;
        }
        return m;
    }
    public int incrementh24(){
        h+=1;
        if(h==24){
            incrementD31();
            h=0;
        }
        return h;
    }
    public int incrementD31(){
        D+=1;
        if(D==32){
            incrementM12();
            D=1;
        }
        return D;
    }
    public int incrementM12(){
        M+=1;
        if(M==13){
            incrementY100();
            M=1;
        }
        return M;
    }
    public int incrementY100(){
        Y+=1;
        if(Y==2101){
            Y=2000;
        }
        return Y;
    }

    public String DisplayState() {
        System.out.println(outputState);
        return outputState;
    }

    public String DisplayDate() {
        System.out.println(outputDate);
        return outputDate;
    }

    public String DisplayTIME() {
        System.out.println(outputTime);
        return outputTime;
    }
    public String Output(State state, State1 state1){
        outputState = state.name() + " " + state1.name();
        outputDate = Y + "-" + M + "-" + D;
        outputTime = h + ":" + m;
        String output = outputState + " " + outputDate + " " + outputTime;
        return output;
    }
}
