package com.green.boardver3.board;

import com.green.boardver3.board.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int insBoard(BoardInsDto dto);
    List<BoardVo> selBoard(BoardDto dto);
    int maxboard();
    BoardDetailVo DeBoard(BoardDetailDto dto);
    int updBoard(BoardUpDto dto);
    void delBoard(BoardDelDto dto);
}
