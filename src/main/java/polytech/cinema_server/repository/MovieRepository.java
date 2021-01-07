package polytech.cinema_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import polytech.cinema_server.model.Movie;

import java.util.Set;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query("SELECT m FROM Movie m WHERE CONCAT(m.title, m.releaseDate, m.category.wording, " +
            "m.director.firstName, m.director.lastName) LIKE %?1%")
    Set<Movie> findByTerm(String term);
}