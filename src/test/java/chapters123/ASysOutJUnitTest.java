package chapters123;

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
        String result = "Kikibojo";
        assertEquals("Error strings differ !","Kikibojo", result);
    }

    @Test
    public void twoMinusTwo(){
        int result =0;
        assertEquals("Not a 0 !",0,result);
    }

    @Test
    public void fourDivideByTwo(){
        int result = 4/2;
        assertEquals("Not as expected !", 4/2,result);
    }

    @Test
    public void twoMultiplyByTwo(){
        int result = 2*2;
        assertEquals("This is an error message , results do not match ", 2*2,result);
    }
}
