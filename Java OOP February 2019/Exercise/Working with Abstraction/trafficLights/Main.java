package trafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] initialStates = reader.readLine().split("\\s+");
        int updatesCount = Integer.parseInt(reader.readLine());

        ArrayList<TrafficLight> trafficLights = new ArrayList<>();

        for (String initialState : initialStates) {
            TrafficLight trafficLight = new TrafficLight(Lightstates.valueOf(initialState));
            trafficLights.add(trafficLight);
        }

        for (int i = 0; i < updatesCount; i++) {

            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.update();
                System.out.print(trafficLight.toString() + " ");
            }
            System.out.println();
        }
    }
}
