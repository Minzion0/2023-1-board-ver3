package com.green.boardver3.board.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class BoardRes {
    private int row;
    private int maxpage;
    private int isMore;
    private List<BoardVo> list;
}
