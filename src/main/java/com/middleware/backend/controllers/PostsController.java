package com.middleware.backend.controllers;


import com.middleware.backend.entities.Post;
import com.middleware.backend.services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostsController {

    @Autowired
    private PostServices postServices;

    @GetMapping("/all")
    public List<Post> allPosts() {
        return postServices.findAllPosts();
    }

    @PostMapping("/add")
    public String addPost(@RequestBody Post postdata) {
        postServices.savePost(postdata);
        return "Post saved";
    }


}
