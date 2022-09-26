package com.example.crud.v1.presentation;

import com.example.crud.v1.application.PostService;
import com.example.crud.v1.application.dto.PostCreateRequest;
import com.example.crud.v1.application.dto.PostReadResponse;
import com.example.crud.v1.application.dto.PostUpdateRequest;
import com.example.crud.v1.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostCreateController {
    @Autowired
    private PostService postService;

    @PostMapping("/post")
    public Long createPost(@RequestBody PostCreateRequest r) {
        System.out.println(r.getTitle());
        System.out.println(r.getContent());
        return postService.create(r);
    }

    @PutMapping("/update")
    public Long updatePost(@RequestBody PostUpdateRequest u) {
        return postService.update(u);
    }

    @DeleteMapping("/delete")
    public Long deletePost(@RequestBody PostReadResponse p) {
        return postService.delete(p);
    }

    @GetMapping("/post/{id}")
    public PostReadResponse readPost(@PathVariable(value = "id") Long id) {
        PostReadResponse p = new PostReadResponse();
        System.out.println(p.getTitle());
        System.out.println(p.getContent());
        return postService.getPost(id);
    }
}