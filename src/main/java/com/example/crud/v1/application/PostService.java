package com.example.crud.v1.application;

import com.example.crud.v1.application.dto.PostCreateRequest;
import com.example.crud.v1.application.dto.PostReadResponse;
import com.example.crud.v1.application.dto.PostUpdateRequest;
import com.example.crud.v1.domain.Post;
import com.example.crud.v1.infrastructure.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Long create(final PostCreateRequest r) {
        Post p = new Post(r.getTitle(), r.getContent());
        postRepository.save(p);
        return postRepository.save(p).getId();
    }

    public Long update(final PostUpdateRequest u) {
        Post p = postRepository.getById(u.getId());
        p.setTitle(u.getTitle());
        p.setContent(u.getContent());
        p = postRepository.save(p);
        return p.getId();
    }
    public Long delete(final PostReadResponse pr){
        Post p = postRepository.getById(pr.getId());
        postRepository.delete(p);
        return p.getId();
    }

    public PostReadResponse getPost(final Long id) {
        return PostReadResponse.fromEntity(postRepository.getById(id));
    }
}
