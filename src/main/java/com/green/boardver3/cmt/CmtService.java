package com.green.boardver3.cmt;


import com.green.boardver3.cmt.model.*;
import com.green.boardver3.cmt.model.CmtSelDto;
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
    public CmtRes selCmt(CmtSelDto dto){
        int page = dto.getPage()-1;
        dto.setStidx(page * dto.getRow());
        List<CmtVo> list =mapper.selCmt(dto);
        int maxPage = mapper.selMaxCmt(dto);
       double ce = Math.ceil((double) maxPage / dto.getRow());
        int isMore=0;
        if ((int)ce<=page){
            isMore=0;
        }else {
            isMore=1;
        }

        return CmtRes.builder()
                .list(list)
                .isMore(isMore)
                .build();

    }
    public int delCmt(CmtDelDto dto){
        return mapper.delCmt(dto);
    }

    public int updCmt(CmtEntity entity){
        return mapper.updCmt(entity);
    }
}
