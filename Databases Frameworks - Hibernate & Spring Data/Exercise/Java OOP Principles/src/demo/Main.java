public class Main {
    public static void main(String[] args) {
    Superhero batman = new Superhero("Batman", "Bruce Wayne");
       Bird bird = new Bird();
       Flyable[] flyables = {batman, bird};

        //Polymorphysm
        for (Flyable flyable : flyables) {
            flyable.fly();
        }
    }
}
