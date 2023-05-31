package com.green.boardver3.board.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardDetailVo {
    private String title;
    private String ctnt;
    private String nm;
    private String createdAt;
}
