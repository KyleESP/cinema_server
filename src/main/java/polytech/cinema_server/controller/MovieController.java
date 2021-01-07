package polytech.cinema_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import polytech.cinema_server.model.Movie;
import polytech.cinema_server.service.MovieService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("")
    ResponseEntity<List<Movie>> findAllMovie() {
        List<Movie> movies = movieService.findAllMovie();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Movie> findByIdMovie(@PathVariable("id") Integer id) {
        Movie movie = movieService.findByIdMovie(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @GetMapping("/by-category")
    ResponseEntity<Set<Movie>> findByCategoryIdMovie(@RequestParam("categoryId") String categoryId) {
        Set<Movie> movies = movieService.findByCategoryIdMovie(categoryId);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/by-term")
    ResponseEntity<Set<Movie>> findByTermMovie(@RequestParam("term") String term) {
        Set<Movie> movies = movieService.findByTermMovie(term);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
}

