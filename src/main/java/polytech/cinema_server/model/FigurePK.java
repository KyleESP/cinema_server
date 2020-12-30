package polytech.cinema_server.model;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class FigurePK implements Serializable {

    @Column(nullable = false, name = "actor_id", length = 4)
    private Integer actorId;

    @Column(nullable = false, name = "movie_id", length = 4)
    private Integer movieId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FigurePK)) return false;
        FigurePK figurePK = (FigurePK) o;
        return actorId.equals(figurePK.actorId) && movieId.equals(figurePK.movieId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, movieId);
    }
}