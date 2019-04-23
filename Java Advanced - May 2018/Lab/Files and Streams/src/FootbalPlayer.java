import java.io.Serializable;

public class FootbalPlayer implements Serializable {
    private String name;
    private int age;
    private String team;
    private double salary;


    public FootbalPlayer(String name, int age, String team, double salary) {
        this.name = name;
        this.age = age;
        this.team = team;
        this.salary = salary;
    }

    public FootbalPlayer(String name, String age, String salary, String team) {

    }


    public double getSalary() {
        return this.salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age + " " + this.team + " " + this.salary;
    }
}
