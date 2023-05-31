package com.green.boardver3.board.model;

import lombok.Data;

@Data
public class BoardDto extends BoardEntity{
    private int row;
    private int page;
    private int startIdx;
    private int maxpage;
}
