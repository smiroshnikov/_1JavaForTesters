import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyMathTest {
    @Test
    public void canAddOnePlusOne() {
        int answer = 1 +21;
        assertEquals("FAILED Incorrect result  1+1=2", 2, answer);
    }
}
