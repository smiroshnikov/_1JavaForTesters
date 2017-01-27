package playground1;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileCreation {
    public static void main(String[] args) throws IOException {
        // TODO why do I need to add IOException to method signature ? It is my desision where
        // TODO to process exception
        // TODO what is a method signature ? To chto v skobkah
        File secretData = new File("secretPassword.txt");
        System.out.println(secretData.getCanonicalPath()); // System dependent
        System.out.println(secretData.getAbsoluteFile());
        System.out.println("file exists ? " + secretData.exists());
        // TODO secretData.createNewFile() is not used .. I wonder why
        // Streams are used not only for files , but for other things as well
        String secretFileContent = "abcdefbuiysjkhgdfksjdhfskjhk" +
                "jklsdhfkjsdhfkjshdfkjsdhfkjhsdjsauhdhgfjkashdfjh" +
                "sdfkhjgsdhjfgsjhdgfjhsdgfjhsdgfjhsdgjshgjhsdgfsadgf";
        OutputStream outputStream = new FileOutputStream(secretData);
        System.out.println("file exists  ?  stream initialized  " + secretData.exists());
        // stream cannot work with String
        // IDE suggested INT?
        //outputStream.write(Integer.parseInt(secretFileContent));
        outputStream.write(secretFileContent.getBytes());
        // TODO why if I used getBytes file content is not 01010101110100001 A - byte not bit !
        System.out.println("file exists after stream.write used ? " + secretData.exists());
        outputStream.close();
        System.out.println("file exists  , stream closed ? " + secretData.exists());
        // commented deletion , need for next tutorial existing file
        // TODO create CSV to toy with
        //System.out.println("file deleted " + secretData.delete());
    }
}
