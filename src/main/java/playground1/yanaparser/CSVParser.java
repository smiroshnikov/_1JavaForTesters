package playground1.yanaparser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//[2,6,10,14]

public class CSVParser {
    public static void main(String[] args) throws IOException {
        String csvFile = "C:\\webdrivers\\csv\\mos2_vertical_30sec_3acc_green laser ulf_600 greating_10per_mapping_23hr_121216.txt";
        String line;
        int lineCounter = -1;
        String csvSeparator = " ";

        List<String[]> importantValuesList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                lineCounter += 1;
                if (lineCounter == 0) {
                    System.out.println("Do nothing...");
                } else {
                    importantValuesList.add(line.split(csvSeparator));

                }
            }
        }
        for (String[] longLine :
                importantValuesList) {
            System.out.println(Arrays.toString(longLine));
        }
    }
}

