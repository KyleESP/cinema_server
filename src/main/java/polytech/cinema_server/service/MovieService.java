package polytech.cinema_server.service;

import polytech.cinema_server.model.Movie;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;

public interface MovieService {

    Movie saveMovie(Movie movie);

    Movie findByIdMovie(Integer id) throws EntityNotFoundException;

    List<Movie> findAllMovie();

    Set<Movie> findByCategoryIdMovie(String categoryId) throws EntityNotFoundException;

    Set<Movie> findByTermMovie(String term);

    Movie updateByIdMovie(Integer id, Movie movieDetails) throws EntityNotFoundException;

    Movie deleteByIdMovie(Integer id) throws EntityNotFoundException;
}