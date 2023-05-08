package com.example.project.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "users")
@Data

public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long id;
    @Column(unique=true)
    private String username;

    @Column
    private String email;

    @Column
    private String password;

    @OneToMany(mappedBy="to")
    private List<User> followers;

    @OneToMany(mappedBy="from")
    private List<User> following;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
