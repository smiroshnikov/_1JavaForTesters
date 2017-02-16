package playground1.experimentFEB17.Singleton;

/**
 * Created for Prefrences
 */
public class Client {
    public static void main(String[] args) {
        Preferences test = Preferences.getInstance();
        System.out.println(test);
    }
}
