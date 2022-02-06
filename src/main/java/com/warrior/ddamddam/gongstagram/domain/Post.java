package com.warrior.ddamddam.gongstagram.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.warrior.ddamddam.gongstagram.dto.PostDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Post extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "post_id")
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String image_real;

    @Column(nullable = false)
    private int num_comment;

    @JsonIgnore
    @OneToMany(mappedBy="post", cascade = { CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Comment> comments;

    @Builder
    public Post(PostDto postDto) {
        this.content = postDto.getContent();
    }

    public void updateMyPost(PostDto postDto){
        this.content= postDto.getContent();

    }


}
