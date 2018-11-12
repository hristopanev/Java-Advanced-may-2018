package entities;

import javax.persistence.*;

@Entity(name = "students")
public class Student extends Person{

    @Column(name = "grade")
    private int grade;

    public Student (){
        super();
    }

    public Student(String name, int grade) {
        super(name);
        setGrade(grade);
    }

    public int getGrade() {
        return this.grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
