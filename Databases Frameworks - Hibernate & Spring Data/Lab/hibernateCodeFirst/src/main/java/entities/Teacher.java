package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "teachers")
public class Teacher extends Person {
    private String speciality;
    private boolean isKlassen;


    public Teacher(){}

    public Teacher(String name, String speciality){
        super(name);
        setSpeciality(speciality);
    }

    public String getSpeciality() {
        return this.speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public boolean isKlassen() {
        return this.isKlassen;
    }

    public void setKlassen(boolean klassen) {
        isKlassen = klassen;
    }
}
