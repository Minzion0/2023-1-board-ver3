package com.green.boardver3.cmt;

import com.green.boardver3.cmt.model.CmtInsDto;
import com.green.boardver3.cmt.model.CmtSelDto;
import com.green.boardver3.cmt.model.CmtSelVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

    @PostMapping("/cmt")
    @Operation(summary = "댓글생성")
    public int postCmt(@RequestBody CmtInsDto dto){

        return service.insCmt(dto);
    }

    @GetMapping("/{iboard}/cmt")
    public List<CmtSelVo> getCmtList(@PathVariable int iboard,int page){
        CmtSelDto dto = new CmtSelDto();
        dto.setPage(page);
        dto.setIboard(iboard);
        return service.selCmt(dto);
    }
}
