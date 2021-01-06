package polytech.cinema_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import polytech.cinema_server.model.Category;
import polytech.cinema_server.model.Movie;
import polytech.cinema_server.repository.MovieRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final CategoryService categoryService;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, CategoryService categoryService) {
        this.movieRepository = movieRepository;
        this.categoryService = categoryService;
    }

    @Override
    public Movie findByIdMovie(Integer id) throws EntityNotFoundException {
        return movieRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Movie with id " + id + " not found")
        );
    }

    @Override
    public List<Movie> findAllMovie() {
        return movieRepository.findAll();
    }

    @Override
    public Set<Movie> findMoviesByCategoryIdMovie(String categoryId) throws EntityNotFoundException {
        Category category = categoryService.findByIdCategory(categoryId);
        return category.getMovies();
    }
}