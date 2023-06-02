package com.green.boardver3.cmt.model;
import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Builder
@Getter
public class CmtRes {
    private int isMore; //0 댓글 더 없음, 1댓글 더 있음
    private int row;
    private int maxPage;
    private int nowPage;
    private int midPage;
    private List<CmtVo> list;
}