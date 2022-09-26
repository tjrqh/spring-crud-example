package com.example.crud.v1.application.dto;

public class PostCreateRequest {
    private String title;
    private String content;

    public PostCreateRequest(String title, String contents) {
        this.title = title;
        this.content = contents;
    }

    public PostCreateRequest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
