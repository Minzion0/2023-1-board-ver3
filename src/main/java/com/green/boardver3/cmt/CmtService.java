package com.green.boardver3.cmt;


import com.green.boardver3.cmt.model.CmtEntity;
import com.green.boardver3.cmt.model.CmtSelDto;
import com.green.boardver3.cmt.model.CmtSelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmtService {
    private final CmtMapper mapper;

    @Autowired
    public CmtService(CmtMapper mapper) {
        this.mapper = mapper;
    }
    public int insCmt(CmtEntity entity){

        try{
            int iboard_cmt = mapper.insCmt(entity);
            if (iboard_cmt==1){
                return entity.getIboardCmt();
            }
        }catch (Exception e){
            e.printStackTrace();

        }

        return 0;

    }
    public List<CmtSelVo> selCmt(CmtSelDto dto){
        int page = dto.getPage()-1;
        dto.setStidx(page * dto.getRow());
        return mapper.selCmt(dto);
    }
}
