package playground1.experimantJAN17;


import java.io.*;
import java.util.Random;

public class FilesRepetition {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String generateRandomString(int desiredLength) {
        String randomString = "";
        Random R = new Random();
        for (int i = 0; i < desiredLength; i++) {
            randomString += "\n" + ALPHABET.charAt(R.nextInt(ALPHABET.length()));
        }
        return randomString;
    }

    public static void main(String[] args) throws IOException {

        File pointerToFile = new File("myFile.txt");
//        System.out.println("file created " + pointerToFile.exists());
//        try {
//            if (pointerToFile.createNewFile()) {
//                System.out.println("file created @ " + pointerToFile.getAbsolutePath());
//                System.out.println("is it a directory ? " + pointerToFile.isDirectory());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            System.out.println(pointerToFile.exists());
//            //System.out.println("file deleted " + pointerToFile.delete());
//        }

        //OutputStream stream = new FileOutputStream(pointerToFile);
        //OutputStream stream1 = new PrintStream(pointerToFile);
        PrintWriter print = new PrintWriter(new BufferedWriter(new FileWriter(pointerToFile)));

        for (int i = 0; i < 10000; i++) {
            String content = generateRandomString(new Random().nextInt(20));
            print.println(content);
        }
        print.close();
    }
}
