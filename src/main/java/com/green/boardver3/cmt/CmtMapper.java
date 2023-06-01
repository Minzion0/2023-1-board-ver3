package com.green.boardver3.cmt;

import com.green.boardver3.cmt.model.*;
import com.green.boardver3.cmt.model.CmtSelDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmtMapper {

    int insCmt(CmtEntity entity);
    List<CmtSelVo>selCmt(CmtSelDto dto);
    int delCmt(CmtDelDto dto);
    int updCmt(CmtEntity entity);
}
