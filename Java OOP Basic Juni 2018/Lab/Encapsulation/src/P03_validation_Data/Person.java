package P03_validation_Data;

import java.text.DecimalFormat;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;
    private DecimalFormat format;

    public Person() {

        this.format = new DecimalFormat("#.0#########################");
    }

    public Person(String firstName, String lasstName, int age, double salary) {
        this();
        this.setFirstName(firstName);
        this.setLastName(lasstName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public String getFirstName() {

        return this.firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() < 3) {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }

        this.firstName = firstName;
    }

    public String getLastName() {

        return this.lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age < 1) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public double getSalary()
    {
        return this.salary;
    }

    public void setSalary(double salary) {

        if (salary < 460) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    public void increaseSalary(int bonus) {
        if (this.getAge() < 30) {
            this.setSalary(this.getSalary() + (this.getSalary() * bonus / 200.0));
        } else {
            this.setSalary(this.getSalary() + (this.getSalary() * bonus / 100.0));
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %s leva",
                this.getFirstName(), this.getLastName(),
                this.format.format(this.getSalary()));
    }
}


