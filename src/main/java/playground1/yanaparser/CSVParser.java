package playground1.yanaparser;


// TODO - rewrite thre fucking Code as intended and stop monley patching !
// Results class was a good idea , lets keep going in that direction !

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

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVParser {
    //public static final File MAC_FILE_PATH = new File("/Users/sergei.miroshnikov/Downloads/mos2_vertical_30sec_3acc_green laser ulf_600 greating_10per_mapping_23hr_121216.txt");
    //public static final File WIN_FILE_PATH = new File("C:\\Webdrivers\\csv\\cleanMockup.txt");
    public static final File WIN_FILE_PATH = new File("C:\\Webdrivers\\csv\\mos2_vertical_30sec_3acc_green laser ulf_600 greating_10per_mapping_23hr_121216.txt");
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

        // TODO initialize variable , where its needed not in the start of function !!
        String[] axis = new String[0]; // TODO no need to initialize

        String csvSeparator = "\\s+"; // DONT  EVER FUCKING SPLIT BY " " - apparently this is not concidered as space in every OS !
        // should be a constant and initialized only once (useful if i use function more than once )
        List<String[]> valuesList = new ArrayList<>();
        UtilityResult utilityResult = new UtilityResult(axis, valuesList); // create another constructor instead of wasting resourses
        try (BufferedReader br = new BufferedReader(new FileReader(laserMeasurmentsFile))) {
            String lineInFile;
            int lineCounter = -1;
            while ((lineInFile = br.readLine()) != null) { // use for instead of while , whoukd have had counter within loop body
                lineCounter += 1;
                axis = lineInFile.split(csvSeparator);
                if (lineCounter == 0) {
                    System.out.println("DEBUG :: INFO :: Wave Length AXIS ignored when coverted file to list...");

                    utilityResult.setAxisValues(axis);
                } else {
                    valuesList.add(axis);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        utilityResult.setValuesList(valuesList);
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
        int lineCounter;
        //  for (String[] cleanLine : fullMeasurementsList) {
        for (int i = 0; i < fullMeasurementsList.size(); i++) {
            lineCounter = i % 4;
            switch (lineCounter) {
                case 0:
                    FIRST_LASER.add(fullMeasurementsList.get(i));
                    break;
                case 1:
                    SECOND_LASER.add(fullMeasurementsList.get(i));
                    break;
                case 2:
                    THIRD_LASER.add(fullMeasurementsList.get(i));
                    break;
                case 3:
                    FORTH_LASER.add(fullMeasurementsList.get(i));
                    break;
            }
//            if ((lineCounter % 4 == 0)) {
//                FIRST_LASER.add(cleanLine);
//            }
//            if (lineCounter % 4 == 1) {
//                SECOND_LASER.add(cleanLine);
//            }
//            if (lineCounter % 4 == 2) {
//                THIRD_LASER.add(cleanLine);
//            }
//            if (lineCounter % 4 == 3) {
//                FORTH_LASER.add(cleanLine);
//            }
////            lineCounter += 1;
//        }
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
        List<String[]> corruptedMeasurements = createAlistFromFileAndRemoveAxisX(WIN_FILE_PATH);
        List<String[]> cleanMeasurements = aggregateCleanDataToList(corruptedMeasurements);
        parseResultsPerLaser(cleanMeasurements);

        printMeasurementsList(FIRST_LASER);
        printMeasurementsList(SECOND_LASER);
        printMeasurementsList(THIRD_LASER);
        printMeasurementsList(FORTH_LASER);

        // TODO file output to 4 separate files
        writeListToFile(FIRST_LASER, "first_laser.txt");
        writeListToFile(SECOND_LASER, "second_laser.txt");
        writeListToFile(THIRD_LASER, "third_laser.txt");
        writeListToFile(FORTH_LASER, "forth_laser.txt");

    }
}