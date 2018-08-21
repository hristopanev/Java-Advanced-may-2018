package P01_Person;

public class Person {

    private String name;
    private int age;

    public Person(){}

    public Person(String name, int age){
        this.setName(name);
        this.setAge(age);
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        if (name.length() < 3){
            throw new IllegalArgumentException("Name's length should not be less than 3 symbols!");
        }else {
            this.name = name;
        }
    }

    public int getAge(){
        return this.age;
    }
    public void setAge(int age){
        if (age < 1){
            throw new IllegalArgumentException("Age must be positive!");
        }else {
            this.age = age;
        }
    }

    @Override
    public String toString(){
        return String.format("Name: %s, Age: %d",
                this.name, this.age);
    }

}
