package playground1.experimentMAY17;

import org.apache.bcel.verifier.statics.DOUBLE_Upper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by smiroshn on 4/30/17.
 * The only purpose of this is to replace Java REPL for short checks
 */
public class DateGames {

    /**
     * Created by Iidwuurliik on 5/3/2017.
     * Solving annoying date issue @ work
     * need to move 1 day in the past
     */

    static String extractedDate = "FROM : 01-01-2017 TO 11-12-2017";
    static String shortExtractedDate = "4 MAY 2017, 2:59 PM";

    public static void main(String[] args) throws Exception {
        //String pureDate = extractedDate.replaceAll("[^-?0-9]+", " ");
        String[] pureDate = shortExtractedDate.split(" ");
//        System.out.println(pureDate[0]);
//        System.out.println(pureDate[1]);
//        System.out.println(pureDate[2]);

        String concatDate = pureDate[0]+"-"+pureDate[1]+"-"+pureDate[2].substring(0,pureDate[2].length()-1);
        System.out.println(concatDate);


        Date d = new SimpleDateFormat("dd-MMM-yyyy").parse(concatDate);
        System.out.println(d);




//        String[] dates = pureDate.split(" ");
//        String from = dates[1];
//        String to = dates[2];
//
//        Date d = new SimpleDateFormat("dd-MM-yyyy").parse(from);
//        System.out.println(d);
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(d);
//        calendar.add(Calendar.DAY_OF_MONTH, -1);
//        System.out.println(calendar.getTime());
//
//        String dd = new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime());
//        System.out.println(dd);


    }
}


