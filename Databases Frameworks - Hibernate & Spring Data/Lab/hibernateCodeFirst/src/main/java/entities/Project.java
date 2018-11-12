package entities;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "name")
public class Project {
    private int id;
    private String name;
    private Set<Employee> employees;

    public Project(){}

    public Project(String name){
        setName(name);
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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "projects_employees",
            joinColumns = @JoinColumn(
                    name = "project_id", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "employee_id",
                    referencedColumnName = "id"
            )
    )
    public Set<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
