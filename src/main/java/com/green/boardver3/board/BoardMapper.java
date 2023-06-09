package com.green.boardver3.board;

import com.green.boardver3.board.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int insBoard(BoardEntity entity);
    List<BoardVo> selBoard(BoardDto dto);
    int maxboard();
    BoardDetailVo DeBoard(BoardDetailDto dto);
    int deleBoard(BoardDelDto dto);
    int upBoard(BoardUpdDto dto);
    int selBoardUser(BoardDelDto dto);
}
