package polytech.cinema_server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonSerialize(as = Category.class)
@Table(name = "category")
public class Category {

    @Id
    @Column(nullable = false, name = "id", length = 2)
    private String id;

    @Basic
    @Column(nullable = false, name = "wording", length = 20)
    private String wording;

    @Basic
    @Column(nullable = false, name = "image", length = 200)
    private String image;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="category", orphanRemoval = true)
    private Set<Movie> movies;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @JsonIgnore
    public Set<Movie> getMovies() {
        return movies;
    }

    @JsonProperty
    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}