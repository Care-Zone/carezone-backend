package com.middleware.backend.controllers;

import com.middleware.backend.dto.SuccessResponse;
import com.middleware.backend.model.Post;
import com.middleware.backend.repositories.PostRepository;
import javafx.geometry.Pos;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Controller
@RequestMapping(path = "api/posts/")
public class PostController {

    private final PostRepository postRepository;


    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping(path = "all")
    public @ResponseBody
    Iterable<Post> getposts() {
        return postRepository.findAll();
    }

    @GetMapping(path = "{postId}")
    public @ResponseBody
    Post getpost(@PathVariable Integer postId) {
        Optional<Post> post = postRepository.findById(postId);

        if (post.isPresent()) {
            return post.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("add")
    public @ResponseBody
    SuccessResponse createPost(@RequestBody Post post) {
        if (post.getDescription() == null || post.getSymptom() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            postRepository.save(post);
            return new SuccessResponse();
        }
    }

    @PutMapping(path = "{postId}")
    public @ResponseBody
    SuccessResponse updatePost(@PathVariable Integer postId, @RequestBody Post newpost) {
        Optional<Post> optionalPost = postRepository.findById(postId);


        Post oldpost = optionalPost.get();

        if (newpost.getDescription() != null) {
            oldpost.setDescription(newpost.getDescription());
        }

        if (newpost.getSymptom() != null) {
            oldpost.setSymptom(newpost.getSymptom());
        }

        if (newpost.getVotes() != null) {
            oldpost.setVotes(newpost.getVotes());
        }

        postRepository.save(oldpost);
        return new SuccessResponse();
    }

    @DeleteMapping(path = "{postId}")
    public @ResponseBody
    SuccessResponse deleteStudent(@PathVariable Integer postId) {
        boolean post = postRepository.existsById(postId);

        if (post) {
            postRepository.deleteById(postId);
            return new SuccessResponse();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
