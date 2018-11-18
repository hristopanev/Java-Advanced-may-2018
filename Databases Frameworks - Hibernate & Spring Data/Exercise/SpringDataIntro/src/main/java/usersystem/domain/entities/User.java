package usersystem.domain.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "users")
public class User {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private byte profilePictures;
    private Date registredOn;
    private Date lastTimeLoggedOn;
    private Integer age;
    private boolean isDeleted;

    private String firstName;
    private String lastName;

    private Town bornTown;
    private Town currentlyLivingInTown;

    private Set<User> friends;
    private Set<Album> albums;

    public User() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column (name = "name", nullable = false, length = 30)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column (name = "password", nullable = false)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "email")
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "profile_picture")
    public byte getProfilePictures() {
        return this.profilePictures;
    }

    public void setProfilePictures(byte profilePictures) {
        this.profilePictures = profilePictures;
    }

    @Column(name = "registred_on")
    public Date getRegistredOn() {
        return this.registredOn;
    }

    public void setRegistredOn(Date registredOn) {
        this.registredOn = registredOn;
    }

    @Column(name = "last_time_logged_on")
    public Date getLastTimeLoggedOn() {
        return this.lastTimeLoggedOn;
    }

    public void setLastTimeLoggedOn(Date lastTimeLoggedOn) {
        this.lastTimeLoggedOn = lastTimeLoggedOn;
    }

    @Column(name = "age")
    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name = "is_deleted")
    public boolean isDeleted() {
        return this.isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @ManyToOne
    @JoinColumn(name = "born_town_id", referencedColumnName = "id")
    public Town getBornTown() {
        return this.bornTown;
    }

    public void setBornTown(Town bornTown) {
        this.bornTown = bornTown;
    }

    @ManyToOne
    @JoinColumn(name = "living_id_town_id", referencedColumnName = "id")
    public Town getCurrentlyLivingInTown() {
        return this.currentlyLivingInTown;
    }

    public void setCurrentlyLivingInTown(Town currentlyLivingInTown) {
        this.currentlyLivingInTown = currentlyLivingInTown;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_friends",
    joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "fiends_id", referencedColumnName = "id"))
    public Set<User> getFriends() {
        return this.friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    @OneToMany(mappedBy = "owner")
    public Set<Album> getAlbums() {
        return this.albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }
}
