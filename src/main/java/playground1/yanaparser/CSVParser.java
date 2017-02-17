package playground1.yanaparser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//int offsetp[0.3] line from offset
//[2,6,10,14]


public class CSVParser {
    public static void main(String[] args) throws IOException {
        String csvFile = "C:\\webdrivers\\csv\\country.csv";
        String line;
        int lineCounter = -1;
        String csvSeparator = " ";

        List<String[]> importantValuesList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
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
                brockenLine = (value.split(" "));
            }
            //System.out.println(Arrays.toString(longLine));
        }
        for (String item :
                brockenLine) {
            System.out.println(item.replaceAll("\\s+", ""));
        }

//        System.out.println(importantValuesList.size());
//        System.out.println(importantValuesList.get(1)[0]);
    }
}