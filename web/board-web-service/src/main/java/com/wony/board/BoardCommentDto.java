package com.wony.board;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardCommentDto {
    private long boardCommentId;
    private String contents;
}
