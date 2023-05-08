package com.example.project.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name="posts")

public class Post {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String description;

    @Column
    private String imageURL;

    @Column
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @OneToMany
    private List<React> reactions;

    @OneToMany
    private List<Reply> replies;


}
