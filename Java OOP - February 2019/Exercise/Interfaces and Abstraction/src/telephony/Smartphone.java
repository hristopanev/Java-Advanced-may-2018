package telephony;

import java.util.ArrayList;
import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = new ArrayList<>();
        this.urls = new ArrayList<>();
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();

        for (String url : urls) {
            if (url ==null || url.chars().anyMatch(Character::isDigit)){
                throw new IllegalArgumentException("Invalid URL!");
            }
            sb.append(String.format("Browsing: %s!", url)).append(System.lineSeparator());

        }
        return sb.toString();
    }

    @Override
    public String  call() {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            if (number == null || !number.chars().anyMatch(Character::isDigit)){
                throw new IllegalArgumentException("Invalid number!%n" );
            }
            sb.append(String.format("Calling... %s%n", number)).append(System.lineSeparator());
        }

        return  sb.toString();
    }
}
