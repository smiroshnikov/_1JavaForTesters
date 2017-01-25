package OCA;

abstract class Mammal {
    public static void main(String[] args) {
        System.out.println(new Capybara().hasFur());
        int x = 0;
        while (++x < 5) {
            x += 1;
        }
        String message = x > 5 ? "Greater than" : "Less than";
        System.out.println(message + "," + x);
        boolean b;


    }

    private boolean hasFur() {
        return false;
    }

    static class Capybara extends Mammal {
        public boolean hasFur() {
            return true;
        }
    }


}
