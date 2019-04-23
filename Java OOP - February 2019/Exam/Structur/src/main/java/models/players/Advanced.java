package models.players;


import repositories.interfaces.CardRepository;

public class Advanced extends BasePlayer {

    private static final int DEFAULT_HEALTH_POINTS = 250;

    CardRepository cardRepository;


    public Advanced(CardRepository cardRepository, String name) {
        super(cardRepository, name, DEFAULT_HEALTH_POINTS);
    }
}
