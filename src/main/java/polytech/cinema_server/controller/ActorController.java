package polytech.cinema_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import polytech.cinema_server.model.Actor;
import polytech.cinema_server.service.ActorService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/actor")
public class ActorController {

    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @PostMapping("")
    ResponseEntity<Actor> saveActor(@RequestBody Actor actor) {
        Actor actorSaved = actorService.saveActor(actor);
        return new ResponseEntity<>(actorSaved, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    ResponseEntity<Actor> findByIdActor(@PathVariable("id") Integer id) {
        Actor actor = actorService.findByIdActor(id);
        return new ResponseEntity<>(actor, HttpStatus.OK);
    }

    @GetMapping("")
    ResponseEntity<List<Actor>> findAllActor() {
        List<Actor> actors = actorService.findAllActor();
        return new ResponseEntity<>(actors, HttpStatus.OK);
    }

    @GetMapping("/by-term")
    ResponseEntity<Set<Actor>> findByTermActor(@RequestParam("term") String term) {
        Set<Actor> actors = actorService.findByTermActor(term);
        return new ResponseEntity<>(actors, HttpStatus.OK);
    }
}

