package app.models.participants;

import app.constants.Config;
import app.contracts.Targetable;
import app.constants.Texts;

public abstract class AbstractActor implements Targetable {

    private String name;
    private double health;
    private double damage;
    private double gold;
    private boolean isAlive;

    public AbstractActor(String name, double health, double damage, double gold) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.gold = gold;
        this.isAlive = isAlive();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(double health) {
        this.health = health;
    }

    @Override
    public double getGold() {
        return this.gold;
    }

    @Override
    public void takeDamage(double damage) {
        this.health -= damage;
        if (this.health <= 0) {
            this.isAlive = false;
        }
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    protected void addGold(double gold) {
        this.gold += gold;
    }



    @Override
    public String attack(Targetable target) {
        StringBuilder sb = new StringBuilder();

        if (!this.isAlive()) {
            return String.format(Texts.DEAD_CAN_NOT_ATTACK, getName());
        } else if (!target.isAlive()) {
            return String.format(Texts.DEAD_TARGETABLE_CAN_NOT_BE_ATTACKED, target.getName());
        }
        target.takeDamage(this.getDamage());
        sb.append(String.format(Texts.TARGETABLE_ATTAKED, this.getName()));

        if (!target.isAlive()) {
            this.levelUp();
            sb.append(String.format(Texts.TARGETABLE_SLAINED_BY, target.getName(), this.getName()));
            target.giveReward(this);
        }


        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Texts.ACTOR_NAME_AND_CLASS,
                this.name, this.getClass().getSimpleName())).append(System.lineSeparator())
                .append(String.format(Texts.ACTOR_HEALTH_AND_DAMAGE,
                        this.getHealth(), this.getDamage()));
        return sb.toString();
    }
}
