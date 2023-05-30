package com.green.boardver3.board;

import com.green.boardver3.board.model.BoardInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    private final BoardMapper mapper;
    @Autowired
    public BoardService(BoardMapper mapper) {
        this.mapper = mapper;
    }
    public int insBoard(BoardInsDto dto){
        return mapper.insBoard(dto);
    }
}
