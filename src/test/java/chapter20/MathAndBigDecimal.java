package chapter20;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

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

    @Test
    public void printAMegaFuckingHugeNumber() {
        // Excellent !
        BigInteger b = new BigInteger("900000987876878934753409850099000495343400459034250000054556000001102020203");
        // this is Random , no doubt
        BigInteger randomHugeFuckingInteger = new BigInteger(b.bitLength(), new Random());
        System.out.println(b);
        System.out.println(randomHugeFuckingInteger);
    }

    @Test
    public void convertToBigD() {
        BigDecimal fromInt = new BigDecimal(5);
        BigDecimal fromLong = new BigDecimal(5L);
        BigDecimal fromStr = new BigDecimal("5");
        BigDecimal fromBigInteger = new BigDecimal(BigInteger.valueOf(5));
        System.out.printf(fromInt.toString());
        System.out.printf(fromLong.toString());
        System.out.printf(fromStr.toString());
        System.out.printf(fromBigInteger.toString());
    }

    @Test
    public void arithmeticBasic() {
        BigDecimal bD = BigDecimal.ZERO;
        System.out.println((((bD.add(BigDecimal.TEN)).multiply(BigDecimal.valueOf(2))).subtract(BigDecimal.TEN)).divide(BigDecimal.valueOf(2)));
    }


}
