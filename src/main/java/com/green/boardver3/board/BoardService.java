package com.green.boardver3.board;

import com.green.boardver3.board.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BoardService {
    private final BoardMapper mapper;


    @Autowired
    public BoardService(BoardMapper mapper) {
        this.mapper = mapper;
    }
    public int insBoard(BoardInsDto dto){
        BoardEntity entity= new BoardEntity();
        entity.setTitle(dto.getTitle());
        entity.setCtnt(dto.getCtnt());
        entity.setIuser(dto.getIuser());

        int result = mapper.insBoard(entity);
        if(result==1){
            return entity.getIboard();
        }
        return result;
    }


    public BoardRes selBoard(BoardDto dto){
        int num=dto.getPage()-1;
        dto.setStartIdx(num*dto.getRow());

        List<BoardVo> list = mapper.selBoard(dto);
        int max = mapper.maxboard();
        int ce = (int)Math.ceil((double)max/dto.getRow());
        int isMore = ce <= dto.getPage() ? 0:1;
        return BoardRes.builder()
                .list(list)
                .isMore(isMore)
                .maxpage(ce)
                .row(dto.getRow())
                .build();
    }
    public BoardMaxDto maxBoard(BoardMaxDto dto){
        int maxboard = mapper.maxboard();
        double num = Math.ceil((double) maxboard / dto.getRow());
        dto.setMaxPage((int)num);
        return dto;

    }
    public BoardDetailVo DeBoard(BoardDetailDto dto){
        return mapper.DeBoard(dto);
    }
    public int deleBoard(BoardDelDto dto){
        return mapper.deleBoard(dto);
    }
    public int upBoard(BoardUpdDto dto){
        return mapper.upBoard(dto);
    }

}
