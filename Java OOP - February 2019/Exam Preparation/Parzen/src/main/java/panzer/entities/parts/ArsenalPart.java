package panzer.entities.parts;

import java.math.BigDecimal;

public class ArsenalPart extends BaseParts {

    private int attackModifier;

    public ArsenalPart(String model, double weight, BigDecimal price, int attackModifier) {
        super(model, weight, price);
        this.attackModifier = attackModifier;
    }

    public int getAttackModifier() {
        return this.attackModifier;
    }
}
