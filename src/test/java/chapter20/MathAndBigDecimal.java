package chapter20;

import org.junit.Test;

import java.math.BigDecimal;

public class MathAndBigDecimal {
    @Test
    public void workingWithNumbers() {
        // TODO mortgage calculator
        float total = 0.1f + 0.73f;
        System.out.println(total);
        BigDecimal bgTotal = new BigDecimal("0.1").add(new BigDecimal("0.73"));
        System.out.println(bgTotal.toString());

    }

    @Test
    public void money() {
        double dPence = 5 - 0.3 - 0.47 - 1.73;
        System.out.printf("Double %f %n", dPence);
        int iPence = 500 - 30 - 47 - 173;
        System.out.printf("Integer %d %n", iPence);
        BigDecimal bdPence = (new BigDecimal("5.0").subtract(new BigDecimal("0.3"))
                .subtract(new BigDecimal("0.47")).subtract(new BigDecimal("1.73")));
        System.out.println("%n BD " + bdPence.toString());


    }
}
