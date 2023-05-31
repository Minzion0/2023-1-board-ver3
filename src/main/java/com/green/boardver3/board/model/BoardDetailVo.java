package com.green.boardver3.board.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardDetailVo {
    private int iboard;
    private String title;
    private String ctnt;
    private String writer;
    private String writerMainPic;
    private String createdAt;
    private String updatedAt;
}
