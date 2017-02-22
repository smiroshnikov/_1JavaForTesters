package playground1.yanaparser;

/*
 * CSV file reader for Yana's results from laser microscope
 * have a big text file with values delimited by space , need to remove timestamp and create a separate file
 * for each 4th measuremen line
 */
// version 2
// LESSONS LEARNED - use a small fucking file for testing with simple easily read predefined values !
// DONT USE " " - no idea why , use "\\s+" -  research online later !!!
// ALWAYS , сцуко !  ALWAYS , use paper and pen and write down how you will implement things - this could have saved time
// Refactor as soon as you are sure what the required snippet of code does !

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVParser {
    //public static final File MAC_FILE_PATH = new File("/Users/sergei.miroshnikov/Downloads/testYana.csv");
    public static final File WIN_FILE_PATH = new File("C:\\Webdrivers\\csv\\cleanMockup.txt");
    //public static final File WIN_FILE_PATH = new File("C:\\Webdrivers\\csv\\mos2_vertical_30sec_3acc_green laser ulf_600 greating_10per_mapping_23hr_121216.txt");
    public static final List<String[]> FIRST_LASER = new ArrayList<>();
    public static final List<String[]> SECOND_LASER = new ArrayList<>();
    public static final List<String[]> THIRD_LASER = new ArrayList<>();
    public static final List<String[]> FORTH_LASER = new ArrayList<>();

    /**
     * Removes millisecond timestamp from laser measurment line
     *
     * @param dirtyLine - line with timestamp
     * @return String[] with values only
     */
    public static String[] removeTimestampFromLine(String[] dirtyLine) {
        return Arrays.copyOfRange(dirtyLine, 1, dirtyLine.length);
    }

    /**
     * Reads file line by line and returns each line as an array of Strings
     *
     * @param laserMeasurmentsFile - a file from the laser microscope
     * @return List of String [] - each array represents a line with values from file
     */
    public static List<String[]> createAlistFromFileAndRemoveAxisX(File laserMeasurmentsFile) {
        // TODO separate AXIS removal (and saving it aside) in separate method
        String lineInFile;
        int lineCounter = -1;
        String csvSeparator = "\\s+"; // DONT  EVER FUCKING SPLIT BY " " - apparently this is not concidered as space in every OS !
        List<String[]> valuesList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(laserMeasurmentsFile))) {
            while ((lineInFile = br.readLine()) != null) {
                lineCounter += 1;
                if (lineCounter == 0) {
                    System.out.println("DEBUG :: INFO :: Wave Length AXIS ignored when coverted file to list...");
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
    public static void printMeasurementsList(List<String[]> list) {
        for (String[] lineWithMillisecondTimestamp :
                list) {
            System.out.printf("%n");
            //System.out.println(lineWithMillisecondTimestamp.length);
            for (String singleMeasurement :
                    lineWithMillisecondTimestamp) {
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
    public static List<String[]> aggregateCleanDataToList(List<String[]> corruptedMeasurements) {
        List<String[]> cleanMeasurements = new ArrayList<>();
        for (String[] corruptedLine :
                corruptedMeasurements) {
            cleanMeasurements.add(removeTimestampFromLine(corruptedLine));
        }
        return cleanMeasurements;
    }

    public static void parseResultsPerLaser(List<String[]> fullMeasurementsList) {
        int lineCounter = 0;
        for (String[] cleanLine :
                fullMeasurementsList) {
            if ((lineCounter % 4 == 0)) {
                FIRST_LASER.add(cleanLine);
            }
            if (lineCounter % 4 == 1) {
                SECOND_LASER.add(cleanLine);
            }
            if (lineCounter % 4 == 2) {
                THIRD_LASER.add(cleanLine);
            }
            if (lineCounter % 4 == 3) {
                FORTH_LASER.add(cleanLine);
            }
            lineCounter += 1;
        }
    }

    public static void main(String[] args) throws IOException {
        List<String[]> corruptedMeasurements = createAlistFromFileAndRemoveAxisX(WIN_FILE_PATH);
        List<String[]> cleanMeasurements = aggregateCleanDataToList(corruptedMeasurements);
        parseResultsPerLaser(cleanMeasurements);
        printMeasurementsList(FIRST_LASER);
        printMeasurementsList(SECOND_LASER);
        printMeasurementsList(THIRD_LASER);
        printMeasurementsList(FORTH_LASER);
        // TODO file output to 4 separate files
    }
}