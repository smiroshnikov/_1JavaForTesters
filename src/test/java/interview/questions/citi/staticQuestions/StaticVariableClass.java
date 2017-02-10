package interview.questions.citi.staticQuestions;

/**
 * This class hold 1 static variable that will be
 * shared among all instantiations of this class
 */
public class StaticVariableClass {
    public static int numberCount = 0;

    public void increment() {
        numberCount += 1;
    }

}
