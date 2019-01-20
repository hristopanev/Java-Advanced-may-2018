import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String url = scanner.nextLine();
        ArrayDeque<String> browserHistory = new ArrayDeque<>();

        while (!url.equals("Home")) {


            if (url.equals("back")) {
                if (browserHistory.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    browserHistory.pop();
                    String current = browserHistory.peek();
                    System.out.println(current);
                }

            } else {
                System.out.println(url);
                browserHistory.push(url);
            }
            url = scanner.nextLine();
        }
    }
}
