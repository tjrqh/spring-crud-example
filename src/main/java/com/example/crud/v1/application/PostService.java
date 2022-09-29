package com.example.crud.v1.application;

import com.example.crud.v1.application.dto.PostCreateRequest;
import com.example.crud.v1.application.dto.PostReadResponse;
import com.example.crud.v1.application.dto.PostUpdateRequest;
import com.example.crud.v1.domain.Post;
import com.example.crud.v1.infrastructure.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


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

    public Long delete(final Long id) {
        Post p = postRepository.getById(id);
        postRepository.delete(p);
        return p.getId();
    }

    public List<Post> findByTitle(final String title) {
        // 타이틀을 검색해 그리고 그것을 리스트화 하고 리턴
        List<Post> po = postRepository.findByTitle(title);
        return po;
    }

    public List<Long> deleteByTitle(final String title) {
        // 검색한 것에 대한 넘버값을 알아낸 후 삭제   리스트 순회해서 포스트 값 딜리트
        List<Post> postList = postRepository.findByTitle(title);
        List<Long> deletedIds = new LinkedList<>();

        // i 0부터 10까지 순회
        for (int i = 0; i < postList.size(); i++) {
            Post post = postList.get(i);
            deletedIds.add(post.getId());
            postRepository.delete(post);
        }
        // 리턴하고싶은것이 삭제된 아이디의 리스트 번호
        return deletedIds;
    }


    public PostReadResponse getPost(final Long id) {
        return PostReadResponse.fromEntity(postRepository.getById(id));
    }
}
