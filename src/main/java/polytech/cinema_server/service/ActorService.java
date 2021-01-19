package polytech.cinema_server.service;

import polytech.cinema_server.model.Actor;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;

public interface ActorService {

    Actor saveActor(Actor actor);

    Actor findByIdActor(Integer id) throws EntityNotFoundException;

    List<Actor> findAllActor();

    Set<Actor> findByTermActor(String term);
}