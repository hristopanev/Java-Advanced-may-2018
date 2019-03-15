package mood3;

public class Demon extends Character<Integer, Double> {

    public static final String CHARACTER_TYPE = "Demon";

    Demon(String userName, int level, Double specialPoints){
        super(userName, CHARACTER_TYPE, specialPoints, level);
    }

    @Override
    public Integer getHashedPassword() {
        return this.getUserName().length() * 217;
    }


    @Override
    String getSpecialPointsByLevel() {
        return String.format("%.1f",this.getSpecialPoints() * this.getLevel());
    }
}
