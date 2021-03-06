package com.wony.board.operation.adapter;

import com.wony.board.port.output.BoardCommentOutputPort;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
class BoardCommentOutput implements BoardCommentOutputPort {
    private long boardCommentId;
    private String contents;
}
