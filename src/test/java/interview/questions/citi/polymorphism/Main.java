package interview.questions.citi.polymorphism;

/* I was asked to give example and explanation of polymorphism to someone who is not familiar with programming with an example
  the code below describes an array of Animals , but has different implementations(forms) of "move()" method per Animal
   as I understand , animal is not casted to other classes . So in out case array sundayMonday has many forms...polymorphed
  */
public class Main {

    public static void main(String[] args) {

        Animal[] animals = {
                new Bird(),
                new Fish(),
                new Serpent(),
                new Fish()
        };

        for (Animal a :
                animals) {
            a.move();
        }
        Animal myAnimal = new SongBird();
        myAnimal.move();// because Bird overrides animal and Songbird inherits from Bird
        // myAnimal.sing(); will not work because Superclass has no subclass method , however I can cast
        ((SongBird) myAnimal).sing(); // Casting worked

    }
}
