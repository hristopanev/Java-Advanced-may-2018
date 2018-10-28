package p04.Telephony;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            String[] phoneNumbers = scanner.nextLine().split(" ");
            String[] sites = scanner.nextLine().split(" ");

            Smartphones smartphones = new Smartphones();



             for (String phoneNumber : phoneNumbers) {
              System.out.println(smartphones.Calling(phoneNumber));
             }

            for (String site : sites) {
                System.out.println(smartphones.Browsing(site));
            }





    }
}
