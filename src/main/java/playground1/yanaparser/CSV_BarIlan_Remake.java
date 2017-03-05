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
    public static final File MOCK_FILE_PATH = new File("C:\\Webdrivers\\csv\\cleanMockup.txt");
    public static final List<String[]> FIRST_LASER_MEASUREMENTS = new ArrayList<>();
    public static final List<String[]> SECOND_LASER_MEASUREMENTS = new ArrayList<>();
    public static final List<String[]> THIRD_LASER_MEASUREMENTS = new ArrayList<>();
    public static final List<String[]> FORTH_LASER_MEASUREMENTS = new ArrayList<>();
    public static String[] waveLengthAxisX;
    public static final String SEPARATOR = "\\s+";
    //endregion

    public static List<String[]> parseFileToListOfStringArrays(File laserMeasurements) throws IOException {
        String[] data;
        List<String[]> valuesFromFile = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(laserMeasurements))) {
            String line;
            int lineCounter = -1;
            while ((line = br.readLine()) != null) {
                lineCounter += 1;
                data = line.split(SEPARATOR);
                if (lineCounter == 0) {
                    System.out.println("Axis Saved");
                    waveLengthAxisX = data;
                } else {
                    valuesFromFile.add(data);
                }
            }
            return valuesFromFile;
        }
    }

    public static void printListOfArrays(List<String[]> list) {
        for (String[] array :
                list) {
            System.out.println();
            for (String value :
                    array) {
                System.out.print(value + "\t");
            }
        }
    }

    public static void splitTheMeasurements(List<String[]> measurements) {
        int lineCounter;
        FIRST_LASER_MEASUREMENTS.add(waveLengthAxisX);
        SECOND_LASER_MEASUREMENTS.add(waveLengthAxisX);
        THIRD_LASER_MEASUREMENTS.add(waveLengthAxisX);
        FORTH_LASER_MEASUREMENTS.add(waveLengthAxisX);

        for (int i = 0; i < measurements.size(); i++) {
            lineCounter = i % 4;
            switch (lineCounter) {
                case 0:
                    FIRST_LASER_MEASUREMENTS.add(measurements.get(i));
                    break;
                case 1:
                    SECOND_LASER_MEASUREMENTS.add(measurements.get(i));
                    break;
                case 2:
                    THIRD_LASER_MEASUREMENTS.add(measurements.get(i));
                    break;
                case 3:
                    FORTH_LASER_MEASUREMENTS.add(measurements.get(i));
                    break;
            }
        }
    }

    public static void writeListToFile(List<String[]> list, String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);

        for (String[] line :
                list) {
            writer.write(System.getProperty("line.separator"));
            for (String element :
                    line) {
                //System.out.print(element);
                writer.write(element + "\t");
            }
        }
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        List<String[]> measurements = parseFileToListOfStringArrays(MICROSCOPE_RESULTS);
        splitTheMeasurements(measurements);
        writeListToFile(FIRST_LASER_MEASUREMENTS, "first_laser.txt");
        writeListToFile(SECOND_LASER_MEASUREMENTS, "second_laser.txt");
        writeListToFile(THIRD_LASER_MEASUREMENTS, "third_laser.txt");
        writeListToFile(FORTH_LASER_MEASUREMENTS, "forth_laser.txt");
    }
}


