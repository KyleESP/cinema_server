package polytech.cinema_server.service;

import polytech.cinema_server.model.Movie;

import javax.persistence.EntityNotFoundException;

public interface MovieService {

    Movie findByIdMovie(Integer id) throws EntityNotFoundException;
}