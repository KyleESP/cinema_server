package polytech.cinema_server.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;

@Entity
@JsonSerialize(as = Figure.class)
@Table(name = "figure")
@IdClass(FigurePK.class)
public class Figure {

    @Id
    @Column(name = "actor_id")
    private Integer actorId;

    @Id
    @Column(name = "movie_id")
    private Integer movieId;

    @Basic
    @Column(nullable = false, name = "name", length = 30)
    private String name;

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}