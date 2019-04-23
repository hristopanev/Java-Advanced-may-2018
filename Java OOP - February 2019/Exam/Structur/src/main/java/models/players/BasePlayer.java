package models.players;

import models.players.interfaces.Player;
import repositories.interfaces.CardRepository;
import repositories.CardRepositoryImpl;

public abstract class BasePlayer implements Player {
    private String name;
    private int health;
    private CardRepository cardRepository;
    private boolean isDead;


    protected BasePlayer(CardRepository cardRepository, String name, int health) {
        this.name = name;
        this.health = health;
    }

    @Override
    public CardRepository getCardRepository() {
        return this.cardRepository;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    public void setName(String name) {

        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Player's username cannot be null or an empty string.");
        }
        this.name = name;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(int healthPoints) {
        if (healthPoints < 0){
            throw new IllegalArgumentException("Player's health bonus cannot be less than zero.");
        }
    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public void takeDamage(int damagePoints) {

        if (damagePoints < 0){
            throw new IllegalArgumentException("Damage points cannot be less than zero.");
        }

    }
}
