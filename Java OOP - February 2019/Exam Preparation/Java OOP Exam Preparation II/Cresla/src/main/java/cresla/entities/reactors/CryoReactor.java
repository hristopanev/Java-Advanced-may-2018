package cresla.entities.reactors;

public class CryoReactor extends BaseReactor {

    private int cryoProductionIndex;

    public CryoReactor(int id, int moduleCapacoty, int cryoProductionIndex) {
        super(id, moduleCapacoty);
        this.cryoProductionIndex = cryoProductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        return super.getTotalEnergyOutput() * cryoProductionIndex;
    }
}
