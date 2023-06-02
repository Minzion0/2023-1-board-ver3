package com.green.boardver3.board;

import com.green.boardver3.board.model.*;
import com.green.boardver3.cmt.CmtMapper;
import com.green.boardver3.cmt.CmtService;
import com.green.boardver3.cmt.model.CmtDelDto;
import com.green.boardver3.cmt.model.CmtRes;
import com.green.boardver3.cmt.model.CmtSelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardMapper mapper;
    private final CmtService cmtService;
    private final int ROW = 5;
    @Autowired
    public BoardService(BoardMapper mapper,CmtService cmtService) {
        this.mapper = mapper;
        this.cmtService = cmtService;
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
        int maxboard = mapper.maxboard();
        int mp = (int)Math.ceil((double) maxboard / dto.getRow());

        int isMore = mp>dto.getPage() ? 1:0;

        return BoardRes.builder().isMore(isMore)
                .row(dto.getRow()).maxPage(mp).list(list).build();



    }
    public BoardMaxDto maxBoard(BoardMaxDto dto){
        int maxboard = mapper.maxboard();
        double num = Math.ceil((double) maxboard / dto.getRow());
        dto.setMaxPage((int)num);
        return dto;

    }
    public BoardCmtDetailVo DeBoard(BoardDetailDto dto){
        BoardDetailVo boardDetailVo = mapper.DeBoard(dto);
        CmtSelDto cmtSelDto = new CmtSelDto();
        cmtSelDto.setIboard(dto.getIboard());
        cmtSelDto.setPage(dto.getPage());
        cmtSelDto.setRow(ROW);
        CmtRes cmtRes = cmtService.selCmt(cmtSelDto);

        BoardCmtDetailVo build = BoardCmtDetailVo.builder().boardVo(boardDetailVo).cmtList(cmtRes).build();

        return build;
    }
    public int deleBoard(BoardDelDto dto){

        CmtDelDto cmtDelDto = new CmtDelDto();
        cmtDelDto.setIboard(dto.getIboard());
        int num = mapper.selBoardUser(dto);
        if (dto.getIuser()==num){
            cmtService.delCmt(cmtDelDto);
            return mapper.deleBoard(dto);
        }
            return 0;






    }
    public int upBoard(BoardUpdDto dto){
        return mapper.upBoard(dto);
    }

}
