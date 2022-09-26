package com.example.crud.v1.application.dto;

import com.example.crud.v1.domain.Post;

public class PostReadResponse {
    private Long id;
    private String title;
    private String content;

    public PostReadResponse(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public PostReadResponse() {
    }


    public static PostReadResponse fromEntity(Post post){
        return new PostReadResponse(
                post.getId(),
                post.getTitle(),
                post.getContent()
        );
    }
}
