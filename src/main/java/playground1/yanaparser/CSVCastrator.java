package playground1.yanaparser;

import java.io.*;

/**
 * CSV file reader for Yana
 */
public class CSVCastrator {
    //public static final File CSVFILE = new File("C:\\Webdrivers\\csv\\country.csv");
    public static final File CSVFILE = new File("/Users/sergei.miroshnikov/Downloads/testYana.csv");


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
