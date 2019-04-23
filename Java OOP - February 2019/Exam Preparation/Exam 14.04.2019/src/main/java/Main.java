import core.MachineFactoryImpl;
import core.MachinesManagerImpl;

import core.PilotFactoryImpl;
import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PilotFactory pilotFactory = new PilotFactoryImpl();
        MachineFactory machineFactory = new MachineFactoryImpl();
        Map<String, Pilot> pilots = new LinkedHashMap<>();
        Map<String, Machine> machines = new LinkedHashMap<>();

        MachinesManager machinesManager = new MachinesManagerImpl(pilotFactory, machineFactory, pilots, machines);


        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("Over")) {

            String[] arguments = input.split("\\s+");

            String result = "";

            switch (arguments[0]) {
                case "Hire":
                    result = machinesManager.hirePilot(arguments[1]);
                    break;
                case "Report":
                    result = machinesManager.pilotReport(arguments[1]);
                    break;
                case "ManufactureTank":
                    result = machinesManager.manufactureTank(arguments[1],
                            Double.parseDouble(arguments[2]), Double.parseDouble(arguments[3]));
                    break;
                case "ManufactureFighter":
                    result = machinesManager.manufactureFighter(arguments[1], Double.parseDouble(arguments[2]),
                            Double.parseDouble(arguments[3]));
                    break;
                case "Engage":
                    result = machinesManager.engageMachine(arguments[1], arguments[2]);
                    break;
                case "Attack":
                    result = machinesManager.attackMachines(arguments[1], arguments[2]);
                    break;
                case "DefenseMode":
                    result = machinesManager.toggleTankDefenseMode(arguments[1]);
                    break;
                case "AggressiveMode":
                    result = machinesManager.toggleFighterAggressiveMode(arguments[1]);
                    break;
            }
            System.out.println(result);


            input = scanner.nextLine();
        }

    }
}
