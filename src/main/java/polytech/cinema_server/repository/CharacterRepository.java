package polytech.cinema_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import polytech.cinema_server.model.Figure;
import polytech.cinema_server.model.FigurePK;

@Repository
public interface CharacterRepository extends JpaRepository<Figure, FigurePK> {
}