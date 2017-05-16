package playground1.experimentMAY17;

/**
 * Created by smiroshn on 5/16/17.
 * Needed to create a method that assign a 0 to value if value is not provided
 */
public class DefaultValueInMethod {
    private static void methodThatHasDefaultValueAssignment(String defaultValueThatCanBeOverriden) {
        defaultValueThatCanBeOverriden = defaultValueThatCanBeOverriden != null ? defaultValueThatCanBeOverriden : "default";
        System.out.printf("Value is -> %s%n", defaultValueThatCanBeOverriden);
    }

    public static void main(String[] args) {
        methodThatHasDefaultValueAssignment(null);
        methodThatHasDefaultValueAssignment("My Overridden String value !");
    }

}
