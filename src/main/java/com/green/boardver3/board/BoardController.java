package com.green.boardver3.board;

import com.green.boardver3.board.model.BoardInsDto;
import com.green.boardver3.board.model.BoardUpdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping
    public int updBoard(@RequestBody BoardUpdDto dto){
        return service.updBoard(dto);
    }

}
