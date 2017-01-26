package playground1;

import java.io.File;
import java.io.IOException;

public class FilePractice {
    public static void main(String[] args) throws IOException {

        // Where , and by what name ....
        File pathDescriptor = new File("myFirstFile.conf");
        // We have prepared a path ?
        System.out.println("does it exists ? ->" + pathDescriptor.exists());
        System.out.println("where ? ->" + pathDescriptor.getAbsolutePath());
        // Empty fileCreation is performed here
        pathDescriptor.createNewFile();

        System.out.println("does it exists ? ->" + pathDescriptor.exists());
        System.out.println("where ? ->" + pathDescriptor.getAbsolutePath());


    }
}
