package design.patterns.singleton;

/**
 * TODO lets have some parameters in out Singleton
 */
public class BestQA {
    private static BestQA instance;
    private String name;
    private int IQScore;

    private BestQA() {
        name = "Sergei Miroshnikov";
        IQScore = 161;


    }

    public static BestQA getInstance() {
        if (instance == null) {
            instance = new BestQA();
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public int getIQScore() {
        return IQScore;
    }
}
