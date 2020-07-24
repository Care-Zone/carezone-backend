package com.middleware.backend.services.impl;

import com.middleware.backend.entities.Post;
import com.middleware.backend.repositories.PostRepositories;
import com.middleware.backend.services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServicesImpl implements PostServices {

    @Autowired
    private PostRepositories postRepositories;

    @Override
    public List<Post> findAllPosts() {
        List<Post> allPosts = postRepositories.findAll();
        return allPosts;
    }

    @Override
    public void savePost(Post postdata) {
        postRepositories.save(postdata);
    }
}
