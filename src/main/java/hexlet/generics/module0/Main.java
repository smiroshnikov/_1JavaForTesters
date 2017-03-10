package hexlet.generics.module0;

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

        /*
        Now I want to inherit my tuple to become triple and I want to keep the universal approach
        lets test this with Triple filled with my SuperClass as middle variable
         */
        Triple<Integer, SuperClass, String> triple = new Triple<>(35, new SuperClass(), "randonstring");
        Triple<Double, Long, Long> differentTriple = new Triple<>(0.1d, 0L, System.currentTimeMillis());
        System.out.println(triple.getBody().toString()); // Should be overriden toString from SuperClass!
        System.out.println(differentTriple.process(0.1d));
        System.out.println(differentTriple.getIndex() + "---" + differentTriple.getBody() + "---" + differentTriple.process(1.0));


    }

    public static class SuperClass {
        @Override
        public String toString() {
            return "Super Puper";
        }
    }
}
