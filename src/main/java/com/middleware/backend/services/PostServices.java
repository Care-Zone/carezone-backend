package com.middleware.backend.services;

import com.middleware.backend.entities.Post;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostServices {

    List<Post> findAllPosts();

    void savePost(Post post);


}
