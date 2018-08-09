import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04_FootballStats {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new  InputStreamReader(System.in));

        // teamName -> List of games
        Map<String, List<String>> games = new HashMap<>();

        // Input

        Pattern pattern = Pattern
                .compile("([A-Za-z]+) - ([A-Za-z]+) (result) ([0-9]+):([0-9]+)");

        String line;
        while (true) {
            if ("Season End".equals(line = reader.readLine())) {
                break;
            }

            Matcher matcher = pattern.matcher(line);

            matcher.find();
            String homeTeam = matcher.group(1);
            String guestTeam = matcher.group(2);
            String homeTeamResult = matcher.group(4);
            String guestTeamResult = matcher.group(5);

            if (!games.containsKey(homeTeam)){
                games.put(homeTeam, new ArrayList<>());
            }

            if (!games.containsKey(guestTeam)){
                games.put(guestTeam, new ArrayList<>());
            }
            String homeGame = " - " + guestTeam + " -> " + homeTeamResult + ":" + guestTeamResult;
            String guestGame = " - " + homeTeam + " -> " + guestTeamResult + ":" + homeTeamResult;
            games.get(homeTeam).add(homeGame);
            games.get(guestTeam).add(guestGame);
        }

        PrintResult(games, reader);
    }

    private static void PrintResult(Map<String,List<String>> games, BufferedReader reader) throws IOException {

        String[] teams = reader.readLine().split(", ");

        for (String team : teams) {
            games.get(team)
                    .stream()
                    .sorted(Comparator.comparing(x -> x.split(" ->")[0]))
                    .forEach(s -> System.out.println(String.format("%s%s", team, s)));
        }
    }


}
