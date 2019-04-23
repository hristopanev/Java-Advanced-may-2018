package panzer.entities.part;

import panzer.contracts.HitPointsModifyingPart;

import java.math.BigDecimal;

public class EndurancePart extends BasePart implements HitPointsModifyingPart {
    private int hitPointsModifying;

    public EndurancePart(String model, double weight, BigDecimal price, int hitPointsModifying) {
        super(model, weight, price);
        this.hitPointsModifying = hitPointsModifying;
    }

    @Override
    public int getHitPointsModifier() {
        return this.hitPointsModifying;
    }
}
