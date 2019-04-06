package app.models.participants;

import app.constants.Config;
import app.contracts.Special;
import app.contracts.SuperHero;
import app.contracts.Targetable;

import static app.constants.Config.*;
import static app.constants.Texts.*;

public abstract class AbstractHero extends AbstractActor implements SuperHero {

    private int strength;
    private int dexterity;
    private int intelligence;
    private int level;
    private Special special;

    public AbstractHero(String name,  double damage, double gold, int strength, int dexterity, int intelligence) {
        super(name, strength * HERO_HEALTH_MULTIPLIER, damage, gold);
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.level = 1;
    }

    @Override
    public void addSpecial(Special special) {
        this.special = special;
    }

    @Override
    public void activate(int bonus) {
        this.special.activate(bonus);
    }

    @Override
    public void deactivate() {
        this.special.deactivate();
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public int getDexterity() {
        return this.dexterity;
    }

    @Override
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    @Override
    public int getIntelligence() {
        return this.intelligence;
    }

    @Override
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public void receiveReward(double reward) {
        super.addGold(reward);
    }

    @Override
    public void levelUp() {
        this.level++;

        this.setDexterity(this.getDexterity() * LEVEL_UP_MULTIPLIER);
        this.setIntelligence(this.getIntelligence() * LEVEL_UP_MULTIPLIER);
        this.setStrength(this.getStrength() * LEVEL_UP_MULTIPLIER);
        this.setHealth(this.getMaxHealth());
    }

    private double getMaxHealth(){
        return this.getStrength() * HERO_HEALTH_MULTIPLIER;
    }

    @Override
    public void giveReward(Targetable targetable) {
        targetable.receiveReward(super.getGold());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString()).append(String.format(HERO_STATS,
                this.getStrength(), this.getDexterity(), this.getIntelligence(), super.getGold()));

        return sb.toString();
    }
}
