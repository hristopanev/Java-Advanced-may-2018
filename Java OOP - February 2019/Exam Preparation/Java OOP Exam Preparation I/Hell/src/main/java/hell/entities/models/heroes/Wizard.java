package hell.entities.models.heroes;

public class Wizard extends BaseHero {

    private static final int DEFAULT_STRENGTH = 25;
    private static final int DEFAULT_AGILITY = 25;
    private static final int DEFAULT_INTELLIGENCE = 100;
    private static final int DEFAULT_HITPOINTS = 100;
    private static final int DEFAULT_DAMAGE = 250;

    public Wizard(String  name, int strength, int agility, int intelligence, int hitPoints, int damage) {
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE, DEFAULT_HITPOINTS, DEFAULT_DAMAGE);
    }
}
