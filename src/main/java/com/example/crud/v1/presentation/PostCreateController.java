package com.example.crud.v1.presentation;

import com.example.crud.v1.application.PostService;
import com.example.crud.v1.application.dto.PostCreateRequest;
import com.example.crud.v1.application.dto.PostReadResponse;
import com.example.crud.v1.application.dto.PostUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostCreateController {
    @Autowired
    private PostService postService;

    @PostMapping("/post")
    public Long createPost(@RequestBody PostCreateRequest r) {
        return postService.create(r);
    }

    @PutMapping("/update")
    public Long updatePost(@RequestBody PostUpdateRequest u) {
        return postService.update(u);
    }

    @DeleteMapping("/delete")
    public Long deletePost(@PathVariable(value = "id")Long id) {
        return postService.delete(id);
    }

    @GetMapping("/findByTitle")
    public List findByTitle(@PathVariable(value = "title")String title) {
        return postService.findByTitle(title);
    }
    // sql 문으로 타이틀로 포스트를 여러개 검색
    // select * from post where title=''

    @DeleteMapping("/deleteByTitle")
    public List<Long> deleteByTitlePost(@PathVariable(value = "title")String title) {
        return postService.deleteByTitle(title);
    }

    @GetMapping("/post/{id}")
    public PostReadResponse readPost(@PathVariable(value = "id") Long id) {
        PostReadResponse p = new PostReadResponse();
        System.out.println(p.getTitle());
        System.out.println(p.getContent());
        return postService.getPost(id);
    }
}