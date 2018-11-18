package usersystem.domain.entities;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "albums")
public class Album {
    private Integer id;
    private String name;
    private String backgroundColor;
    private boolean isPubil;

    private Set<Picture> pictures;
    private User owner;

    public Album() {
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

    @Column(name = "background_color")
    public String getBackgroundColor() {
        return this.backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Column(name = "is_public")
    public boolean isPubil() {
        return this.isPubil;
    }

    public void setPubil(boolean pubil) {
        isPubil = pubil;
    }

    @ManyToMany
    @JoinTable(name = "albums_pictures",
    joinColumns = @JoinColumn(name = "album_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "picture_id", referencedColumnName = "id"))
    public Set<Picture> getPictures() {
        return this.pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    public User getOwner() {
        return this.owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
