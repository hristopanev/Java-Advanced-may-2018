package cresla.core;

import cresla.entities.modules.BaseEnergyModule;
import cresla.entities.modules.CooldownSystem;
import cresla.entities.modules.CryogenRod;
import cresla.entities.modules.HeatProcessor;
import cresla.entities.reactors.CryoReactor;
import cresla.entities.reactors.HeatReactor;
import cresla.interfaces.*;
import cresla.interfaces.Module;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager {

    private static int id;

    private Map<Integer, Reactor> reactors;
    private Map<Integer, Module> modules;


    public ManagerImpl() {
        ManagerImpl.id = 1;
        this.reactors = new HashMap<>();
        this.modules = new HashMap<>();
    }

    @Override
    public String reactorCommand(List<String> arguments) {

        String type = arguments.get(0);
        int additionalParam = Integer.parseInt(arguments.get(1));
        int capacityContainer = Integer.parseInt(arguments.get(2));

        Reactor reactor = null;

        if (type.equalsIgnoreCase("cryo")) {
            reactor = new CryoReactor(id, capacityContainer, additionalParam);
        } else {
            reactor = new HeatReactor(id, capacityContainer, additionalParam);
        }

        this.reactors.putIfAbsent(id, reactor);
        return String.format("Created %s Reactor - %d", type, ManagerImpl.id++);
    }

    @Override
    public String moduleCommand(List<String> arguments) {

        //	Module {reactorId} {type} {additionalParameter}

        int reaactorId = Integer.parseInt(arguments.get(0));
        String type = arguments.get(1);
        int additionalParameter = Integer.parseInt(arguments.get(2));

        Module module = null;

        switch (type) {
            case "CryogenRod":
                module = new CryogenRod(ManagerImpl.id, additionalParameter);
                break;

            case "HeatProcessor":
                module = new HeatProcessor(ManagerImpl.id, additionalParameter);
                break;
            case "CooldownSystem":
                module = new CooldownSystem(ManagerImpl.id, additionalParameter);
                break;
        }

        if (type.equalsIgnoreCase("CryogenRod")) {
            this.reactors.get(reaactorId).addEnergyModule((EnergyModule) module);
        } else {
            this.reactors.get(reaactorId).addAbsorbingModule((AbsorbingModule) module);
        }

        this.modules.putIfAbsent(ManagerImpl.id, module);
        return String.format("Added %s - %d to Reactor - %d", type, ManagerImpl.id++, reaactorId);
    }

    @Override
    public String reportCommand(List<String> arguments) {

        int objectId = Integer.parseInt(arguments.get(0));

        String output = "";

        if (this.reactors.containsKey(objectId)) {
            output = this.reactors.get(objectId).toString();
        } else if (this.modules.containsKey(objectId)) {
            output = this.modules.get(objectId).toString();
        }

        return output;
    }

    @Override
    public String exitCommand(List<String> arguments) {

        //Cryo Reactors: {cryoReactorsCount}
        //Heat Reactors: {heatReactorsCount}
        //Energy Modules: {energyModulesCount}
        //Absorbing Modules: {absorbingModulesCount}
        //Total Energy Output: {totalEnergyOutput}
        //Total Heat Absorbing: {totalHeatAbsorbing}


        StringBuilder sb = new StringBuilder();
        int cryoCount = 0;
        int heatReactorCount = 0;
        int energyModulesCount = 0;
        int absorbingModulesCount = 0;
        long totalEnergyOutput = 0;
        long totalHeatAbsorbing = 0;

        for (Map.Entry<Integer, Reactor> entry : this.reactors.entrySet()) {
            if (entry.getValue().getClass().getSuperclass().getSimpleName().contains("Energy")) {
                cryoCount++;
                totalEnergyOutput += entry.getValue().getTotalEnergyOutput();
            } else {
                heatReactorCount++;
                totalHeatAbsorbing += entry.getValue().getTotalHeatAbsorbing();
            }
        }

        for (Map.Entry<Integer, Module> entry : this.modules.entrySet()) {
            if (entry.getValue().getClass().getSimpleName().contains("Cryo")){
                energyModulesCount++;
            }else {
                absorbingModulesCount++;
            }
        }

        sb.append("Cryo Reactors: ").append(heatReactorCount).append(System.lineSeparator());
        sb.append("Heat Reactors: ").append(cryoCount).append(System.lineSeparator());
        sb.append("Energy Modules: ").append(energyModulesCount).append(System.lineSeparator());
        sb.append("Absorbing Modules: ").append(absorbingModulesCount).append(System.lineSeparator());
        sb.append("Total Energy Output: ").append(totalEnergyOutput).append(System.lineSeparator());
        sb.append("Total Heat Absorbing: ").append(totalHeatAbsorbing);


        return sb.toString();
    }


}
