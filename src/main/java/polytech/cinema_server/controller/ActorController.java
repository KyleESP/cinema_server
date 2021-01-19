package polytech.cinema_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import polytech.cinema_server.model.Actor;
import polytech.cinema_server.service.ActorService;

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
}

