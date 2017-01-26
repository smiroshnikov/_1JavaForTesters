package playground1;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class EmptyFileCreation {
    public static void main(String[] args) throws IOException {

        // Where , and by what name ....
        File pathOrDescriptor = new File("myFirstFile.conf");
        // We have prepared a path ?
        System.out.println("where file will be created @ ? ->" + pathOrDescriptor.getAbsolutePath());
        System.out.println("does it exists ? ->" + pathOrDescriptor.exists() + " not created yet ");
        // Empty fileCreation is performed here
        // I am calling file creation method from within assertion , but it still works
        // because createNewFile returns true if file with same name did not exist is created
        assertThat(pathOrDescriptor.createNewFile(), is(true));
        // fails if file is already created
        System.out.println("does it exists ? ->" + String.valueOf(pathOrDescriptor.exists()).toUpperCase() + " was created just now  ");
        assertThat(pathOrDescriptor.delete(), is(true));
        // should fail if the file is not present and is not deleted
        System.out.println("does it exists ? ->" + pathOrDescriptor.exists() + " was deleted ");


    }
}
