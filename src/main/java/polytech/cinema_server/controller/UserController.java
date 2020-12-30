package polytech.cinema_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import polytech.cinema_server.model.User;
import polytech.cinema_server.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    ResponseEntity<User> findByIdUser(@PathVariable("id") Integer id) {
        User user = userService.findByIdUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/login")
    ResponseEntity<User> findByEmailAndPasswordUser(@RequestBody User user) {
        User userFound = userService.findByEmailAndPasswordUser(user.getEmail(), user.getPassword());
        return new ResponseEntity<>(userFound, HttpStatus.OK);
    }
}