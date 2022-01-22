package com.warrior.ddamddam.gongstagram.service;

import com.warrior.ddamddam.gongstagram.domain.Post;
import com.warrior.ddamddam.gongstagram.dto.PostDto;
import com.warrior.ddamddam.gongstagram.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final FileService fileService;
    public Post createPost(String content, MultipartFile imageFile) throws SQLException {
        //User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no such user"));

        Post post = new Post();
        post.setContent(content);
        post.setImage(imageFile.getOriginalFilename());
        post.setImage_real(fileService.uploadImage(imageFile));
        postRepository.save(post);

//        if(!(tilRequestDto.getTags().isEmpty())) {
//            String[] tagArray = tilRequestDto.getTags().split("\\s*,\\s*");
//            List<Tag> tagList = new ArrayList<>();
//            for (String s : tagArray) {
//                Tag tag = new Tag(s, til);
//                tagList.add(tag);
//            }
//            tagRepository.saveAll(tagList);
//        }

        return post;
    }
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }


    @Transactional
    public void updatePost(Long id, PostDto postDto)throws SQLException{
        Post post = postRepository.findById(id).orElseThrow(
                ()->new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );

        post.updateMyPost(postDto);

//        if(!(tilRequestDto.getTags().isEmpty())) {
//            String[] tagArray = tilRequestDto.getTags().split("\\s*,\\s*");
//            List<Tag> tagList = new ArrayList<>();
//            for (String s : tagArray) {
//                if(tagRepository.findByNameAndTil(s,til).size()==0d) {
//                    Tag tag = new Tag(s, til);
//                    tagList.add(tag);
//                }
//            }
//            tagRepository.saveAll(tagList);
//        }

    }

    public Post getPost(Long id) {
        return postRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다")
        );
    }
}
