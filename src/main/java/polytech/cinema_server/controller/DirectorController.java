package polytech.cinema_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import polytech.cinema_server.model.Director;
import polytech.cinema_server.service.DirectorService;

@RestController
@RequestMapping("/director")
public class DirectorController {

    private final DirectorService directorService;

    @Autowired
    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @PostMapping("")
    ResponseEntity<Director> saveDirector(@RequestBody Director director) {
        Director directorSaved = directorService.saveDirector(director);
        return new ResponseEntity<>(directorSaved, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    ResponseEntity<Director> findByIdDirector(@PathVariable("id") Integer id) {
        Director director = directorService.findByIdDirector(id);
        return new ResponseEntity<>(director, HttpStatus.OK);
    }
}

