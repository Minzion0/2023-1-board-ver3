package com.green.boardver3.board;

import com.green.boardver3.board.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Math.ceil;

@Service
public class BoardService {
    private final BoardMapper mapper;
    @Autowired
    public BoardService(BoardMapper mapper) {
        this.mapper = mapper;
    }
    public int insBoard(BoardInsDto dto){
        return mapper.insBoard(dto);
    }
    public int updBoard(BoardUpdDto dto){
        BoardUpdDto updDto = mapper.updBoard(dto);
//        if (updDto.getIuser() == dto.getIuser()){
//            return 1;
//        }
        return 0;
    }

    public List<BoardVo>selBoard(BoardDto dto){
        int num=dto.getPage()-1;
        dto.setStartIdx(num*dto.getRow());
        return mapper.selBoard(dto);
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
    public int delBoard(BoardDelDto dto){
        return mapper.delBoard(dto);
    }
}
