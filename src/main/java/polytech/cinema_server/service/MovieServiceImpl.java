package polytech.cinema_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import polytech.cinema_server.model.Movie;
import polytech.cinema_server.repository.MovieRepository;

import javax.persistence.EntityNotFoundException;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie findByIdMovie(Integer id) throws EntityNotFoundException {
        return movieRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Movie with id " + id + " not found")
        );
    }
}