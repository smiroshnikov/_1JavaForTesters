package playground1.yanaparser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVParser {
    public static void main(String[] args) throws IOException {

        String csvFile = "C:\\webdrivers\\csv\\country.csv";

        String line = "";
        String csvSeparator = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] country = line.split(csvSeparator);
                if (line.split(csvSeparator)[2].contains("16778240")) {
                    System.out.printf("ooooooooooooo");
                }
//                    System.out.printf("%s%n", country[2]);
//                if (Objects.equals(country[2], "16778240")) {
//                    System.out.printf("HEYHEYHEY!!!!!");
//                    // TODO here I will create another array
//                }
            }
        }
    }
}
