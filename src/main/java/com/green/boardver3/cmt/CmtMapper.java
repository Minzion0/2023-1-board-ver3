package com.green.boardver3.cmt;

import com.green.boardver3.cmt.model.CmtEntity;
import com.green.boardver3.cmt.model.CmtVo;
import com.green.boardver3.cmt.model.CmtselDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmtMapper {
    int insCmt(CmtEntity entity);
    List<CmtVo> selCmt(CmtselDto dto);
}
