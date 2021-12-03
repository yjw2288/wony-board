package com.wony.port.board.output;

import java.util.List;

public interface BoardOutputPort {
    long getBoardId();

    String getTitle();

    String getContents();

    List<BoardCommentOutputPort> getComments();
}
