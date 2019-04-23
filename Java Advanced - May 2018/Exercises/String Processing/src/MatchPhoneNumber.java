import java.util.Scanner;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pattern = "\\+359([- ])2\\1\\d{3}\\1\\d{4}$";

        String phoneNumber;
        while (true){
            if ("end".equals(phoneNumber = scanner.nextLine())){
                break;
            }

            if (phoneNumber.matches(pattern)){
                System.out.println(phoneNumber);
            }
        }
    }
}
