package interview.questions.citi.singleton;

/**
 * Testing , the output show SAME objct instance
 */
public class TestUniquenessOfSingleton {
    public static void main(String[] args) {

        SingletonPresident iidwuurliikTheFirstAndOnly = SingletonPresident.getInstance();
        System.out.println(iidwuurliikTheFirstAndOnly.toString());
        SingletonPresident trump;
        trump = SingletonPresident.getInstance();
        System.out.println(trump.toString());
        SingletonPresident hillary = SingletonPresident.getInstance();
        System.out.println(hillary.toString());


    }
}
