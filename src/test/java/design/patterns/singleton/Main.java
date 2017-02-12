package design.patterns.singleton;


public class Main {
    public static void main(String[] args) {
        BestQA sergei = BestQA.getInstance();
        System.out.println(sergei.getName().toUpperCase() + " " + sergei.getIQScore());
    }
}
