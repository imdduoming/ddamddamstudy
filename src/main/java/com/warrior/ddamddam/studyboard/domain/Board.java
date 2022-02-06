package com.warrior.ddamddam.studyboard.domain;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=100)
    private String title;

    @Lob
    private String content;

    private int count;

    private String writer;

    private char deleteYn;

    private LocalDateTime createdDate = LocalDateTime.now();

    private LocalDateTime modifiedDate;

    @Builder
    public Board(String title, String content, String writer, int count, char deleteYn){
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.count = count;
        this.deleteYn = deleteYn;
    }

    public void update(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.modifiedDate = LocalDateTime.now();
    }


    /**
     * 조회 수 증가
     */
//    public void increaseCounts() {
//        this.count++;
//    }

    /**
     * 게시글 삭제
     */
    public void delete() {
        this.deleteYn = 'Y';
    }

}
