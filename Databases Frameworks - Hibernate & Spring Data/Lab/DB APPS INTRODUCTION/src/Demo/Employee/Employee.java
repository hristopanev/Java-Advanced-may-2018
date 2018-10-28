package Demo.Employee;

import java.lang.reflect.Type;

public class Employee implements Type {

    private String firstName;
    private String lastName;
    private long id;


    public Employee(String firstName, String lastName){
        this(0, firstName, lastName);
    }

    public Employee(long id, String firstName, String lastName){
        setID(id);
        setFirstName(firstName);
        setLastName(lastName);
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setID(long id) {
        this.id = id;
    }

    public long getID() {
        return id;
    }

    @Override
    public String getTypeName() {
        return null;
    }
}
