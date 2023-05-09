package com.example.project.services;

import com.example.project.models.Post;
import com.example.project.models.Reply;

import java.util.List;

public interface PostService {

    List<Post> getAllPosts();

    List<Post> getFeedPosts(Long id);

    Post getPostById (Long id);

    void newPost (Post post, Long id);

    void deletePost (Post post);

    void repostPost (Post post, Long id);


}
