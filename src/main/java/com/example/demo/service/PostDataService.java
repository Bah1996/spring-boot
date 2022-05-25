package com.example.demo.service;

import com.example.demo.entity.PostData;
import com.example.demo.model.Post;
import com.example.demo.repository.PostDataRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostDataService {
    private final PostDataRepository postDataRepository;


    public PostDataService(PostDataRepository postDataRepository) {
        this.postDataRepository = postDataRepository;
    }
    public PostData save(PostData postData){
        return postDataRepository.save(postData);
    }
    public List<PostData>saveAll(Post[] posts){
        List<PostData> postDateList = new ArrayList<>();
        for (Post post:posts) {
            PostData postDate = new PostData();
            postDate.setPostId(post.getId());
            postDate.setUserId(post.getUserId());
            postDate.setTitle(post.getTitle());
            postDate.setBody(post.getBody());
            postDateList.add(postDate);
        }
        return postDataRepository.saveAll(postDateList);
    }
    @Transactional(readOnly = true)
    public Page<PostData>findAll(Pageable pageable){
        return postDataRepository.findAll(pageable);
    }
}
