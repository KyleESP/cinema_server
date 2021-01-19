package polytech.cinema_server.service;

import polytech.cinema_server.model.Director;

import javax.persistence.EntityNotFoundException;

public interface DirectorService {
    Director saveDirector(Director director);

    Director findByIdDirector(Integer id) throws EntityNotFoundException;
}