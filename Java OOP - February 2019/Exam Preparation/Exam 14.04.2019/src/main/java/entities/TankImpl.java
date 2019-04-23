package entities;

import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {

    private static final Double DEFAULT_HEALTH_POINTS = 200.0;
    private static final Double ATTACK_POINTS_MODIFIER = 50.0;
    private static final Double DEFENCE_POINTS_MODIFIER = 25.0;

    private boolean defenseMode;

    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, DEFAULT_HEALTH_POINTS);
        this.defenseMode = true;
    }

    @Override
    public boolean getDefenseMode() {
        return this.defenseMode;
    }

    @Override
    public void toggleDefenseMode() {

        if (this.defenseMode){
            super.setAttackPoints(super.getAttackPoints() - ATTACK_POINTS_MODIFIER);
            super.setDefensePoints(super.getDefensePoints() + DEFENCE_POINTS_MODIFIER);
            this.defenseMode = false;
        }else {
            super.setAttackPoints(super.getAttackPoints() + ATTACK_POINTS_MODIFIER);
            super.setDefensePoints(super.getDefensePoints() - DEFENCE_POINTS_MODIFIER);
            this.defenseMode = true;
        }
    }
}
