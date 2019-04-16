package panzer.entities.part;

import panzer.contracts.DefenseModifyingPart;

import java.math.BigDecimal;

public class ShellPart extends BasePart implements DefenseModifyingPart {


    private int defenseModifying;

    public ShellPart(String model, double weight, BigDecimal price, int defenseModifying) {
        super(model, weight, price);
        this.defenseModifying = defenseModifying;
    }

    @Override
    public int getDefenseModifier() {
        return this.defenseModifying;
    }
}
