package com.green.boardver3.board;

import com.green.boardver3.board.model.BoardInsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    int insBoard(BoardInsDto dto);
}
