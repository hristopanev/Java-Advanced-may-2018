package cresla.models.modules;

import cresla.interfaces.EnergyModule;

public abstract class AbstractEnergyModule extends AbstractModule implements EnergyModule {

    private int energyOutput;

    protected AbstractEnergyModule(int id, int output) {
        super(id);
        this.energyOutput = output;
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutput;
    }
}
