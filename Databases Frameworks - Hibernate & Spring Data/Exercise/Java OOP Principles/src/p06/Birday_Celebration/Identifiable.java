package p06.Birday_Celebration;

public abstract class Identifiable {

    private String id;

    protected Identifiable(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    boolean isFake(String id) {
        return this.id.endsWith(id);
    }
}
