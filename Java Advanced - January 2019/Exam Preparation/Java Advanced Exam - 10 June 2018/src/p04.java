import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p04 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> validDate = new HashMap<>();
        Map<String, Map<String, Integer>> users = new TreeMap<>();

        String line;
        while (true) {
            if ("end of contests".equalsIgnoreCase(line = reader.readLine())) {
                break;
            }
            String[] tokens = line.split(":");

            validDate.put(tokens[0], tokens[1]);
        }

        while (true) {
            if ("end of submissions".equalsIgnoreCase(line = reader.readLine())) {
                break;
            }
            String[] tokens = line.split("=>");

            String contest = tokens[0];
            String password = tokens[1];
            String userName = tokens[2];
            int points = Integer.parseInt(tokens[3]);

            if (validDate.containsKey(contest) && validDate.containsValue(password)) {
                users.putIfAbsent(userName, new HashMap<>());
                users.get(userName).putIfAbsent(contest, 0);
                if (users.get(userName).get(contest) < points) {
                    users.get(userName).replace(contest, points);
                }
            }
        }

            users.entrySet()
                    .stream()
                    .sorted((f, s) -> {
                        int result = Integer.compare(s.getValue().values().stream().mapToInt(Integer::valueOf).sum(),
                                f.getValue().values().stream().mapToInt(Integer::valueOf).sum());

                        return result;
                    })
                    .limit(1)
                    .forEach(s -> System.out.printf("Best candidate is %s with total %d points.%n" +
                            "Ranking: %n", s.getKey(), s.getValue().values().stream().mapToInt(Integer::intValue).sum()));

            users.entrySet().stream()
                    .forEach(s -> {
                        System.out.printf("%s%n", s.getKey());
                        s.getValue().entrySet()
                                .stream()
                               .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                                .forEach(x -> System.out.printf("#  %s -> %d%n", x.getKey(), x.getValue()));
                    });

    }
}
