package polytech.cinema_server.service;

import polytech.cinema_server.model.Actor;

import javax.persistence.EntityNotFoundException;

public interface ActorService {

    Actor findByIdActor(Integer id) throws EntityNotFoundException;
}