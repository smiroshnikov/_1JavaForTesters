package javaForTesters.chapter19;


import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.util.Date;

import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
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
        if (toThis.exists()) {
            System.out.println(".copy duplicate already existed ... deleting \n" + toThis.delete());
        }
        Files.copy(copyThis.toPath(), toThis.toPath());
        toThis = new File(copyThis.getCanonicalPath() + ".moved");
        Files.move(copyThis.toPath(), toThis.toPath(), REPLACE_EXISTING, ATOMIC_MOVE);

    }

    @Test
    public void myMove() throws IOException {
        // Working creating , copying  and moving a file with permissions if required
        // TODO go over a file constructor untill I will feel comfortable enough
        File myFolder = new File(System.getProperty("java.io.tmpdir") +
                System.currentTimeMillis() + "FU", "fuck");
        System.out.println(myFolder.getAbsolutePath());
        System.out.println("Folder created ... " + myFolder.mkdirs());
        File fileWithSecretContent = createBatchFile(new File(System.getProperty("java.io.tmpdir") + "secret.orig"),
                new String[]{"fuck", "you"});
        File destination = new File(myFolder.getCanonicalPath(), "secret.copy");
        Files.copy(fileWithSecretContent.toPath(), destination.toPath());
        File moveDestination = new File(myFolder.getCanonicalPath(), "secret.move");
        Files.move(fileWithSecretContent.toPath(), moveDestination.toPath());
        System.out.println(fileWithSecretContent.getCanonicalPath());

    }

}
