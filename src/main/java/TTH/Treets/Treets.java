package TTH.Treets;

import java.io.*;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by miross1 on 2/15/2017.
 * Following TTH classwork
 */
public class Treets {

    public static void main(String[] args) throws IOException {

        Treet treet = new Treet(
                "sergeim",
                "Want to be millionaire like me ? Then buy my new book 'How to get a high-tech job " +
                        "without any education?!' ",
                new Date(1483228860000L));

        Treet treet2 = new Treet(
                "mukih",
                "Looking to save money , urgent and cheap serious only ...' ",
                new Date(1483228860009L));

        Treet treet3 = new Treet(
                "donaldt",
                "Blah blah BUBUBUBUBUBUBUUUU ..... ",
                new Date(1483228860220L));

        Treet[] treets = {treet, treet2, treet3};
        Treets.save(treets);
        Treet[] reloadedTreets = Treets.load();
        Arrays.sort(reloadedTreets);
        for (Treet t :
                reloadedTreets) {
            System.out.println(t);
        }
    }

    public static void save(Treet[] treets) throws IOException {
        try (
                FileOutputStream fos = new FileOutputStream("treets.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(treets);
        } catch (IOException ioe) {
            System.out.println("Problem performing file save, check folder permissions !");
            ioe.printStackTrace();
        }
    }

    public static Treet[] load() {
        Treet[] treets = new Treet[0];
        // Why [0]
        try (
                FileInputStream fis = new FileInputStream("treets.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            treets = (Treet[]) ois.readObject(); // Woooooooooooowwwww!!!
        } catch (IOException ioe) {
            System.out.println("Corrupted file , cannot read!");
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfr) {
            System.out.println("No idea what to write here ...");
            cnfr.printStackTrace();
        }
        return treets;
    }

}
