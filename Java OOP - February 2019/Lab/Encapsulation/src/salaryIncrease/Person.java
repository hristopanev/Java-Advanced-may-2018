package salaryIncrease;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person() {
    }

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double bonus){
        if (this.getAge() > 30){
            this.salary = this.salary + this.salary * (bonus / 100);
        }else {
            this.salary = this.salary + this.salary * (bonus / 200);
        }
    }

    @Override
    public String toString(){
        return String.format("%s %s gets %f leva",
                this.getFirstName(), this.getLastName(), this.getSalary());
    }
}
