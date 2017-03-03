package playground1.yanaparser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Remaking the parser for my wife
 */

public class CSV_BarIlan_Remake {

    //region static variables
    public static final File MICROSCOPE_RESULTS = new File("C:\\Webdrivers\\csv\\mos2_vertical_30sec_3acc_green laser ulf_600 greating_10per_mapping_23hr_121216.txt");
    public static final List<String[]> FIRST_LASER_MEASUREMENTS = new ArrayList<>();
    public static final List<String[]> SECOND_LASER_MEASUREMENTS = new ArrayList<>();
    public static final List<String[]> THIRD_LASER_MEASUREMENTS = new ArrayList<>();
    public static final List<String[]> FORTH_LASER_MEASUREMENTS = new ArrayList<>();
    public static final String SEPARATOR = "\\s+";
    //endregion

    public static List<String[]> createAListFromFile(File laserMeasurements) throws IOException {
        String[] data;
        List<String[]> valuesFromFile = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(laserMeasurements))) {
            String line;
            int lineCounter = -1;
            while ((line = br.readLine()) != null) {
                lineCounter += 1;
                data = line.split(SEPARATOR);
                if (lineCounter == 0) {
                    System.out.println("DEBUG :: INFO :: Wave Length AXIS ignored when coverted file to list...");
                    System.out.println("Implement axis separation HERE ! Consider using class or enum for results  ");
                } else {
                    valuesFromFile.add(data);
                }
            }
            return valuesFromFile;
        }
    }

    public static void main(String[] args) throws IOException {
        List<String[]> measurements = createAListFromFile(MICROSCOPE_RESULTS);
        for (String[] line :
                measurements) {
            System.out.println();
            for (String value :
                    line) {
                System.out.print(value + " ");
            }
        }

    }


}
