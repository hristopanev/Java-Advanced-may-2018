package P06_Raw_Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Car> cars = new ArrayList<>();


        String command = "";
        int enginePower = 0;
        String model = "";
        int count = Integer.parseInt(reader.readLine());
        List<String> topPower = new ArrayList<>();
        List<String> poor = new ArrayList<>();


        while (count-- > 0) {
            Car auto = null;
            Tire tires = null;

            String[] tokens = reader.readLine().split("\\s+", 6);


            int engineSpeed = Integer.parseInt(tokens[1]);
            int power = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            command = tokens[4];
            model = tokens[0];


            if (power > 250) {
                enginePower = power;
                topPower.add(model);
            }

            String[] tire = tokens[5].split("\\s+");

            double pressure = 0;
            int age = 0;
            int countPressure = 0;

            Engine engine = new Engine(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
            Cargo cargo = new Cargo(Integer.parseInt(tokens[3]), tokens[4]);
            for (int i = 1; i < tire.length; i += 2) {
                pressure += Double.parseDouble(tire[i - 1]);
                countPressure++;
                age += Integer.parseInt(tire[i]);
            }
            pressure = pressure / countPressure;
            if (pressure< 1){
                poor.add(model);
            }

            age = age / countPressure;

            tires = new Tire(pressure, age);

            auto = new Car(model, engine, cargo, tires);

            cars.add(auto);
        }
        String lastCommand = reader.readLine();
        if ("flamable".equalsIgnoreCase(lastCommand)) {
            for (String s : topPower) {
                System.out.println(s);
            }
        } else {
            for (String s : poor) {
                System.out.println(s);
            }
        }


    }
}
