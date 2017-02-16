package playground1.yanaparser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    public static void main(String[] args) throws IOException {
        String csvFile = "C:\\webdrivers\\csv\\country.csv";
        String line;
        String csvSeparator = ",";
        List<String> l = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {

                if (line.split(csvSeparator)[2].contains("16778240") || ((line.split(csvSeparator)[2].contains("16785408")))) {
                    //System.out.printf("ooooooooooooo");
                    l.add(line.split(csvSeparator)[2]);
                }
            }
        }
        for (String value :
                l) {
            System.out.println(value);
        }
    }
}
