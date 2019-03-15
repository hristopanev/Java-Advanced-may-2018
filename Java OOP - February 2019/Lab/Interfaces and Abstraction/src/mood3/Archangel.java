package mood3;

public class Archangel extends Character<String, Integer> {
    private static final String CHARACTER_TYPE = "Archangel";

    Archangel(String userName, int level, Integer specialPoints){
        super(userName, CHARACTER_TYPE,  specialPoints, level);
    }

    @Override
    public String getHashedPassword() {
        StringBuilder sb = new StringBuilder(this.getUserName());
        return sb.reverse().append(this.getUserName().length() * 21).toString();
    }

    @Override
    String getSpecialPointsByLevel() {
        return String.format("%d",this.getSpecialPoints() * this.getLevel());
    }
}
