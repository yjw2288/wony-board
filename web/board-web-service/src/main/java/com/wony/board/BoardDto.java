package com.wony.board;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class BoardDto {
    private long boardId;
    private String title;
    private String contents;
    private List<BoardCommentDto> comments;
}
