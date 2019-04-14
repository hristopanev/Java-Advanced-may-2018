package hell.entities.models.heroes;

public class Barbarian extends BaseHero {
    private static final int DEFAULT_STRENGTH = 90;
    private static final int DEFAULT_AGILITY = 25;
    private static final int DEFAULT_INTELLIGENCE = 10;
    private static final int DEFAULT_HITPOINTS = 350;
    private static final int DEFAULT_DAMAGE = 150;

    public Barbarian(String  name, int strength, int agility, int intelligence, int hitPoints, int damage) {
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE, DEFAULT_HITPOINTS, DEFAULT_DAMAGE);
    }
}
