package cresla.entities.reactors;

public class HeatReactor extends BaseReactor {

    private int hatReductionIndex;

    public HeatReactor(int id, int moduleCapacity, int hatReductionIndex) {
        super(id, moduleCapacity);
        this.hatReductionIndex = hatReductionIndex;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getTotalHeatAbsorbing() + this.hatReductionIndex;
    }
}
