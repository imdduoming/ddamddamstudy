package com.warrior.ddamddam.gongstagram.repository;

import com.warrior.ddamddam.gongstagram.domain.Comment;
import com.warrior.ddamddam.gongstagram.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByPostId(Long post_id);
}
