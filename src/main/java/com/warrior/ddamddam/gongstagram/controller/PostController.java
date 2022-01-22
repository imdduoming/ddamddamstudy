package com.warrior.ddamddam.gongstagram.controller;

import com.warrior.ddamddam.gongstagram.domain.Post;
import com.warrior.ddamddam.gongstagram.dto.PostDto;
import com.warrior.ddamddam.gongstagram.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PostController {
    private final PostService postService;
    @PostMapping("/gongstagram/post")
    public Post createPost(@RequestParam("content") String content,@RequestParam("file") MultipartFile imagefile) throws SQLException {
        Post post = postService.createPost(content,imagefile);
        return post;
    }

    @GetMapping("/gongstagram/post")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();

    }
    @GetMapping("/gongstagram/post/{id}")
    public Post getPost(@PathVariable Long id){

        return postService.getPost(id);
    }

    @DeleteMapping("/gongstagram/post/{id}")
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }

    @PutMapping("/gongstagram/post/{id}")
    public void updatePost(@PathVariable Long id,@RequestBody PostDto postDto) throws SQLException{
        postService.updatePost(id, postDto);
    }


}
