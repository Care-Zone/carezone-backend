package com.middleware.backend.repositories;

import com.middleware.backend.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepositories extends JpaRepository<Post,Integer> {
}
