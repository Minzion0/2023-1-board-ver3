package com.green.boardver3.board.model;

import lombok.Data;

@Data
public class BoardUpDto {
    private int iboard;
    private int iuser;
    private String title;
    private String ctnt;
}
