package polytech.cinema_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import polytech.cinema_server.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}