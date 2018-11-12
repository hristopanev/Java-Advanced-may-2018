package entities;

import utils.ToStringExtensions;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "departments")
public class Department implements ToStringExtensions {
    private int id;
    private String name;
    Set<Employee> employees;


    public Department(String name) {
        setName(name);
    }

    public Department() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "department", targetEntity = Employee.class)
    public Set<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return toString(this.getClass());
    }
}
