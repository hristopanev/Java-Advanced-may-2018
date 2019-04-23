package P03_animal_Farm;

import java.text.DecimalFormat;

public class Chicken {
    private static final String INVALID_NAME_EXCEPTION_MASSAGE = "Name cannot be empty.";
    private static final String INVALID_AGE_EXCEPTION_MESSAGE = "Age should be between 0 and 15.";

    private String name;
    private int age;

    public Chicken(String name, int age){
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name){
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(INVALID_NAME_EXCEPTION_MASSAGE);
        }
        this.name = name;
    }

    private void setAge(int age){
        if (age < 0 || age > 15 ){
            throw new IllegalArgumentException(INVALID_AGE_EXCEPTION_MESSAGE);
        }
        this.age = age;
    }

    private double CalculateProductPerDay(){
        if (this.age < 6){
            return 2;
        }else if (this.age < 12){
            return 1;
        }else {
            return 0.75;
        }
    }

    @Override
    public String toString(){

        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("Chicken %s (age %s) can produce %s eggs per day.",
                this.name, this.age, df.format(this.CalculateProductPerDay()));
    }
}
