package app.models.participants;

import static app.constants.Config.*;

public class Necromancer extends AbstractHero {


    public Necromancer(String name) {
        super(name, ((NECROMANCER_BASE_INTELLIGENCE * 2) + (NECROMANCER_BASE_DEXTERITY*2) + (NECROMANCER_BASE_STRENGTH * 2)),
                HERO_START_GOLD,
                NECROMANCER_BASE_STRENGTH,
                NECROMANCER_BASE_DEXTERITY,
                NECROMANCER_BASE_INTELLIGENCE);
    }

    public double getDamage() {
        return (NECROMANCER_BASE_INTELLIGENCE * 2) + (NECROMANCER_BASE_DEXTERITY*2) + (NECROMANCER_BASE_STRENGTH * 2);
    }
}
