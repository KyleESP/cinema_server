package polytech.cinema_server.service;

import polytech.cinema_server.model.Movie;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;

public interface MovieService {

    Movie findByIdMovie(Integer id) throws EntityNotFoundException;

    List<Movie> findAllMovie();

    Set<Movie> findMoviesByCategoryIdMovie(String categoryId) throws EntityNotFoundException;
}