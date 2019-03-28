package com.example.demo.user.repository;

import com.example.demo.user.Entity.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepo extends CrudRepository<User, Long> {
}
