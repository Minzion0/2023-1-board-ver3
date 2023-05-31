package com.green.boardver3.cmt;

import com.green.boardver3.cmt.model.CmtInsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "댓글")
@RequestMapping("/board/cmt")
public class CmtController {
    private final CmtService service;
    @Autowired
    public CmtController(CmtService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "댓글생성")
    public int postCmt(@RequestBody CmtInsDto dto){
        return service.insCmt(dto);
    }
}
