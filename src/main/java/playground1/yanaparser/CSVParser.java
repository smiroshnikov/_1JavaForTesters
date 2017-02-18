package playground1.yanaparser;

/*
 * CSV file reader for Yana's results from laser microscope
 * have a big text file with values delimited by space , need to remove timestamp and create a separate file
 * for each 4th measuremen line
 */

// LESSONS LEARNED - use a small fucking file for testing with simple easily read predefined values !
//TODO  DONT USE " " - no idea why , use "\\s+" -  research online later !!!
// ALWAYS , сцуко !  ALWAYS , use paper and pen and write down how you will implement things - this could have saved time
// Refactor as soon as you are sure what the required snippet of code does !

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//int offsetp[0.3] line from offset
//[2,6,10,14]


public class CSVParser {
    public static final File MAC_FILE_PATH = new File("/Users/sergei.miroshnikov/Downloads/testYana.csv");
    public static final File WIN_FILE_PATH = new File("C:\\Webdrivers\\csv\\cleanMockup.txt");

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
        List<String[]> firstLaser = new ArrayList<>();
        List<String[]> secondLaser = new ArrayList<>();
        List<String[]> thirdLaser = new ArrayList<>();
        List<String[]> forthLaser = new ArrayList<>();

        // TODO separate as method
        int lineCounter = 0;

        for (String[] cleanLine :
                cleanMeasurements) {
            if ((lineCounter % 4 == 0)) {
                firstLaser.add(cleanLine);
            }
            if (lineCounter % 4 == 1) {
                secondLaser.add(cleanLine);
            }
            if (lineCounter % 4 == 2) {
                thirdLaser.add(cleanLine);
            }
            if (lineCounter % 4 == 3) {
                forthLaser.add(cleanLine);
            }
            lineCounter += 1;
        }


        printListWitharrays(secondLaser);


    }
}