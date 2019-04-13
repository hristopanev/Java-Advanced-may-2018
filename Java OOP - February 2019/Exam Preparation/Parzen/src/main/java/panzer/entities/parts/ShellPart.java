package panzer.entities.parts;

import java.math.BigDecimal;

public class ShellPart extends BaseParts {
    private int defenseModifier;

    public ShellPart(String model, double weight, BigDecimal price, int defenseModifier) {
        super(model, weight, price);
        this.defenseModifier = defenseModifier;
    }

    public int getDefenseModifier() {
        return this.defenseModifier;
    }
}
