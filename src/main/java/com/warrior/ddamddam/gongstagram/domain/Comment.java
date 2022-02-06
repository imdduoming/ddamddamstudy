package com.warrior.ddamddam.gongstagram.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.warrior.ddamddam.gongstagram.dto.CommentDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor // 기본생성자를 대신 생성해줍니다.
@Entity // 테이블임을 나타냅니다.
public class Comment extends Timestamped {

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
    private Long id;

    @Column // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String post_comment;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST})
    @JoinColumn(name="post_id", nullable = false)
    private Post post;

//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;

    public Comment(CommentDto commentDto,Post post) {
        this.post_comment = commentDto.getContent();
//        this.user = user;
        this.post=post;

    }


}
