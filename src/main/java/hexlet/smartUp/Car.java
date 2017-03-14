package hexlet.smartUp;

/**
 * Created by miross1 on 3/14/2017.
 * The idea is to understand when value is present on stack and when it
 * is present /changed on heap, remember that <this> always refers to current instance of the class
 * this file needs to be debugged couple of times if I want this to settle well
 */

public class Car {
    int speed;

    public static void main(String[] args) {
        Car ta4ka = new Car();

        //     System.out.println("speed в хипе при создании объекта - NULL");// не выводит NULL :(
        System.out.println(ta4ka.speed);
        ta4ka.setSpeed(12);

    }

    public void showSpeed() {
        System.out.println("speed в heap заданый методом setSpeed- " + this.speed);
    }

    public void setSpeed(int newSpeed) {
        this.speed = newSpeed; //записываем по ссылке в heap
        showSpeed();
        newSpeed = 8; //записали новое значение в stack
        System.out.println("переменная newSpeed в фрейме стека- " + newSpeed);
        System.out.println("присваиваем переменной speed новое значение = 3");
        speed = 3; //В стеке нет такой переменной, потому она будет записана в хип!
        System.out.println("Java сама добавила this и записала новое значение speed в хип- " + this.speed);
        setSetSpeed(newSpeed);
    }

    private void setSetSpeed(int newSpeed) { //теперь и в стеке есть своя переменная speed !!!
        System.out.println("Значение speed в хипе- " + this.speed);
        speed = speed;//в стеке само себя переприсваивает
        System.out.println("переменная speed в фрейме стека- " + speed);
        System.out.println("присваиваем значение speed из фрейма стека значению speed в хипе!");
        this.speed = speed;//присваиваем значение speed из фрейма значению speed в хипе!
        System.out.println("Значение speed заданое уже методом setSetSpeed  " + this.speed); //показываем speed из хипа
    }

}
