package interview.questions.citi.singleton;

/**
 * Q: desing and implement a singleton pattern
 * example of usage - instantiate a web driver as a singleton
 * Private constructor to restrict instantiation of the class from other classes.
 * Private staticQuestions variable of the same class that is the only instance of the class.
 * Public staticQuestions method that returns the instance of the class, this is the global
 * access point for outer world to get the instance of the singleton class.
 */
public class SingletonPresident {

    private static SingletonPresident instance;

    private SingletonPresident() {
    }

    public static SingletonPresident getInstance() {
        if (instance == null) {
            instance = new SingletonPresident();
        }
        return instance;
    }
}
