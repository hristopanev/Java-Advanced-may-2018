package entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "mother")
public class Mother extends Person{
    private Person child;

    public Mother(){}

    public Mother(String name){
        super(name);
    }

    @OneToOne
    @JoinColumn(
            name = "child_id",
            referencedColumnName = "id"
    )
    public Person getChild() {
        return this.child;
    }

    public void setChild(Person child) {
        this.child = child;
    }
}
