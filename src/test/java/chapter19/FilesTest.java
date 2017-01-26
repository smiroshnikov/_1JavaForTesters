package chapter19;

import org.junit.Test;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

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
        Path aPath = Paths.get(System.getProperty("java.io.tmpdir"), "1", "2", "3");

    }


}
