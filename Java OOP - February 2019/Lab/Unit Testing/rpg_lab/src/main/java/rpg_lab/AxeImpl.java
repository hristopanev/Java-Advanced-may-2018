package rpg_lab;

public class AxeImpl implements Axe {

    private int attackPoints;
    private int durabilityPoints;

    public AxeImpl(int attack, int durability) {
        this.attackPoints = attack;
        this.durabilityPoints = durability;
    }

    @Override
    public void attack(Target target) {

    }

    public int getAttackPoints() {
        return this.attackPoints;
    }

    public int getDurabilityPoints() {
        return this.durabilityPoints;
    }

    public void attack(Dummy target) {
        if (this.durabilityPoints <= 0) {
            throw new IllegalStateException("Axel is broken.");
        }

        target.takeAttack(this.attackPoints);
        this.durabilityPoints -= 1;
    }
}
