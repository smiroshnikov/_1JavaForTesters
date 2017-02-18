package playground1.yanaparser;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//int offsetp[0.3] line from offset
//[2,6,10,14]


public class CSVParser {
    public static final File MAC_FILE_PATH = new File("/Users/sergei.miroshnikov/Downloads/testYana.csv");
    public static final File WIN_FILE_PATH = new File("C:\\Webdrivers\\csv\\mos2_vertical_30sec_3acc_green laser ulf_600 greating_10per_mapping_23hr_121216.txt");

    /**
     * Removes millisecond timestamp from laser measurment line
     *
     * @param dirtyLine - line with timestamp
     * @return String[] with values only
     */
    public static String[] cleanLineWithValues(String[] dirtyLine) {
        return Arrays.copyOfRange(dirtyLine, 1, dirtyLine.length);
    }

    /**
     * Reads file line by line and returns each line as an array of Strings
     *
     * @param laserMeasurmentsFile - a file from the laser microscope
     * @return List of String [] - each array represents a line with values from file
     */
    public static List<String[]> createAlistFromFile(File laserMeasurmentsFile) {
        String lineInFile;
        int lineCounter = -1;
        String csvSeparator = "\\s+"; // DONT  EVER FUCKING SPLIT BY " " - apparently this is not concidered as space in every OS !
        List<String[]> valuesList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(laserMeasurmentsFile))) {
            while ((lineInFile = br.readLine()) != null) {
                lineCounter += 1;
                if (lineCounter == 0) {
                    System.out.println("Header ignored when coverted file to list...");
                } else {
                    valuesList.add(lineInFile.split(csvSeparator));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return valuesList;
    }

    /**
     * Utility method that prints a List of String arrays - used for debugging
     *
     * @param list
     */
    public static void printListWitharrays(List<String[]> list) {
        for (String[] lineWithExcessiveValuesInarray :
                list) {
            System.out.printf("%n");
            //System.out.println(lineWithExcessiveValuesInarray.length);
            for (String singleMeasurement :
                    lineWithExcessiveValuesInarray) {
                System.out.print(singleMeasurement + " ");
            }
        }

    }

    /**
     * Truncates corrupted measurements from List of Strings provided as an argument.
     * Invokes "cleanMeasurements" method , that removes first member from  each String[].
     *
     * @param corruptedMeasurements - list with timestamp in milliseconds
     * @return
     */
    public static List<String[]> extractCleanMeasurements(List<String[]> corruptedMeasurements) {
        List<String[]> cleanMeasurements = new ArrayList<>();
        for (String[] corruptedLine :
                corruptedMeasurements) {
            cleanMeasurements.add(cleanLineWithValues(corruptedLine));
        }
        return cleanMeasurements;
    }

    public static void main(String[] args) throws IOException {
        List<String[]> corruptedMeasurements = createAlistFromFile(WIN_FILE_PATH);
        List<String[]> cleanMeasurements = extractCleanMeasurements(corruptedMeasurements);
        int lineCounter = 0;
        do {
            lineCounter += 1;

        } while (lineCounter != cleanMeasurements.size());
        printListWitharrays(cleanMeasurements);


    }
}