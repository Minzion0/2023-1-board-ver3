package com.green.boardver3.cmt;

import com.green.boardver3.cmt.model.CmtEntity;
import com.green.boardver3.cmt.model.CmtInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CmtService {
    private final CmtMapper mapper;
    @Autowired
    public CmtService(CmtMapper mapper) {
        this.mapper = mapper;
    }
    public int insCmt(CmtInsDto dto){
        CmtEntity entity = new CmtEntity();
        entity.setCtnt(dto.getCtnt());
        entity.setIuser(dto.getIuser());
        entity.setIboard(dto.getIboard());
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
}
