package com.example.demo.user.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue(generator = "userSeqGen")
    private long id;

    private String firstName;

    private String lastName;

//Setters, getters and constructors

}