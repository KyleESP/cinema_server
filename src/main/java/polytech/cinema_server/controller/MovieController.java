package polytech.cinema_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import polytech.cinema_server.model.Movie;
import polytech.cinema_server.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    ResponseEntity<Movie> findByIdMovie(@PathVariable("id") Integer id) {
        Movie movie = movieService.findByIdMovie(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }
}

