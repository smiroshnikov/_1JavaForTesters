package chapter19;


import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;

public class DirectoryTests {

    @Test
    public void listTempDirectory() {
        // shows files in specific directory
        File tempDir = new File(System.getProperty("java.io.tmpdir"));
        // TODO the code below for some reason creates a file and further program execution results in NullPointerException
        //File tempDir = new File(System.getProperty("java.io.tmpdir"+"123"));

        File[] fileList = tempDir.listFiles();
        String[] stringFileList = tempDir.list();
//        if (stringFileList != null) {
//            for (String s : stringFileList) {
//                System.out.println(s);
//            }
//        }
        System.out.println("===========================same idea with filelist======================".toUpperCase());
        if (fileList != null) {
            for (File f :
                    fileList) {
                if (f.isDirectory()) {
                    System.out.println("DR->" + f.toString());
                    // TODO change date format, trim GMT and keep year , maybe Calendar or Stringbuilder
                    System.out.printf("X [%b] , RD[%b], WR[%b], last modified [%s] %n",
                            f.canExecute(), f.canRead(), f.canWrite(), (String.valueOf(new Date(f.lastModified()))));
                }
                System.out.println("FL->" + f.toString());
                System.out.printf("X [%b] , RD[%b], WR[%b], last modified [%s] %n",
                        f.canExecute(), f.canRead(), f.canWrite(), (String.valueOf(new Date(f.lastModified()))));
            }
        }
    }

    @Test
    public void permissionsExample() throws IOException {
        File littleSpy = new File(System.getProperty("java.io.tmpdir"), "spy.bat");
        System.out.println(littleSpy.getAbsolutePath());
        System.out.println("File created " + littleSpy.createNewFile());
        String fileContent = "\t\n" +
                "@echo off\n" +
                "echo Hello world.\n" +
                "pause";



    }
}
