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
    public static final File CSVFILE = new File("/Users/sergei.miroshnikov/Downloads/testYana.csv");

    /**
     * Removes millisecond timestamp from laser measurment line
     * @param dirtyLine - line with timestamp
     * @return String[] with values only
     */
    public static String[] cleanLineWithValues(String[] dirtyLine){
        return Arrays.copyOfRange(dirtyLine,1,dirtyLine.length);
        }

    public static void main(String[] args) throws IOException {
        String line;
        int lineCounter = -1;
        String csvSeparator = " ";

        List<String[]> importantValuesList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CSVFILE))) {
            while ((line = br.readLine()) != null) {
                //System.out.println(lineCounter + "!");
                lineCounter += 1;
                if (lineCounter == 0) {
                    System.out.println("Ingnoring header...");
                } else {
                    importantValuesList.add(line.split(csvSeparator));
                }
            }
        }
        String[] brockenLine = new String[importantValuesList.size()];
        for (String[] longLine :
                importantValuesList) {
            for (String value : longLine) {
                //System.out.println(value);
                // todo remove split
                brockenLine = (value.split(","));
            }

            for (String value : cleanLineWithValues(brockenLine)) {
                System.out.printf(value);
            }
            //System.out.println(Arrays.toString(longLine));
        }
        //todo this is an external "removeTimestampFromLine" method when I will make this work
//        for (String item :
//                Arrays.copyOfRange(brockenLine,1,brockenLine.length)) {
//            System.out.println(item);
//        }

//        System.out.println(importantValuesList.size());
//        System.out.println(importantValuesList.get(1)[0]);
    }
}