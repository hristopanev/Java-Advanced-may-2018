import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p04 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> initiatives = new TreeMap<>();
        Map<String, Map<String, Integer>> stations = new TreeMap<>();
        List<String> originalStations = new ArrayList<>();
        originalStations.add("Hydra");
        originalStations.add("Arrow");
        originalStations.add("Flame");
        originalStations.add("Pearl");
        originalStations.add("Orchid");

        Map<String, String> stationNames = new HashMap<String, String>() {{
            put("Arrow", "Development of defensive strategies, and Intelligence gathering.");
            put("Hydra", "Zoological Research.");
            put("Flame", "Communication.");
            put("Pearl", "Psychological Research and/or Observation.");
            put("Orchid", "Space-time manipulation research, disguised as a Botanical station.");
        }};


        String line;
        while (true) {
            if ("recruit".equalsIgnoreCase(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split(":");

            String personName = tokens[0];
            int facilityNumber = Integer.parseInt(tokens[1]);
            String stationName = tokens[2];

            if (!originalStations.contains(stationName)){
                continue;
            }

            if (!initiatives.containsKey(stationName)){
                initiatives.put(stationName, +1);
            }else {
                initiatives.put(stationName, +1);
            }

            if (!stations.containsKey(stationName)){
                stations.putIfAbsent(stationName, new LinkedHashMap<>());
            }
            stations.get(stationName).put(personName, facilityNumber);
        }

        line = reader.readLine();
        if ("DHARMA Initiative".equalsIgnoreCase(line)){
            for (Map.Entry<String, Map<String, Integer>> entry : stations.entrySet()) {
                System.out.printf("The %s has %d DHARMA recruits in it.%n", entry.getKey(), entry.getValue().size());

            }
        }else if (stationNames.containsKey(line)){
            if (stations.get(line).size() > 0) {
                System.out.printf("The %s station: %s%n", line, stationNames.get(line));
                stations.get(line).entrySet().stream()
                        .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                        .forEach(x -> System.out.printf("###%s - %d%n", x.getKey(), x.getValue()));
            }
        }else {
            System.out.printf("DHARMA Initiative does not have such a station!");
        }
    }
}
