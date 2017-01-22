package chapter16;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

public class RandomDataTest {
    @Test
    public void randomData() {
        double rnd = Math.random();
        System.out.println(String.format("generated %f", rnd));
        assertThat(rnd < 1.0d, is(true));
        assertThat(rnd >= 0, is(true));
    }

    @Test
    public void randomLong() {
        Random r = new Random();
        System.out.println(r.nextLong());
        Boolean randomBoolean = r.nextBoolean();
        System.out.println(randomBoolean);
        byte[] randomBytes = new byte[10];
        System.out.printf("ln %d%n", randomBytes.length);
        r.nextBytes(randomBytes);
        for (byte b :
                randomBytes) {
            System.out.println(b);
        }
    }

    @Test
    public void randomBoundaries() {
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            int x = r.nextInt(Integer.MAX_VALUE) + Integer.MIN_VALUE;
            long l = r.nextLong();
            System.out.println(x);
            System.out.println(l);
            assertThat(l < Long.MAX_VALUE, is(true));
            assertThat(l > Long.MIN_VALUE, is(true));
            assertThat(x < Integer.MAX_VALUE, is(true));
            assertThat(x > Integer.MIN_VALUE, is(true));
        }
    }

    @Test
    public void womansBrain() {
        Random woman = new Random();
        int yesCount = 0;
        int noCount = 0;
        for (int i = 0; i < 1000; i++) {
            boolean decision = woman.nextBoolean();
            if (decision) {
                yesCount += 1;
            } else {
                noCount += 1;
            }
        }
        System.out.println(String.format("She said yes %d ", yesCount));
        System.out.println(String.format("She said no %d ", noCount));
        assertEquals(yesCount + noCount, 1000);
    }

    @Test
    public void floatTest() {
        Random random = new Random();
        float result = random.nextFloat();
        assertThat(result < 1.0d, is(true));
        assertThat(result > 0d, is(true));

    }

    @Test
    public void fifteenToTwenty() {
        Random r = new Random();
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            //System.out.println(r.nextInt(6) + 15);
            result.add(r.nextInt(6) + 15);
        }
        assertThat(result.size(), is(6));
        assertEquals(result, new HashSet<>(Arrays.asList(15, 16, 17, 18, 19, 26)));
    }

    @Test
    public void gaussianUnderstanding() {
        Random r = new Random();
        int deviation1 = 0;
        int deviation2 = 0;
        int deviation3 = 0;
        int anomalies = 0;

        for (int i = 0; i < 10000; i++) {
            double result = r.nextGaussian();
            System.out.printf("%f %n", result);
            if (1.0d > result && result > -1.0d) {
                deviation1 += 1;
            } else if ((2.0d > result && result > 1.0d) || (result < -1.0d && result > -2.0d)) {
                deviation2 += 1;
            } else if ((3.0d > result && result > 2.0d) || (result < -2.0d && result > -3.0d)) {
                deviation3 += 1;
            } else {
                anomalies += 1;
                System.out.printf("ANOMALY --> %f", result);
            }
        }
        System.out.printf("'70P' %d%n", deviation1);
        System.out.printf("'95P' %d%n", deviation1 + deviation2);
        System.out.printf("'99P' %d%n", deviation1 + deviation2 + deviation3);
        System.out.printf("Anomalious values detected %d", anomalies);
    }

    @Test
    public void gaussianIntegers() {
        Random generate = new Random();
        int age;
        ArrayList<Integer> ages = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            age = (int) (generate.nextGaussian() * 5) + 35;
            ages.add(age);
        }
        Collections.sort(ages);
        for (int a :
                ages) {
            System.out.println(a);
        }

    }

    @Test
    public void mapTest() {
        Random generate = new Random();
        HashMap<Integer, Integer> ages = new HashMap<>();
        // Boxing same as new Integer(1); turns 1 into New Integer
        for (int i = 0; i < 40000; i++) {
            Integer age = (int) ((generate.nextGaussian() * 5) + 35);

            if (ages.get(age) != null) {
                ages.put(age, ages.get(age) + 1);
            } else {
                ages.put(age, 1);
            }
            // UnBoxing automaically to int
        }

        for (Map.Entry<Integer, Integer> integerIntegerEntry : ages.entrySet()) {
            //Entry looks like this {key,value}
            System.out.println(integerIntegerEntry.getKey() + "--->" + integerIntegerEntry.getValue());
        }
    }

    @Test
    public void agesDistributionRevised() {
        Random r = new Random();
        TreeMap<Integer, Integer> ages = new TreeMap<>();
        // sorted , omiting repeatable elements ?
        for (int i = 0; i < 100; i++) {
            int age = (int) ((r.nextGaussian() * 7) + 20);
//            System.out.println(age);
            if (ages.get(age) != null) {
                ages.put(age, ages.get(age) + 1);
            } else {
                ages.put(age, 1);
            }
        } // end of for
        for (Map.Entry<Integer, Integer> ageIXEntry : ages.entrySet()) {
            System.out.println(ageIXEntry.getKey() + "-appears " + ageIXEntry.getValue() + "times");
        }

    }

    @Test
    public void seedWithRandom() {
        Random r = new Random(1234567L);
        assertEquals(1042961893, r.nextInt());
        assertEquals(-6749250865724111202L, r.nextLong());
        System.out.println(r.nextDouble());
        System.out.println(r.nextGaussian());
        System.out.println(r.nextFloat());
        System.out.println(r.nextBoolean());
        long currentSeed = System.currentTimeMillis();
        System.out.println("seed used " + currentSeed);
        // this could be used for dungeon/alchemy static random generation
        Random sysRandomSeed = new Random(currentSeed);
        System.out.println(sysRandomSeed.nextLong());
    }

    @Test
    public void randomStringGeneration() {
        // TODO this is a prototype for random name generator for dungeon game
        // TODO  also can be used to generate random usernames and passwords
        Random random = new Random();
        String validValues = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase();
        // nice trick !
        int rndIndex;
        String result = null;
        for (int i = 0; i < 100; i++) {
            rndIndex = random.nextInt(validValues.length());
            char rChar = validValues.charAt(rndIndex);
            System.out.println(rChar);
            result += rChar;
        }
        System.out.println(result);
    }


}



