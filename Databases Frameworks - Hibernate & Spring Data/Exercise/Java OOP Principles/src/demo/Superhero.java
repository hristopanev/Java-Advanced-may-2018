import java.util.ArrayList;

public class Superhero implements  Flyable {
    private  ArrayList<String> powers;
    private String name;
    private   String secretIdentity;

    Superhero (String name, String secretIdentity){
        setName(name);
        setSecretIdentity(secretIdentity);
        this.powers = new ArrayList<String>();
    }

    public void  setName(String name){

        //Validation

        if (name.length() == 0){
            throw  new  IllegalMonitorStateException("Name cannot be empty");
        }
        this.name = name;
    }

    public  String getName(){
        return  name;
    }

    public void setSecretIdentity(String secretIdentity) {
        this.name = secretIdentity;
    }

    public String getSecretIdentity() {
        return name;
    }

    public  ArrayList<String> getPowers(){
        return powers;
    }

    public  void addPower(String power){
        //VALIDATION

        if (power.length() == 0){
            throw new IllegalMonitorStateException("Power cannot be empty");
        }
        this.powers.add(power);
    }

    @Override
    public void fly() {
        System.out.printf("%s is flying%n", getName());
    }
}
