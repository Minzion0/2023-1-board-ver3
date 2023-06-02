package com.green.boardver3.board;

import com.green.boardver3.board.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "보드")
@RequestMapping("/board")
public class BoardController {
    private final BoardService service;
    @Autowired
    public BoardController(BoardService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "글쓰기")
    public int postinsBoard(@RequestBody BoardInsDto dto){
        return service.insBoard(dto);

    }
    @GetMapping
    @Operation(summary = "페이징")
    public BoardRes getListBoard(@RequestParam (defaultValue = "1") int page,@RequestParam (defaultValue = "40") @Min (value = 40) int row){
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
    @Operation(summary = "글보기")
    public BoardCmtDetailVo DeBoard(@PathVariable int iboard){
        BoardDetailDto dto = new BoardDetailDto();
        dto.setIboard(iboard);

        return service.DeBoard(dto);
    }
    @DeleteMapping
    @Operation(summary = "글삭제")
    public int deleBoard(@RequestBody BoardDelDto dto){
        return service.deleBoard(dto);
    }
    @PutMapping
    @Operation(summary = "글수정")
    public int upBoard(@RequestBody BoardUpdDto dto){
        return service.upBoard(dto);
    }
}