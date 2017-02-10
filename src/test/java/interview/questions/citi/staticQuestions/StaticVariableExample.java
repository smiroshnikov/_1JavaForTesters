package interview.questions.citi.staticQuestions;

public class StaticVariableExample {


    public static void main(String[] args) {
        // three instances of the same class , they all share same numberCount
        StaticVariableClass firstInstantiation = new StaticVariableClass();
        StaticVariableClass secondInstantiation = new StaticVariableClass();
        StaticVariableClass thirdInstantiation = new StaticVariableClass();

        firstInstantiation.increment();
        System.out.printf("numberCount = %d%n", StaticVariableClass.numberCount);
        secondInstantiation.increment();
        System.out.printf("numberCount = %d%n", StaticVariableClass.numberCount);
        thirdInstantiation.increment();
        System.out.printf("numberCount = %d%n", StaticVariableClass.numberCount);


    }

}
