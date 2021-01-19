package polytech.cinema_server.service;

import polytech.cinema_server.model.Actor;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface ActorService {

    Actor saveActor(Actor actor);

    Actor findByIdActor(Integer id) throws EntityNotFoundException;

    List<Actor> findAllActor();
}