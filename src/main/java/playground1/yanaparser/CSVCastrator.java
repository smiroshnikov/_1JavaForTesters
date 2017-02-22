package playground1.yanaparser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * CSV file reader for Yana
 */
public class CSVCastrator {
    //public static final File CSVFILE = new File("C:\\Webdrivers\\csv\\country.csv");
    //public static final File CSVFILE = new File("/Users/sergei.miroshnikov/Downloads/testYana.csv");
    public static final File CSVFILE = new File("C:\\Webdrivers\\csv\\mos2_vertical_30sec_3acc_green laser ulf_600 greating_10per_mapping_23hr_121216.txt");


    public static void main(String[] args) throws IOException {
        int c = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(CSVFILE))) {
            while (br.readLine() != null) {
                c += 1;
            }
        }
        System.out.println(c);
    }
}
