package com.example.project.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "reacts")
public class React {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

}
