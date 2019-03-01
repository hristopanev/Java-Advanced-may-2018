package heroRepository;

public class Hero {

    // name, level,  item

    private String name;
    private int level;
    private Item item;

    public Hero(String name, int level, Item item) {
        this.name = name;
        this.level = level;
        this.item = item;
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    public Item getItem() {
        return this.item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Hero: %s - %d", this.name, this.level)).append(System.lineSeparator())
                .append(item.toString());

        return  sb.toString();
    }
}
