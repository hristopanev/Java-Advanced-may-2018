package catLady;

public abstract class Cat {
    private String name;

    public Cat(String name){
        this.name = name;
    }

   public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        return this.getClass().getName() + " " + this.getName();
    }


}
