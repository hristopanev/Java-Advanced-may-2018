import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p04 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Long> playerPoints = new LinkedHashMap<>();
        Map<String, List<String>> playerOpponents = new HashMap<>();

        String line;
        while (true) {
            if ("osu!".equalsIgnoreCase(line = reader.readLine())) {
                break;
            }
            String[] tokens = line.split("\\s+");
            int firstPlayerPoints = Integer.parseInt(tokens[0]);
            int secondPlayerPoints = Integer.parseInt(tokens[2]);

            String[] playerNames = tokens[1].split("<->");

            String firstPlayerName = playerNames[0];
            String secondPlayerName = playerNames[1];

            fillMaps(playerPoints, playerOpponents, firstPlayerPoints, secondPlayerPoints, firstPlayerName, secondPlayerName);
            fillMaps(playerPoints, playerOpponents, secondPlayerPoints, firstPlayerPoints, secondPlayerName, firstPlayerName);
        }

        StringBuilder result = new StringBuilder();

        playerPoints.entrySet().stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .forEach(value -> {
                    result.append(value.getKey()).append(" - (").append(value.getValue()).append(")")
                            .append(System.lineSeparator());
                    playerOpponents.get(value.getKey()).forEach(s -> result.append(s).append(System.lineSeparator()));
                });
        System.out.println(result);
    }

    private static void fillMaps(Map<String, Long> playerPoints, Map<String, List<String>> playerOpponents, int firstPlayerPoints, int secondPlayerPoints, String firstPlayerName, String secondPlayerName) {


        if (!playerPoints.containsKey(firstPlayerName)) {
            playerPoints.put(firstPlayerName, 0L);
        }
        playerPoints
                .put(firstPlayerName, playerPoints.get(firstPlayerName)
                        + (firstPlayerPoints - secondPlayerPoints));


        if (!playerOpponents.containsKey(firstPlayerName)) {
            playerOpponents.put(firstPlayerName, new ArrayList<>());
        }
        playerOpponents.get(firstPlayerName)
                .add("*   " + secondPlayerName + " <-> " + (firstPlayerPoints - secondPlayerPoints));
    }
}
