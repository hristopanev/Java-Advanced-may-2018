package cresla.models.modules;

import cresla.interfaces.AbsorbingModule;

public abstract class AbstractAbsorbingModule extends AbstractModule implements AbsorbingModule {

    private int heatAbsorbing;

    protected AbstractAbsorbingModule(int id, int property) {
        super(id);
        this.heatAbsorbing = property;
    }

    @Override
    public int getHeatAbsorbing() {
        return this.heatAbsorbing;
    }
}
