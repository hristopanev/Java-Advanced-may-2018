package hell.entities.models.heroes;

public class Assassin extends BaseHero {
    private static final int DEFAULT_STRENGTH = 25;
    private static final int DEFAULT_AGILITY = 10;
    private static final int DEFAULT_INTELLIGENCE = 15;
    private static final int DEFAULT_HITPOINTS = 150;
    private static final int DEFAULT_DAMAGE = 300;

    public Assassin(String  name, int strength, int agility, int intelligence, int hitPoints, int damage) {
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE, DEFAULT_HITPOINTS, DEFAULT_DAMAGE);
    }
}
