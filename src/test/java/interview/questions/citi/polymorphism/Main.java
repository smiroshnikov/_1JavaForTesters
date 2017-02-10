package interview.questions.citi.polymorphism;

/* I was asked to give example and explanation of polymorphism to someone who is not familiar with programming with an example
  the code below describes an array of Animals , but has different implementations(forms) of "move()" method per Animal
   as I understand , animal is not casted to other classes . So in out case array sundayMonday has many forms...
  */
public class Main {

    public static void main(String[] args) {
        Animal[] sundayMonday = new Animal[5];
        Animal myAnimal = new Bird();
        Animal myAnimal2 = new Fish();
        Animal myAnimal3 = new Bird();
        Animal myAnimal4 = new Serpent();
        Animal myAnimal5 = new Bird();

        sundayMonday[0] = myAnimal;
        sundayMonday[1] = myAnimal2;
        sundayMonday[2] = myAnimal3;
        sundayMonday[3] = myAnimal4;
        sundayMonday[4] = myAnimal5;

        for (Animal a :
                sundayMonday) {
            a.move();
        }
    }
}
