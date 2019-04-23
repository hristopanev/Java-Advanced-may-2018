package models.players;

import models.players.BasePlayer;
import repositories.CardRepositoryImpl;
import repositories.interfaces.CardRepository;

public class Beginner extends BasePlayer {

    private static final int DEFAULT_HEALTH_POINTS = 50;

    private CardRepository cardRepository;


    public Beginner(CardRepository cardRepository, String name) {
        super(cardRepository, name, DEFAULT_HEALTH_POINTS);
    }
}
