package com.example.demo.user.control;

import com.example.demo.user.Entity.User;
import com.example.demo.user.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepo userRepo;

    public UserController(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> getAll(){
        Iterable<User> users = this.userRepo.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> create(User user){
        this.userRepo.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
