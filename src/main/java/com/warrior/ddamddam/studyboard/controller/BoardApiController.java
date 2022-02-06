package com.warrior.ddamddam.studyboard.controller;

import com.warrior.ddamddam.studyboard.domain.Board;
import com.warrior.ddamddam.studyboard.dto.BoardResponseDto;
import com.warrior.ddamddam.studyboard.dto.BoardSaveRequestDto;
import com.warrior.ddamddam.studyboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;

    /**
     * 게시글 생성
     */
    @PostMapping("/boards/write")
    public Long save(@RequestBody final BoardSaveRequestDto params) {
        return boardService.save(params);
    }


    /**
     * 게시글 리스트 조회
     */
    @GetMapping("/boards/list")
    public List<BoardResponseDto> findAll() {
        return boardService.findAll();
    }


    //개별 조회
    @GetMapping("/boards/{id}")
    public BoardResponseDto findById(@PathVariable Long id) {
        boardService.updateCount(id);
        return boardService.findById(id);
    }

    /**
     * 게시글 수정
     */
   @PutMapping("/boards/{id}")
   public Long save(@PathVariable final Long id, @RequestBody final BoardSaveRequestDto params) {
        return boardService.update(id, params);
    }

    /**
     * 게시글 삭제
     */
    @DeleteMapping("/boards/{id}")
    public void delete(@PathVariable Long id){
        boardService.delete(id);
    }

}