package com.warrior.ddamddam.studyboard.service;

import com.warrior.ddamddam.studyboard.domain.Board;
import com.warrior.ddamddam.studyboard.dto.BoardResponseDto;
import com.warrior.ddamddam.studyboard.dto.BoardSaveRequestDto;
import com.warrior.ddamddam.studyboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    /**
     * 게시글 생성
     */
    @Transactional
    public Long save(final BoardSaveRequestDto params) {

        Board entity = boardRepository.save(params.toEntity());
        return entity.getId();
    }

    /**
     * 게시글 리스트 조회
     */
    public List<BoardResponseDto> findAll() {

        Sort sort = Sort.by(Sort.Direction.DESC, "id", "createdDate");
        List<Board> list = boardRepository.findAll(sort);
        return list.stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }

    /**
     * 게시글 개별 조회
     */
    @Transactional(readOnly = true)
    public BoardResponseDto findById(Long id) {
        Board entity = boardRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));
//        entity.increaseCounts();
        return new BoardResponseDto(entity);
    }

    /**
     * 게시글 수정
     */
    @Transactional
    public Long update(final Long id, final BoardSaveRequestDto params) {

       Board entity = boardRepository.findById(id).orElseThrow(() -> new  IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
       entity.update(params.getTitle(), params.getContent(), params.getWriter());
        return id;
   }

    /**
     * 게시글 삭제
     */
    @Transactional
    public void delete(Long id){
        Board entity = boardRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));
        boardRepository.delete(entity);
    }

    /**
     * 조회수 증가
     */
    @Transactional public int updateCount(Long id) { return boardRepository.updateCount(id); }


}