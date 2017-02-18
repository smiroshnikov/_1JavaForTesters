package playground1.yanaparser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//int offsetp[0.3] line from offset
//[2,6,10,14]


public class CSVParser {
    public static final File MAC_CSVFILE = new File("/Users/sergei.miroshnikov/Downloads/testYana.csv");
    public static final File WIN_CSVFILE = new File("C:\\Webdrivers\\csv\\mos2_vertical_30sec_3acc_green laser ulf_600 greating_10per_mapping_23hr_121216.txt");

    /**
     * Removes millisecond timestamp from laser measurment line
     *
     * @param dirtyLine - line with timestamp
     * @return String[] with values only
     */
    public static String[] cleanLineWithValues(String[] dirtyLine) {
        return Arrays.copyOfRange(dirtyLine, 1, dirtyLine.length);
    }

    public static void main(String[] args) throws IOException {
        String lineInFile;
        int lineCounter = -1;
        String csvSeparator = "\\s+"; // DONT  EVER FUCKING SPLIT BY " " - apparently this is not concidered as space in every OS !
        List<String[]> valuesList = new ArrayList<>();
        // creating List of String[]
        try (BufferedReader br = new BufferedReader(new FileReader(WIN_CSVFILE))) {
            while ((lineInFile = br.readLine()) != null) {
                lineCounter += 1;
                if (lineCounter == 0) {
                    System.out.println("Header ignored when coverted file to list...");
                } else {
                    valuesList.add(lineInFile.split(csvSeparator));
                }
            }
        }

        System.out.println(valuesList.size());

        for (String[] lineWithExcessiveValuesInarray :
                valuesList) {
            System.out.println(lineWithExcessiveValuesInarray.length);
        }
    }
}