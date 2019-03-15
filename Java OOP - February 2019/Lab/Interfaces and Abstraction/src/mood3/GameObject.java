package mood3;

public interface GameObject<T, V> {

    String getUserName();
    String getCharacterType();
    V getSpecialPoints();
    Integer getLevel();
    T  getHashedPassword();
    void setHashedPassword(T password);



}
