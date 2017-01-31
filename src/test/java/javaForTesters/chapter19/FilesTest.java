package javaForTesters.chapter19;

import org.junit.Test;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FilesTest {

    private static File filesLesson1() throws IOException {
        //Valid
        //File file = new File(System.getProperties().getProperty("user.home"));

        File outputfile = File.createTempFile("myFile", ".txt");
        PrintWriter print = new PrintWriter(new BufferedWriter(new FileWriter(outputfile)));
        // What is this ?! Whats it is needed for ?

        for (int lineNumber = 0; lineNumber < 6; lineNumber++) {
            print.println("line" + lineNumber);
        }
        print.close();
        return outputfile;
    }

    @Test
    public void outputFileToSystemOutWithBufferedReader() throws IOException {
        File inputFile = filesLesson1();
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                System.out.println(line);
                System.out.println(line);
            }
        } finally {
            reader.close();
        }

    }

    @Test
    public void listRootsExample() {
        File[] roots = File.listRoots();
        for (File f :
                roots) {
            System.out.println(f.getAbsolutePath());

        }
    }

    @Test
    public void aNewFileDoesNotCreateAFile() throws IOException {
        File aTempFile = new File("d:/tempJavaForTesters.txt");
        assertThat(aTempFile.exists(), is(false));
        // File also has static methods for temp files
        File tempFile = File.createTempFile("___", null, null);
        tempFile.deleteOnExit();

    }

    @Test
    public void createMyCustomTemFile() throws IOException {
        File meTempFile = new File(String.valueOf(System.getProperties().getProperty("java.io.tmpdir")),
                "secretTMPFile" + String.valueOf(System.currentTimeMillis()) + ".tmp");
        System.out.println(meTempFile.getAbsolutePath());
        System.out.println("filename = " + meTempFile.getName());
        assertThat(meTempFile.getName().startsWith("secret"), is(true));
        assertThat(meTempFile.createNewFile(), is(true));
        assertThat(meTempFile.delete(), is(true));
        assertThat(meTempFile.exists(), is(false));
    }

    @Test
    public void pathExample() {
        Path aPath = Paths.get(System.getProperty("java.io.tmpdir"), "1", "2", "3", "_ _% $%", "1");
        System.out.println(aPath.toAbsolutePath());
    }

    @Test
    public void directoryManipulation() {
        // TODO converting Paths to File
        String tempDirectory = System.getProperty("java.io.tmpdir");
        System.out.println(tempDirectory);
        File aDirectory = Paths.get(tempDirectory, Long.toString(System.currentTimeMillis()),
                "sergIndex", "Iidwuurliik", "was", "here").toFile();
        System.out.println(aDirectory.getAbsolutePath());
        assertThat(aDirectory.mkdir(), is(false));
        assertThat(aDirectory.mkdirs(), is(true));
        assertThat(aDirectory.isFile(), is(false));
        assertThat(aDirectory.isDirectory(), is(true));
        // will delete only "here" part of the path
        assertThat(aDirectory.delete(), is(true));

    }

    @Test
    public void whyShouldIUsePath() throws IOException {
        File aFile = new File(System.getProperty("java.io.tempdir"), "1.txt");
        // this also works and curently provides exactly same path absolute/cannonical
        aFile = new File(aFile, "1");
        aFile = new File(aFile, "2");
        aFile = new File(aFile, "3");
        aFile = new File(aFile, "4");
        aFile = new File(aFile, "1");
        System.out.println(aFile.getAbsoluteFile());
        System.out.println(aFile.getCanonicalPath());

    }

    @Test
    public void highLevelTextFileManipulations() throws IOException {
        // "null" as a second argument means .tmp value
        File outputFile = File.createTempFile("test", null);
        System.out.println(outputFile.getAbsolutePath());
        System.out.println(outputFile.getCanonicalPath());
        FileWriter writer = new FileWriter(outputFile);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);
        printWriter.println("===============");
        printWriter.println("Automation report " + new Date(System.currentTimeMillis()).toString());
        printWriter.println("clah blah blah!");
        printWriter.println("dlah blah blah!");
        printWriter.println("flah blah blah!");
        assertThat(outputFile.exists(), is(true));

        printWriter.close();
        // this is annoying but important the whole idea was
        // to add more data to file after it was closed
        // TODO ask Max what is the difference between instantiation and what is below
        writer = new FileWriter(outputFile, true);
        bufferedWriter = new BufferedWriter(writer);
        printWriter = new PrintWriter(bufferedWriter);

        printWriter.println("this is additional line ");
        printWriter.println("this is additional line ");
        printWriter.println("this is additional line ");
        printWriter.println("this is additional line ");
        printWriter.close();
    }

    @Test
    public void writingDirectlyWthFileWriter() throws IOException {
        // TODO clarify everything regarding exception delegation !
        // So I have added exception handling to method signature and ?
        // Where it will be handled ? In main ? How ? there is no try catch in main ...
        File outputFile = File.createTempFile("filewriterExample", null);
        System.out.println(outputFile.getAbsoluteFile());
        System.out.println("this is tempdir ->" + System.getProperty("java.io.tmpdir"));
        // this is raw test writer
        FileWriter fileWriter = new FileWriter(outputFile);
        fileWriter.write("line 1 info ");
        fileWriter.write("line 2 info ");
        fileWriter.write("line 3 info ");
        fileWriter.close();
    }

    @Test
    public void readingFilesExample() throws IOException {
        //"FileReader" is a wrapper around InputStreamReader and FileInputStream which
        //uses the default character encoding stream.
        //"BufferedReader" makes the reading more efficient
        // will fail on any other env due to missing file and different timestamp
        // just wanted different file !
        //File inputFile = new File(System.getProperty("java.io.tmpdir") +
        //"filewriterExample8697030070110782251.tmp");
        File inputFile = new File(System.getProperty("java.io.tmpdir") +
                "test524827089091670596.tmp");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    @Test
    public void spaceCalculations() {
        File victim = new File(System.getProperty("java.io.tmpdir") +
                "test524827089091670596.tmp");
        //System.out.println(victim.listRoots()[0]);
        System.out.println(File.listRoots()[0]);
        System.out.printf("Disk %s size is %d GB %n", File.listRoots()[0].toString(), victim.getTotalSpace() / 1024 / 1024 / 1024);
        System.out.printf("Free space on %s is %d GB %n", File.listRoots()[0].toString(), victim.getFreeSpace() / 1024 / 1024 / 1024);
        System.out.printf("Created file size is %d bytes", (victim.length()));
        System.out.printf("Space avaliable for my text file is " + victim.getUsableSpace() / 1024 / 1024 / 1024 + " GB");
    }

    @Test
    public void spaceTestSolution() throws IOException {
        File dataFile = writeTheTestDataFile(200);
        System.out.println(dataFile.getAbsolutePath());
        System.out.println(expectedFileSize(200));
        File emptyFile = writeTheTestDataFile(0);
        System.out.println(emptyFile.getAbsolutePath());
        System.out.println(expectedFileSize(0));


    }

    /**
     * @param lines integer that defines number of lines in file
     * @return length of each line + system endline size multiplied by lines
     */
    private long expectedFileSize(int lines) {
        String lineEnd = System.lineSeparator();
        return ("line xxx".length() + lineEnd.length() * lines);
    }

    /**
     * @param lines Integer - desired number of lines in an output file
     * @return file with user defined number of lines
     * @throws IOException that is handled in main
     */
    private File writeTheTestDataFile(int lines) throws IOException {
        File outputFile = File.createTempFile("forReading" + lines + "_", null);
        PrintWriter print = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(outputFile)));
        for (int line = 0; line < lines; line++) {
            print.println("line" + lines);
        }
        print.close();
        return outputFile;
    }

}
