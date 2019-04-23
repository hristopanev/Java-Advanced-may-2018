package cresla.entities.reactors;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Reactor;

public abstract class BaseReactor implements Reactor {

    private int id;
    private Container container;

    protected BaseReactor(int id, int moduleCapacity) {
        this.id = id;
        this.container = new ModuleContainer(moduleCapacity);
    }

    @Override
    public long getTotalEnergyOutput() {
        return this.container.getTotalEnergyOutput();
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return this.container.getTotalHeatAbsorbing();
    }

    @Override
    public int getModuleCount() {
        return this.container.getModuleByInputCount();
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        this.container.addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        this.container.addAbsorbingModule(absorbingModule);
    }

    @Override
    public int getId() {
        return this.id;
    }


    @Override
    public String toString() {
        //{reactorType} – {reactorId}
        //Energy Output: {energyOutput}
        //Heat Absorbing: {heatAbsorbing}
        //Modules: {moduleCount}

        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName());

        sb.append(" - ").append(this.getId()).append(System.lineSeparator());
        sb.append("Energy Output: ").append(this.getTotalEnergyOutput()).append(System.lineSeparator());
        sb.append("Heat Absorbing: ").append(this.container.getTotalHeatAbsorbing()).append(System.lineSeparator());
        sb.append("Modules: ").append(this.getModuleCount());

        return sb.toString();
    }
}
