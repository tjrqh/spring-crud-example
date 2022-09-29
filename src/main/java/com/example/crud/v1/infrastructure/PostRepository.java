package com.example.crud.v1.infrastructure;

import com.example.crud.v1.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Override
    Post getById(Long aLong);

    List<Post> findByTitle(String s);
}