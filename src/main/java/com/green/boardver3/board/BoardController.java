package com.green.boardver3.board;

import com.green.boardver3.board.model.*;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService service;
    @Autowired
    public BoardController(BoardService service) {
        this.service = service;
    }

    @PostMapping
    public int postBoard(@RequestBody BoardInsDto dto){
        return service.insBoard(dto);

    }
    @GetMapping
    public List<BoardVo>getBoard(@RequestParam (defaultValue = "1") int page,@RequestParam (defaultValue = "40") @Min (value = 40) int row){
        BoardDto dto = new BoardDto();
        dto.setPage(page);
        dto.setRow(row);
        return service.selBoard(dto);
    }
    @GetMapping("/maxpage")
    public int getMaxPage(@RequestParam (defaultValue = "30") int row){
        BoardMaxDto dto = new BoardMaxDto();
        dto.setRow(row);
        BoardMaxDto boardMaxDto = service.maxBoard(dto);
        return boardMaxDto.getMaxPage();
    }

    @GetMapping("/{iboard}")
    public BoardDetailVo DeBoard(@PathVariable int iboard){
        BoardDetailDto dto = new BoardDetailDto();
        dto.setIboard(iboard);
        return service.DeBoard(dto);
    }





}