package polytech.cinema_server.service;

import polytech.cinema_server.model.Movie;

import javax.persistence.EntityNotFoundException;
import java.util.Set;

public interface MovieService {

    Movie findByIdMovie(Integer id) throws EntityNotFoundException;

    Set<Movie> findCategoriesByIdMovie(String categoryId) throws EntityNotFoundException;
}