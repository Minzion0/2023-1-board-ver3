package com.green.boardver3.board;

import com.green.boardver3.board.model.BoardDto;
import com.green.boardver3.board.model.BoardInsDto;
import com.green.boardver3.board.model.BoardUpdDto;
import com.green.boardver3.board.model.BoardVo;
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

    public int insBoard(BoardInsDto dto) {
        return mapper.insBoard(dto);
    }

    public int updBoard(BoardUpdDto dto) {
        BoardUpdDto updDto = mapper.updBoard(dto);
//        if (updDto.getIuser() == dto.getIuser()){
//            return 1;
//        }
        return 0;
    }

    public List<BoardVo> selBoard(BoardDto dto) {
        int page = dto.getPage() - 1;
        dto.setStartIdx(page * dto.getRow());
        return mapper.selBoard(dto);
    }
    public List<BoardVo> maxBoard(BoardDto dto){
        int page = dto.getMaxpage();
        int Row = dto.getRow();
        double maxpage= Math.ceil(page/Row);
        dto.setMaxpage(maxpage);
        return mapper.maxBoard(dto);
    }
}
