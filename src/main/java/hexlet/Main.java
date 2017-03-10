package hexlet;

public class Main {
    public static void main(String[] args) {
        final Tuple<String> stringTuple = new Tuple<>("left", "right");
        System.out.println(stringTuple.getLeft());
        final Tuple<Integer> integerTuple = new Tuple<>(1, 234);
        System.out.println(integerTuple.getLeft() + 25);
        // here we can see the whole beauty of generics , I had no idea how my generic tuple will be used
        // or with what classes it will be instantiated
        final Tuple<SuperClass> superClassTuple = new Tuple<>(new SuperClass(), new SuperClass());
        System.out.println(superClassTuple.getLeft().toString());

        final ImprovedTuple<Long, String> improvedTuple = new ImprovedTuple<>(9L, "Bob Bobbovitch");
        System.out.println(improvedTuple.process(9L));
        System.out.println(improvedTuple.process(0L));
        System.out.println(improvedTuple.process(19L));


    }

    public static class SuperClass {
        @Override
        public String toString() {
            return "Super Puper";
        }
    }
}
