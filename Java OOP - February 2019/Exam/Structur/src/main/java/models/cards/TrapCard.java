package models.cards;

public class TrapCard extends BaseCard {

    private static final int DEFAULT_DAMAGE_POINTS = 120;
    private static final int DEFAULT_HEALTH_POINTS = 5;


    public TrapCard(String name) {
        super(name, TrapCard.DEFAULT_DAMAGE_POINTS, TrapCard.DEFAULT_HEALTH_POINTS);
    }
}
