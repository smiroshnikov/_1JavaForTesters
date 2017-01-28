package chapter19;


import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DirectoryTests {

    @Test
    public void listTempDirectory() {
        // shows files in specific directory
        File tempDir = new File(System.getProperty("java.io.tmpdir"));
        // TODO the code below for some reason creates a file and further program execution results in NullPointerException
        //File tempDir = new File(System.getProperty("java.io.tmpdir"+"123"));

        File[] fileList = tempDir.listFiles();
//        String[] stringFileList = tempDir.list();
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
        // TODO execution of file "ProcessBuilder" or "Process"
        String[] fileContent = {"@echo off", "echo YOU HAVE BEEN HACKED BY 11dwuur11k.", "pause"};
        File littleSpy = createBatchFile(new File(System.getProperty("java.io.tmpdir"),
                "spyFORIidwuurliik.bat"), fileContent);
        System.out.println(littleSpy.getAbsolutePath());
        System.out.println("x permission granted ...[" + littleSpy.setExecutable(true) + "]");
        assertThat(littleSpy.exists(), is(true));

    }

    private File createBatchFile(File file, String[] fileContent) throws IOException {
        FileWriter writer = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);
        for (String line :
                fileContent) {
            printWriter.println(line);
        }
        printWriter.close();
        return file;
    }

    @Test
    public void copyFileSample() throws IOException {

        File copyThis = createBatchFile(new File("test.txt"), new String[]{"fuck", "you"});
        System.out.println(copyThis.getAbsolutePath());
        File toThis = new File(copyThis.getCanonicalPath() + ".copy");
        Files.copy(copyThis.toPath(), toThis.toPath());


    }

}
