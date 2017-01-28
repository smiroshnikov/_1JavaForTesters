package chapter19;


import org.junit.Test;

import java.io.File;

public class DirectoryTests {

    @Test
    public void listTempDirectory() {
        // shows files in specific directory
        File tempDir = new File(System.getProperty("java.io.tmpdir"));
        // TODO the code below for some reason creates a file and further program execution results in NullPointerException
        //File tempDir = new File(System.getProperty("java.io.tmpdir"+"123"));

        File[] fileList = tempDir.listFiles();
        String[] stringFileList = tempDir.list();
        if (stringFileList != null) {
            for (String s : stringFileList) {
                System.out.println(s);
            }
        }
        System.out.println("===========================same idea with filelist======================".toUpperCase());
        if (fileList != null) {
            for (File f :
                    fileList) {
                System.out.println(f.toString());
            }
        }
    }
}
