import javafortesters.chapter3.practice.AClassWithAMethod;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ASysOutJUnitTest {
    @Test
    public void canItPrintToConsole(){
        AClassWithAMethod testObject = new AClassWithAMethod();
        testObject.aMethodOnACLass();
    }

    @Test
    public void canAddOnePlusOne() {
        int answer = 1 +1;
        assertEquals("FAILED Incorrect result  1+1=2", 2, answer);
    }
    @Test
    public void compareStrings(){
        String result = "Kikibojjo";
        assertEquals("Error strings differ !","Kikibojo", result);
    }
}
