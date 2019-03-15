package mood3;

public abstract class Character<T, V> implements GameObject<T, V> {
    private String userName;
    private String characterType;
    private V specialPoints;
    private Integer level;
    private T hashedPassword;

    public Character(String userName, String characterType, V specialPoints, Integer level) {
        this.userName = "\"" + userName + "\"";
        this.characterType = characterType;
        this.specialPoints = specialPoints;
        this.level = level;
    }

    @Override
    public String getUserName() {
        return this.userName;
    }

    @Override
    public String getCharacterType() {
        return this.characterType;
    }

    @Override
    public V getSpecialPoints() {
        return this.specialPoints;
    }

    @Override
    public Integer getLevel() {
        return this.level;
    }

    @Override
    public void setHashedPassword(T password) {
            this.hashedPassword = password;
    }

    abstract String  getSpecialPointsByLevel();

    @Override
    public String toString() {
        return String.format("\"%s\" | \"%s\" -> %s%n%s",
                this.getUserName(),
                this.getHashedPassword(),
                this.getCharacterType(),
                this.getSpecialPointsByLevel());
    }
}
