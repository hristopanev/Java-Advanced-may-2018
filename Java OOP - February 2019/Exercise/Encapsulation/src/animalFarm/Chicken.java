package animalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age){
        this.setName(name);
        this.setAge(age);
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    private void setName(String name){
        if (name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age){
        if (age < 0 || age > 15){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    private double calculateProductPerDay(){
        double productPerDay = 0;
        if (this.age >= 0 && this.age < 6){
            productPerDay = 2;
        }else if (this.age <= 11){
            productPerDay = 1;
        }else {
            productPerDay = 0.75;
        }

        return productPerDay;
    }

    public double productPerDay(){
        return this.calculateProductPerDay();
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.0f eggs per day.%n",
                this.getName(), this.getAge(), this.productPerDay());
    }
}
