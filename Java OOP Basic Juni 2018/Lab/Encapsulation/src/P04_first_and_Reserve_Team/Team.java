package P04_first_and_Reserve_Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private List<Player> firstSquad;
    private List<Player> reserveSquad;

    public Team(String name){
        this.setName(name);
        this.firstSquad = new ArrayList<>();
        this.reserveSquad = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getFirstSquad() {
        return Collections.unmodifiableList(this.firstSquad);
    }

    public List<Player> getReserveSquad() {
        return Collections.unmodifiableList(this.reserveSquad);
    }

    public void addPlayer(Player player){
        if (player.getAge() < 40){
            this.firstSquad.add(player);
        }else {
            this.reserveSquad.add(player);
        }
    }

    @Override
    public String toString() {
        return "First team have " + this.firstSquad.size()
                + " players\n"
                + "Reserve team have "
                + this.getReserveSquad().size() + " players";
    }
}
