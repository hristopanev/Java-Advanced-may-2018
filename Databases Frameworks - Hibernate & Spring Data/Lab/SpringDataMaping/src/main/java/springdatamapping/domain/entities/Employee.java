package springdatamapping.domain.entities;


import javax.persistence.*;

@Entity(name = "employees")
public class Employee {
    private Long id;
    private String firstName;
    private String LastName;
    private Department department;

    public Employee() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column
    public String getLastName() {
        return this.LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    @ManyToOne(targetEntity =  Department.class)
    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", department=" + department +
                '}';
    }
}
