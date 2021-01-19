package polytech.cinema_server.model;

import java.io.Serializable;
import java.util.Objects;

public class FigurePK implements Serializable {

    private Integer actor;

    private Integer movie;

    public Integer getActor() {
        return actor;
    }

    public void setActor(Integer actor) {
        this.actor = actor;
    }

    public Integer getMovie() {
        return movie;
    }

    public void setMovie(Integer movie) {
        this.movie = movie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FigurePK)) return false;
        FigurePK figurePK = (FigurePK) o;
        return actor.equals(figurePK.actor) && movie.equals(figurePK.movie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actor, movie);
    }
}