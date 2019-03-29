package com.example.demo.user.control;

import com.example.demo.user.Entity.User;
import com.example.demo.user.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepo userRepo;

    public UserController(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> getAll(){
        Iterable<User> users = userRepo.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable Long id) {
        User boyyyyy = userRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        return ResponseEntity.ok(boyyyyy);
    }

    @PostMapping
    public ResponseEntity<User> create(User user){
        userRepo.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
