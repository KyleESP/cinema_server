package polytech.cinema_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import polytech.cinema_server.model.Actor;
import polytech.cinema_server.repository.ActorRepository;

@RestController
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    private ActorRepository actorRepository;

    @GetMapping("/{id}")
    Actor findByIdActor(@PathVariable("id") Integer number) {
        return null;
    }
}

