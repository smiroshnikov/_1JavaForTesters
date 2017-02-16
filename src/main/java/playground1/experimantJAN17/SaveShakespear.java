package playground1.experimantJAN17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class SaveShakespear {
    // https://www.zybooks.com
    public static void main(String[] args) throws IOException {
        // cool stuff from strteams
        // https://www.youtube.com/watch?v=3YRahx2ltSg

        URL url = new URL("http://www.gutenberg.org/cache/epub/2265/pg2265.txt");
        InputStream urlStream = url.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlStream));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }


    }

}
