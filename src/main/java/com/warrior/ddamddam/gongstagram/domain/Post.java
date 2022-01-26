package com.warrior.ddamddam.gongstagram.domain;


import com.warrior.ddamddam.gongstagram.dto.PostDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    private String image;

    private String image_real;

    @Builder
    public Post(PostDto postDto) {
        this.content = postDto.getContent();

    }
    public void updateMyPost(PostDto postDto){
        this.content= postDto.getContent();

    }


}
