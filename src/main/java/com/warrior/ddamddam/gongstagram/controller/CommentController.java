package com.warrior.ddamddam.gongstagram.controller;

import com.warrior.ddamddam.gongstagram.domain.Comment;
import com.warrior.ddamddam.gongstagram.dto.CommentDto;
import com.warrior.ddamddam.gongstagram.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/post/comment")
    public Comment createComment(@RequestBody CommentDto commentDto) throws SQLException {
        return commentService.createComment(commentDto);
    }

    @GetMapping("/post/comments/{id}")
    public List getComment(@PathVariable Long id) throws SQLException {
        List<Comment> comments = commentService.getComment(id);
//        User user = userService.getUser(userDetails.getUser().getId());

        return comments;
    }

    @DeleteMapping("/post/comments/{id}")
    public Long deleteComment(@PathVariable Long id) throws SQLException {
        commentService.deleteComment(id);
        return id;
    }


}
