package entities;

import entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter {

    private static final Double DEFAULT_HEALTH_POINTS = 200.0;
    private static final Double ATTACK_POINTS_MODIFIER = 50.0;
    private static final Double DEFENCE_POINTS_MODIFIER = 25.0;

    private boolean aggressiveMode;


    public FighterImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, DEFAULT_HEALTH_POINTS);
        this.aggressiveMode = true;
    }

    @Override
    public boolean getAggressiveMode() {
        return this.aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {
        if (this.aggressiveMode){
            super.setAttackPoints(super.getAttackPoints() + ATTACK_POINTS_MODIFIER);
            super.setDefensePoints(super.getDefensePoints() - DEFENCE_POINTS_MODIFIER);
            this.aggressiveMode = false;
        }else {
            super.setAttackPoints(super.getAttackPoints() - ATTACK_POINTS_MODIFIER);
            super.setDefensePoints(super.getDefensePoints() + DEFENCE_POINTS_MODIFIER);
            this.aggressiveMode = true;
        }
    }

}
