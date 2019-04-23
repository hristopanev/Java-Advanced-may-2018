package P01_overload_Method;

public class MathOperation {
    private int a;
    private int b;
    private int c;
    private int d;

    public int add(int a, int b){
        return a + b;
    }
    public int add(int a, int b, int c){
        return a + b + c;
    }
    public int add(int a, int b, int c, int d){
        return a + b + c + d;
    }
}
