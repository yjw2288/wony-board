package com.wony.board.operation.adapter;

import com.wony.board.port.output.BoardCommentOutputPort;
import com.wony.board.port.output.BoardOutputPort;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
class BoardOutput implements BoardOutputPort {
    private long boardId;
    private String title;
    private String contents;
    private List<BoardCommentOutputPort> comments;
}
