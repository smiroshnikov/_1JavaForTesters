package playground1;

public class Preferences {
    private static Preferences instance = null;
    private String defaultValue = "null";

    /*
     * No other classes can instantiate singleton
     */
    private Preferences() {
        this.defaultValue = "Bred";
    } // private constructor

    private synchronized static void createInstance() {
        if (instance == null) {
            instance = new Preferences();
        }
    }

    /**
     * Access method top get hold of singleton instance
     *
     * @return the one singletone instance
     */
    public static Preferences getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

}
