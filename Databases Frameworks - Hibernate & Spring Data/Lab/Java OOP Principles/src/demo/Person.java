package demo;

public interface Person {
    String getName();

    default void sayHello(){
        System.out.println("Hello");
    }
}
