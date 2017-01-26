package chapter19;

import org.junit.Test;

import java.io.*;

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


}
