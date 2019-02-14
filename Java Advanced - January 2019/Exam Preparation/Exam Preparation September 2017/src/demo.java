import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class demo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<String>> games = new HashMap<>();

        String line;
        while (true) {
            if ("season end".equalsIgnoreCase(line = reader.readLine())) {
                break;
            }
            String[] tokens = line.split("\\s+");

            String homeTeam = tokens[0];
            String guestTeam = tokens[2];
            String[] result = tokens[4].split(":");
            int homeTeamResult = Integer.parseInt(result[0]);
            int guestTeamResult = Integer.parseInt(result[1]);

            if (!games.containsKey(homeTeam)) {
                games.put(homeTeam, new ArrayList<>());
            }
            if (!games.containsKey(guestTeam)) {
                games.put(guestTeam, new ArrayList<>());
            }

            String homeGame = " - " + guestTeam + " -> " + homeTeamResult + ":" + guestTeamResult;
            String guestGame = " - " + homeTeam + " -> " + guestTeamResult + ":" + homeTeamResult;

            games.get(homeTeam).add(homeGame);
            games.get(guestTeam).add(guestGame);
        }

        printResult(games, reader);
    }

    private static void printResult(Map<String, List<String>> games, BufferedReader reader) throws IOException {
        String[] teams = reader.readLine().split(", ");

        for (String team : teams) {
            games.get(team)
                    .stream()
                    .sorted(Comparator.comparing(x -> x.split(" ->")[0]))
                    .forEach(x -> System.out.println(String.format("%s%s", team, x)));
        }

    }
}
