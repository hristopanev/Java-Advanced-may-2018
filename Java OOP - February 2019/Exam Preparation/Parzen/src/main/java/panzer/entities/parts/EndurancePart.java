package panzer.entities.parts;

import java.math.BigDecimal;

public class EndurancePart extends BaseParts {

    private int eitPointsModifier;

    public EndurancePart(String model, double weight, BigDecimal price, int eitPointsModifier) {
        super(model, weight, price);
        this.eitPointsModifier = eitPointsModifier;
    }

    public int getEitPointsModifier() {
        return this.eitPointsModifier;
    }
}
