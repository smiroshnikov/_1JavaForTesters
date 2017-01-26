package playground1;

import java.io.*;

public class ReadFromFile {
    public static void main(String[] args) throws IOException {
        // TODO Why do we need to add exeption to method signature ?
        File myDreams = new File("secretText.txt");
        // retgurned true , file exist cause I prepared it ahead
        System.out.printf("file %s exists = %b %n", myDreams.toString(), myDreams.exists());

        BufferedReader bufferedReader = new BufferedReader
                (new InputStreamReader(new FileInputStream(new File("secretText.txt"))));
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line.toUpperCase());
        }
        bufferedReader.close();


    }

}
