package playground1.experimentMAY17;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Iidwuurliik on 5/3/2017.
 * Solving annoying date issue @ work
 * need to move 1 day in the past
 */

public class DateGames {
    static String extractedDate = "FROM : 01-01-2017 TO 11-12-2017";

    public static void main(String[] args) throws Exception {
        String pureDate = extractedDate.replaceAll("[^-?0-9]+", " ");

        String[] dates = pureDate.split(" ");
        String from = dates[1];
        String to = dates[2];

        Date d = new SimpleDateFormat("dd-MM-yyyy").parse(from);
        System.out.println(d);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        System.out.println(calendar.getTime());

        String dd = new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime());
        System.out.println(dd);


    }
}
