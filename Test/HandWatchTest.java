import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandWatchTest {
    HandWatch x;
    String s;
    @Nested
    class bottomUp {
        @BeforeEach
        public void init() {
            x = new HandWatch();
        }
        @Test
        public void normalDriver1(){
            s = x.modifyState("a");
            System.out.println(s);
            assertEquals("NORMAL DATE 2000-1-1 0:0", x.outputState + " " + x.outputDate + " " + x.outputTime);
        }
        @Test
        public void updateDriver1(){
            HandWatch x = new HandWatch();
            String[][] times = new String[5][2];
            x.modifyState("c");
            for(int i = 0; i < 5 ; i ++) {
                System.out.print(x.state1);
                times[i][0] = (x.DisplayDate() + " " + x.DisplayTIME());
                x.modifyState("b");
                x.modifyState("a");
                times[i][1] = (x.DisplayDate() + " " + x.DisplayTIME());
            }
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 2; j++) {
                    System.out.print(times[i][j] + " ");
                }
                System.out.println();
            }
        }
        @AfterEach
        public void clean(){ x=null ; } }
}