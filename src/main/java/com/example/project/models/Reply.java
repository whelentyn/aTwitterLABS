package com.example.project.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "replies")
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post")
    private Post post;

}
