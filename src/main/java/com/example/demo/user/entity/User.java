package com.example.demo.user.entity;

import com.example.demo.VersionedEntity;
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
@Table(name = "demo_user")
public class User extends VersionedEntity {

    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;

}