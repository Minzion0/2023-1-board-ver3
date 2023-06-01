package com.green.boardver3.cmt;

import com.green.boardver3.cmt.model.CmtDelDto;
import com.green.boardver3.cmt.model.CmtEntity;
import com.green.boardver3.cmt.model.CmtSelDto;
import com.green.boardver3.cmt.model.CmtSelVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmtMapper {

    int insCmt(CmtEntity entity);
    List<CmtSelVo>selCmt(CmtSelDto dto);
    int delCmt(CmtDelDto dto);
}
