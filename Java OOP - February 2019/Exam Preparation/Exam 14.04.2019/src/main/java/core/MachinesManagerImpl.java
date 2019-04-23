package core;

import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;

import entities.interfaces.Fighter;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;
import entities.interfaces.Tank;


import java.util.HashMap;
import java.util.Map;

import static common.OutputMessages.*;

public class MachinesManagerImpl implements MachinesManager {

    private PilotFactory pilotFactory;
    private MachineFactory machineFactory;
    private Map<String, Pilot> pilots;
    private Map<String, Machine> machines;

    public MachinesManagerImpl(PilotFactory pilotFactory, MachineFactory machineFactory, Map<String, Pilot> pilots, Map<String, Machine> machines) {
        this.pilotFactory = new PilotFactoryImpl();
        this.machineFactory = new MachineFactoryImpl();
        this.pilots = new HashMap<>();
        this.machines = new HashMap<>();

    }

    @Override
    public String hirePilot(String name) {
        Pilot result = null;
        result = this.pilotFactory.createPilot(name);

        if (pilots.containsKey(name)) {
            return String.format(pilotExists, name);
        }
        pilots.putIfAbsent(name, result);
        return String.format(pilotHired, name);

    }

    @Override
    public String manufactureTank(String name, double attackPoints, double defensePoints) {

        Machine result = null;
        result = this.machineFactory.createTank(name, attackPoints, defensePoints);

        if (machines.containsKey(name)) {
            String.format(machineExists, name);
        }

        machines.putIfAbsent(name, result);
        return String.format(tankManufactured, name, attackPoints, defensePoints);
    }

    @Override
    public String manufactureFighter(String name, double attackPoints, double defensePoints) {

        Machine result = null;
        result = this.machineFactory.createFighter(name, attackPoints, defensePoints);

        if (machines.containsKey(name)){
            String.format(machineExists, name);
        }

        machines.putIfAbsent(name, result);
        return String.format(fighterManufactured, name, attackPoints, defensePoints);
    }

    @Override
    public String engageMachine(String selectedPilotName, String selectedMachineName) {
        this.pilots.get(selectedMachineName).addMachine(this.machines.get(selectedMachineName));
        this.machines.get(selectedPilotName).setPilot(this.pilots.get(selectedPilotName));

        return String.format(machineEngaged, selectedPilotName, selectedMachineName);
    }

    @Override
    public String attackMachines(String attackingMachineName, String defendingMachineName) {
        if (!(machines.containsKey(attackingMachineName) && machines.containsKey(defendingMachineName))) {
            if (machines.containsKey(attackingMachineName)) {
                return String.format("Machine %s could not be found", defendingMachineName);
            }
            return String.format("Machine %s could not be found", attackingMachineName);
        }

        Machine attacker = machines.get(attackingMachineName);
        Machine defender = machines.get(defendingMachineName);
        if (attacker.getAttackPoints() > defender.getDefensePoints()) {
            if (attacker.getAttackPoints() >= defender.getHealthPoints()) {
                defender.setHealthPoints(0);
            } else {
                defender.setHealthPoints(defender.getHealthPoints()-attacker.getAttackPoints());
            }
        }
        attacker.getTargets().add(defendingMachineName);


        return String.format("Machine %s was attacked by machine %s - current health: %s",
                defender.getName(), attacker.getName(), defender.getHealthPoints());
    }

    @Override
    public String pilotReport(String pilotName) {
        //TODO
        return null;
    }

    @Override
    public String toggleFighterAggressiveMode(String fighterName) {
        Fighter fighter = (Fighter)machines.get(fighterName);
        fighter.getAggressiveMode();
        return String.format("Fighter %s toggled aggressive mode", fighterName);
    }

    @Override
    public String toggleTankDefenseMode(String tankName) {
        Tank tank = (Tank)machines.get(tankName);
        tank.getDefenseMode();
        return String.format("Tank %s toggled defense mode", tankName);
    }
}
