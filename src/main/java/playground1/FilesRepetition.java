package playground1;


import java.io.File;
import java.io.IOException;
import java.util.Random;

public class FilesRepetition {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String generateRandomString(int desiredLength) {
        String randomString = "";
        Random R = new Random();
        for (int i = 0; i < desiredLength; i++) {
            randomString += ALPHABET.charAt(R.nextInt(ALPHABET.length()));
        }
        return randomString;
    }

    public static void main(String[] args) {
        File pointerToFile = new File("myFile.txt");
        System.out.println("file created " + pointerToFile.exists());
        try {
            if (pointerToFile.createNewFile()) {
                System.out.println("file created @ " + pointerToFile.getAbsolutePath());
                System.out.println("is it a directory ? " + pointerToFile.isDirectory());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println(pointerToFile.exists());
            //System.out.println("file deleted " + pointerToFile.delete());
        }
        String content = generateRandomString(12);
        System.out.println(content);


    }
}
