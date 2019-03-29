package core;

import hardwareComponent.HeavyHardware;
import hardwareComponent.PowerHardware;
import softwareComponent.ExpressSoftware;
import softwareComponent.LightSoftware;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine {

    private SystemSplit systemSplit;

    public Engine(SystemSplit systemSplit) {
        this.systemSplit = systemSplit;
    }


    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        while (!input.equalsIgnoreCase("System Split")) {

            String command = input.substring(0, input.indexOf("("));

            String[] cmdArgs = input
                    .substring(input.indexOf("(") + 1, input.length() - 1)
                    .split(", ");

            switch (command) {
                case "RegisterPowerHardware":
                    this.systemSplit.addHardware(new PowerHardware(
                            cmdArgs[0],
                            Integer.parseInt(cmdArgs[1]),
                            Integer.parseInt(cmdArgs[2])
                    ));
                    break;
                case "RegisterHeavyHardware":
                    this.systemSplit.addHardware(new HeavyHardware(
                            cmdArgs[0],
                            Integer.parseInt(cmdArgs[1]),
                            Integer.parseInt(cmdArgs[2])
                    ));
                    break;
                case "RegisterExpressSoftware":
                    this.systemSplit.addSoftwareComponent(cmdArgs[0],
                            new ExpressSoftware(cmdArgs[1],
                                    Integer.parseInt(cmdArgs[2]),
                                    Integer.parseInt(cmdArgs[3])
                            ));
                    break;
                case "RegisterLightSoftware":
                    this.systemSplit.addSoftwareComponent(cmdArgs[0],
                            new LightSoftware(cmdArgs[1],
                                    Integer.parseInt(cmdArgs[2]),
                                    Integer.parseInt(cmdArgs[3])
                            ));
                    break;
                case "ReleaseSoftwareComponent":
                    this.systemSplit.releaseSoftwareComponent(cmdArgs[0], cmdArgs[1]);
                    break;
                case "Analyze":
                    System.out.println(this.systemSplit.analyze());
                    break;
            }

            input = reader.readLine();
        }
    }
}