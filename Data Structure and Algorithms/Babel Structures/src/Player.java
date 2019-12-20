public class Player implements Comparable<Player> {

    private String name;
    private int number;

    public Player(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int compareTo(Player player) {
        return name.compareTo(player.name);
    }

    @Override
    public String toString() {
        return
                "Name: " + name + "\n" +
                "Number: " + number + "\n";
    }
}
