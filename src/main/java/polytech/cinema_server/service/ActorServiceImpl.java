package polytech.cinema_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import polytech.cinema_server.model.Actor;
import polytech.cinema_server.repository.ActorRepository;

import javax.persistence.EntityNotFoundException;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public Actor findByIdActor(Integer id) throws EntityNotFoundException {
        return actorRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Actor with id " + id + " not found.")
        );
    }
}