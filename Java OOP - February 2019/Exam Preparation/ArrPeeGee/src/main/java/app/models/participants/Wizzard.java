package app.models.participants;

import static app.constants.Config.*;

public class Wizzard extends AbstractHero {

    public Wizzard(String name) {
        super(name, WIZARD_BASE_INTELLIGENCE * 5 + WARRIOR_BASE_DEXTERITY, HERO_START_GOLD,
                WIZARD_BASE_STRENGTH, WIZARD_BASE_DEXTERITY, WIZARD_BASE_INTELLIGENCE);
    }

    public double getDamage() {
        return WIZARD_BASE_INTELLIGENCE * 5 + WARRIOR_BASE_DEXTERITY;
    }
}
