package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "employees")
public class Employee  extends Person{
    private Date hireDate;
    private Department department;
    private Set<Project> project;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee(){}

    public Employee(String name, Date hireDate){
        super(name);
        setHireDate(hireDate);
    }


    @Column(name = "hire_date")
    public Date getHireDate() {
        return this.hireDate;
    }


    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }


    @ManyToMany(
            mappedBy = "employees",
            targetEntity = Project.class
    )
    public Set<Project> getProject() {
        return this.project;
    }

    public void setProject(Set<Project> project) {
        this.project = project;
    }
}
