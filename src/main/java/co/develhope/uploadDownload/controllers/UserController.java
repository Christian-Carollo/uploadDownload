package co.develhope.uploadDownload.controllers;

import co.develhope.uploadDownload.entities.UserEntities;
import co.develhope.uploadDownload.repository.UserRepository;
import co.develhope.uploadDownload.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("")
    public void create(@RequestBody UserEntities user){

    }

    @PostMapping("/{id}/profile")
    public void uploadProfileImage(@RequestBody UserEntities user){

    }

    @GetMapping("/{id}")
    public void getUserById(@PathVariable Long id){

    }

    @GetMapping("/{id}/profile")
    public void getProfileImage(@PathVariable Long id){

    }

    @GetMapping("/all")
    public void getAllUsers(){

    }

    @PutMapping("/{id}")
    public void update(){

    }

    @DeleteMapping("/{id}")
    public void delete(){

    }

}
