package com.green.boardver3.cmt;

import com.green.boardver3.board.model.BoardDelDto;
import com.green.boardver3.cmt.model.*;
import com.green.boardver3.cmt.model.CmtSelDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmtMapper {

    int insCmt(CmtEntity entity);
    int selCountCmt(CmtSelDto dto);
    List<CmtVo> selCmt(CmtSelDto dto);
    int delCmt(CmtDelDto dto);
    int updCmt(CmtEntity entity);
    int iboardCmtNum (BoardDelDto dto);
}
