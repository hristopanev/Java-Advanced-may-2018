package entities;


import org.hibernate.loader.plan.spi.Join;
import utils.ToStringExtensions;

import javax.persistence.*;

@Entity(name = "people")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person implements ToStringExtensions {

    private int id;
    private String name;
    private int age;
    private Mother mother;



    public Person(String name) {
        setName(name);
    }

    public Person() {

    }

    @Column(name = "name",
            length = 50,
            nullable = false
    )
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @OneToOne(mappedBy = "child", targetEntity = Mother.class)
    public Mother getMother() {
        return this.mother;
    }

    public void setMother(Mother mother) {
        this.mother = mother;
    }

    @Override
    public String toString() {
        return toString(this.getClass());
    }
}
