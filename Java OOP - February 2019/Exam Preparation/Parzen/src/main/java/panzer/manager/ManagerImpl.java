package panzer.manager;

import panzer.contracts.BattleOperator;
import panzer.contracts.Manager;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.core.PanzerBattleOperator;
import panzer.entities.part.ArsenalPart;
import panzer.entities.part.EndurancePart;
import panzer.entities.part.ShellPart;
import panzer.entities.vehicle.Revenger;
import panzer.entities.vehicle.Vanguard;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager {
    private static Vehicle vehicle = null;

    Map<String, Vehicle> vehicles;

    public ManagerImpl() {
        this.vehicles = new HashMap<>();
    }

    @Override
    public String addVehicle(List<String> arguments) {


        String model = arguments.get(0);
        String type = arguments.get(1);
        double weight = Double.parseDouble(arguments.get(2));
        BigDecimal price = new BigDecimal(arguments.get(3));
        int attack = Integer.parseInt(arguments.get(4));
        int defence = Integer.parseInt(arguments.get(5));
        int hitPoints = Integer.parseInt(arguments.get(6));

        if (model.equalsIgnoreCase("Vanguard")) {
            vehicle = new Vanguard(model, weight, price, attack, defence, hitPoints);
        } else {
            vehicle = new Revenger(model, weight, price, attack, defence, hitPoints);
        }
        vehicles.putIfAbsent(type, vehicle);
        return String.format("Created %s Vehicle - %s", model, type);
    }

    @Override
    public String addPart(List<String> arguments) {

        Part part = null;

        String vehicleType = arguments.get(0);
        String type = arguments.get(1);
        String model = arguments.get(2);
        double weight = Double.parseDouble(arguments.get(3));
        BigDecimal price = new BigDecimal(arguments.get(4));
        int additionalParameter = Integer.parseInt(arguments.get(5));

        if (type.equalsIgnoreCase("Arsenal")) {
            part = new ArsenalPart(model, weight, price, additionalParameter);
            vehicles.get(vehicleType).addArsenalPart(part);
        } else if (type.equalsIgnoreCase("Shell")) {
            part = new ShellPart(model, weight, price, additionalParameter);
            vehicles.get(vehicleType).addShellPart(part);
        } else {
            part = new EndurancePart(model, weight, price, additionalParameter);
            vehicles.get(vehicleType).addEndurancePart(part);
        }

        return String.format("Added %s - %s to Vehicle - %s", type, model, vehicleType);
    }

    @Override
    public String inspect(List<String> arguments) {

        String model = arguments.get(0);
        String type = vehicles.get(model).getModel();

        return String.format("%s - %s", type, model) + vehicles.get(model).toString();
    }

    @Override
    public String battle(List<String> arguments) {

        String model = arguments.get(0);
        String mode2 = arguments.get(1);

        Vehicle vehicle1 = vehicles.get(model);
        Vehicle vehicle2 = vehicles.get(mode2);

        BattleOperator battleOperator = new PanzerBattleOperator();
        String winner = battleOperator.battle(vehicle1, vehicle2);


        return String.format("%s versus %s -> %s%nWins! Flawless Victory!", model, mode2, winner);
    }

    @Override
    public String terminate(List<String> arguments) {
        //TODO
        return null;
    }
}
