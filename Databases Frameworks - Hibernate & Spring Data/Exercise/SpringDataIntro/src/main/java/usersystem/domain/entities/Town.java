package usersystem.domain.entities;


import javax.persistence.*;
import java.util.Set;

@Entity(name = "towns")
public class Town{
    private Integer id;
    private String name;
    private String country;
    private Set<User> usersBornIn;
    private Set<User> usersLivingIn;

    public Town() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "country")
    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @OneToMany(mappedBy = "bornTown")
    public Set<User> getUsersBornIn() {
        return this.usersBornIn;
    }

    public void setUsersBornIn(Set<User> usersBornIn) {
        this.usersBornIn = usersBornIn;
    }

    @OneToMany(mappedBy = "currentlyLivingInTown")
    public Set<User> getUsersLivingIn() {
        return this.usersLivingIn;
    }

    public void setUsersLivingIn(Set<User> usersLivingIn) {
        this.usersLivingIn = usersLivingIn;
    }
}
