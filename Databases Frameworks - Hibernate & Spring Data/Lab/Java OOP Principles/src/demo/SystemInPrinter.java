package demo;

public class SystemInPrinter implements  Printer {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
