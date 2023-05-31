package com.green.boardver3.board;

import com.green.boardver3.board.model.BoardDto;
import com.green.boardver3.board.model.BoardInsDto;
import com.green.boardver3.board.model.BoardUpdDto;
import com.green.boardver3.board.model.BoardVo;
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
    @PutMapping
    public int updBoard(@RequestBody BoardUpdDto dto){
        return service.updBoard(dto);
    }

}
