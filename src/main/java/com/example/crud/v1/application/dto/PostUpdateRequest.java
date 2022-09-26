package com.example.crud.v1.application.dto;

public class PostUpdateRequest {
    private Long id;
    private String title;
    private String content;

    public PostUpdateRequest() {
    }

    public PostUpdateRequest(Long id, String title, String content) {
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
}
