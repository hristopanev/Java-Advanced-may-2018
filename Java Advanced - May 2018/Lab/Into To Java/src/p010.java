import java.util.Scanner;

//11.	Modify a Bit

public class p010 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        //How to set the bit at position p to 0?
        int n = 291;               // 00000001 00100011
        int p = 5;
        int mask = ~(1 << p);      // 11111111 11011111
        int result = n & mask;     // 00000001 00000011
        System.out.println(result); // 259

        //How to set the bit at position p to 1?
        int n = 291;                // 00000001 00100011
        int p = 4;
        int mask = 1 << p;          // 00000000 00010000
        int result = n | mask;      // 00000001 00110011
        System.out.println(result);  // 307


    }
}
