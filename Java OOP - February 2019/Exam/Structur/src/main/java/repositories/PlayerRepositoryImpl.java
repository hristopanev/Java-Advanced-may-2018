package repositories;

import models.players.interfaces.Player;
import repositories.interfaces.PlayerRepository;

import java.util.ArrayList;
import java.util.List;

public class PlayerRepositoryImpl implements PlayerRepository {

    private List<Player> players;

    public PlayerRepositoryImpl(){
        this.players = new ArrayList<>();
    }


    @Override
    public int getCount() {
        return players.size();
    }

    @Override
    public List<Player> getPlayers() {
        return this.players;
    }

    @Override
    public void add(Player player) {


        if (player == null){
            throw new IllegalArgumentException("Player cannot be null");
        }

        String userName = player.getUsername();


        String result = String.format("Player %s already exists!", userName);
        for (Player user : players) {
            String usersName = user.getUsername();
            if (usersName.equals(userName)){
                throw new IllegalArgumentException(result);

            }
        }

        this.players.add(player);
    }

    @Override
    public boolean remove(Player player) {

        if (player == null){
            throw new IllegalArgumentException("Player cannot be null");
        }
        return this.players.remove(player);
    }

    @Override
    public Player find(String name) {

        Player result = null;

        for (Player player : players) {
            if (player.getUsername().equalsIgnoreCase(name)){
                result = player;
            }
        }
        return result;
    }
}
