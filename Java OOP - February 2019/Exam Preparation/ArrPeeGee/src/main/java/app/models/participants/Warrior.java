package app.models.participants;

import static app.constants.Config.*;

public class Warrior extends AbstractHero {


    public Warrior(String name) {
        super(name, WARRIOR_BASE_STRENGTH * 2 + WARRIOR_BASE_DEXTERITY, HERO_START_GOLD,
                WARRIOR_BASE_STRENGTH, WARRIOR_BASE_DEXTERITY, WARRIOR_BASE_INTELLIGENCE);
    }

    public double getDamage() {
        return (this.getStrength() * 2) + this.getDexterity();
    }

}
