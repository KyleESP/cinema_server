package polytech.cinema_server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonSerialize(as = Director.class)
@Table(name = "director")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id", length = 2)
    private Integer id;

    @Basic
    @Column(nullable = false, name = "last_name", length = 20)
    private String lastName;

    @Basic
    @Column(nullable = false, name = "first_name", length = 20)
    private String firstName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="director", orphanRemoval = true)
    @JsonIgnore
    private Set<Movie> movies;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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