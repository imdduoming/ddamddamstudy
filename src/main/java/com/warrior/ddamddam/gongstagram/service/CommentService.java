package com.warrior.ddamddam.gongstagram.service;

import com.warrior.ddamddam.gongstagram.domain.Comment;
import com.warrior.ddamddam.gongstagram.domain.Post;
import com.warrior.ddamddam.gongstagram.dto.CommentDto;
import com.warrior.ddamddam.gongstagram.repository.CommentRepository;
import com.warrior.ddamddam.gongstagram.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public Comment createComment(CommentDto commentDto)
    {
//        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no such user"));
        Post post = postRepository.findById(commentDto.getIdx()).orElseThrow(() -> new IllegalArgumentException("no such til"));
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Comment comment = new Comment(commentDto,post);
        commentRepository.save(comment);
        int comment_num=post.getNum_comment()+1;
        post.setNum_comment(comment_num);
        postRepository.save(post);
        return comment;
    }

    public List<Comment> getComment(Long id) {
        return commentRepository.findByPostId(id);
    }

    public void deleteComment(Long id)  {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no such comment"));
        Post post=comment.getPost();
        int comment_num=post.getNum_comment()-1;
        post.setNum_comment(comment_num);
        postRepository.save(post);
        commentRepository.deleteById(id);
    }

}
