package chapter17;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

// Interview Alert
// In addition to working with dates, I also use the Date/Time functionality to:
//• seed random numbers
//• generate unique data e.g. filenames, and user

public class DatesAndTimesLesson {
    @Test
    public void checkNano() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            int r = new Random().nextInt();
            System.out.println(r);
        }
//        System.out.println(System.nanoTime());
//        System.out.println(System.currentTimeMillis());

        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("took " + estimatedTime / 1000000000.0 + " nanoseconds");

    }

    @Test
    public void executionTime() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            System.out.println(new Random().nextInt());
        }
        long timeMeasurement = System.currentTimeMillis() - startTime;
        System.out.println("Total time " + timeMeasurement / 1000);
    }

    @Test
    public void generateRandomUser() {
        // TODO perfect for user generation
        String userID = "user" + System.currentTimeMillis();
        System.out.println(userID);
    }

    @Test
    public void generateRandomUserFromTime() {
        String validValues = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase();
        String baseUserName = "user" + System.currentTimeMillis();

        for (int k = 0; k < 100; k++) {
            String finalUsername = "user";
            for (int i = 0; i < baseUserName.length(); i++) {
                Random R = new Random();
                char c = validValues.charAt(R.nextInt(validValues.length()));
                finalUsername += c;
            }
            System.out.println(finalUsername);
        }
    }

    @Test
    public void stupidSolution() {
        String initialUserID = "user" +
                System.currentTimeMillis();
        System.out.println(initialUserID);
        String userID = initialUserID;
        for (int i = 0; i < 10; i++) {
            String charReplacement;
            if (new Random().nextBoolean()) {
                charReplacement = ("" + ((char) ('A' + i))).toLowerCase();
            } else {
                charReplacement = "" + ((char) ('A' + i));
            }
            String intoReplace = String.valueOf(i);
            userID = userID.replace(intoReplace, charReplacement);

        }
        System.out.println(userID);
    }

    @Test
    public void dateExample() {
        Date date = new Date();
        System.out.println(date);
    }

    @Test
    public void dateMoreExamples() {
        Date eqDate1 = new Date();
        Date eqDate2 = new Date(System.currentTimeMillis());
        System.out.println(eqDate1 + " " + eqDate2);
        System.out.println(eqDate1.toString());
        Date date = new Date();

        long oneWeekFromNowTime = date.getTime();
        oneWeekFromNowTime = oneWeekFromNowTime + (1000 * 60 * 60 * 24 * 7);
        Date oneWeekFromNow = new Date(oneWeekFromNowTime);
        System.out.println(oneWeekFromNow + " future!");
        oneWeekFromNow.setTime(date.getTime());
        System.out.println(oneWeekFromNow.toString());
    }

    @Test
    public void simpleDateExample() {
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date(0L);
        // apply pattern
        sdf.applyPattern("dd/d/yyyy");
        // format
        System.out.println(sdf.format(date));
        assertThat(sdf.format(date), is("01/1/1970"));

    }

    @Test
    public void calendarExample() {
        Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        System.out.println(cal.toString());
        System.out.println(cal2.toString());
    }

    @Test
    public void calendarTry2() {
        Calendar oneWeekFromNow = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();
        System.out.println("\"cal\" -> current time & date " + cal.getTime().toString());

        oneWeekFromNow.setTime(cal.getTime()); //set to current date

        System.out.println("\"oneWeekFromNow\" -> current time & date " + oneWeekFromNow.getTime().toString());

        oneWeekFromNow.add(Calendar.DATE, 51);

        System.out.println("\"oneWeekFromNow\" -> moved 51 day into the future !  " + oneWeekFromNow.getTime().toString());

        // tests

        assertThat(oneWeekFromNow.after(cal), is(true));

        assertThat(cal.before(oneWeekFromNow), is(true));

        assertThat("HERE! ", cal.compareTo(oneWeekFromNow), is(-1));

        // equality
        assertThat(oneWeekFromNow.compareTo(cal), is(1));

        oneWeekFromNow.setTime(cal.getTime()); //set to current date

        assertThat(oneWeekFromNow.compareTo(cal), is(0));


    }

    @Test
    public void calendarExample3() {
        Date hunderedBirthday = new Date();
        hunderedBirthday.setTime(3459270001000L);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2079);
        calendar.set(Calendar.MONTH, 7);
        calendar.set(Calendar.DAY_OF_MONTH, 14);
        calendar.set(Calendar.HOUR, 11);
        calendar.set(Calendar.MINUTE, 20);
        calendar.set(Calendar.SECOND, 1);
        calendar.set(Calendar.MILLISECOND, 14);
        // found a solution
        if (Objects.equals(String.valueOf(calendar.getTime()), String.valueOf(hunderedBirthday))) {
            System.out.println("Happy motherfucking birthday ! \n");
            System.out.println("Hope you got your cybernetic golden wireless penis! \n");
        }
    }

    @Test
    public void classwork() {
        Calendar isItSunday = Calendar.getInstance();
        isItSunday.set(2013, 11, 15);
        System.out.println(isItSunday.getTime().toString());

        assertThat(isItSunday.get(Calendar.MONTH), is(11));
        assertThat(isItSunday.get(Calendar.DAY_OF_WEEK), is(1));
        assertThat(isItSunday.get(Calendar.DAY_OF_YEAR), is(349));

        isItSunday.add(Calendar.DAY_OF_WEEK, -1);
        assertThat(isItSunday.get(Calendar.DAY_OF_WEEK), is(7));
    }

    @Test
    public void doesItMovesYear() {
        Calendar cal = Calendar.getInstance();
        cal.set(2013, Calendar.DECEMBER, 15, 23, 39, 54);
        cal.roll(Calendar.DAY_OF_MONTH, 17);
        System.out.println("used roll " + cal.getTime());

        cal.set(2013, Calendar.DECEMBER, 15, 23, 39, 54);
        cal.add(Calendar.DAY_OF_MONTH, 17);
        System.out.println("used add " + cal.getTime());

    }
}

