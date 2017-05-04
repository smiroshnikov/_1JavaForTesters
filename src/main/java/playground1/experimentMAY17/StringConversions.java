package playground1.experimentMAY17;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by smiroshn on 5/4/17.
 */
public class StringConversions {


    /**
     * Converts string into float
     *
     * @param fullString provided string
     * @return float value
     */
    private double extractFloatFromString(String fullString) {
        // Surround try catch ? in case of numeric format exception
        return Double.parseDouble(fullString.replaceAll("[^\\d.]+|\\.(?!\\d)", " ").split(" ")[1]);
    }
    /**
     *
     * @param providedDateFromWebElement full date provided as string
     * @return String that represents 'day' that occurred 1 day before date provided as input
     */
    private String calculatePreviousDateBasedOnCurrentDay(String providedDateFromWebElement) {
        //TODO PAY ATTENTION THAT INITIALIZING <d> solved most of your issues regarding <d> scope
        String onlyDateWithoutTime = providedDateFromWebElement.split(",")[0].replace(" ", "-");
        Date d = null;
        try {
            d = new SimpleDateFormat("dd-MMM-yyyy").parse(onlyDateWithoutTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(d);
        calendar.add(Calendar.DAY_OF_MONTH, -1); // moving 1 day backwards
        String previousCalendarDay = new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime());
        return (previousCalendarDay.split("-")[0]);
    }
}

