package polytech.cinema_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import polytech.cinema_server.model.Actor;

import java.util.Set;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
    @Query("SELECT a FROM Actor a WHERE CONCAT(" +
            "a.lastName, ' ', " +
            "COALESCE(a.firstName, ''), ' ', " +
            "a.lastName, ' ', " +
            "COALESCE(a.birthdayDate, ''), ' ', " +
            "COALESCE(a.deathdayDate, '')" +
            ") LIKE %?1%")
    Set<Actor> findByTerm(String term);
}