package com.green.boardver3.board.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@AllArgsConstructor
public class BoardVo {
    private int iboard;
    private String title;
    private String  nm;
    private String createdAt;
    private String writerMainPic;
}
