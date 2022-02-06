package com.warrior.ddamddam.studyboard.dto;

import com.warrior.ddamddam.studyboard.domain.Board;
import com.warrior.ddamddam.studyboard.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardSaveRequestDto {

    private String title;
    private String content;
    private String writer;
    private char deleteYn;

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .count(0)
                .deleteYn(deleteYn)
                .build();
    }

}