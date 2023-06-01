package com.green.boardver3.cmt;

import com.green.boardver3.cmt.model.CmtEntity;
import com.green.boardver3.cmt.model.CmtInsDto;
import com.green.boardver3.cmt.model.CmtSelDto;
import com.green.boardver3.cmt.model.CmtSelVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "댓글")
@RequestMapping("/board")
public class CmtController {
    private final CmtService service;
    @Autowired
    public CmtController(CmtService service) {
        this.service = service;
    }

    @PostMapping("/{iboard}/cmt")
    @Operation(summary = "댓글생성")
    public int postCmt(@PathVariable int iboard,
            @RequestBody CmtInsDto dto){
        CmtEntity entity = new CmtEntity();
        entity.setCtnt(dto.getCtnt());
        entity.setIuser(dto.getIuser());
        entity.setIboard(iboard);
        return service.insCmt(entity);
    }

    @GetMapping("/{iboard}/cmt")
    @Operation(summary = "댓글 보기")
    public List<CmtSelVo> getCmtList(@PathVariable int iboard, @RequestParam (defaultValue = "1") @Min(value = 1) int page , @RequestParam(defaultValue = "5") int row){
        CmtSelDto dto = new CmtSelDto();
        dto.setPage(page);
        dto.setRow(row);
        dto.setIboard(iboard);
        return service.selCmt(dto);
    }
}