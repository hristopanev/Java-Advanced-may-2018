package P04_say_Hello;

public interface Person {
    String getName();
    default String sayHello(){
        return "Hello";
    }

}
