package playground1.experimentJAN17;
// TODO make the car exercise you had at REDBEND , parsing file with car details into array
// TODO File , Buffer and String manipulation (couple of silly real world projects )
// TODO "Acura", 2017 , 600cc , 200MPH , 2 seats , "Blue", 1200000$ , in production : [12]

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
