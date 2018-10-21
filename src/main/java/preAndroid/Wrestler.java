package preAndroid;

public abstract class Wrestler {
    public void paymentForWork(int hours) {
        System.out.println("The wrestler makes $" + hours * 250.00);
    }

    public abstract void themeMusic();

    public abstract void finisher();


}
