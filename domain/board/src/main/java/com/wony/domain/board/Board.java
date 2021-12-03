package com.wony.domain.board;

import java.util.List;

public interface Board {
    long getBoardId();

    String getTitle();

    String getContents();

    List<? extends BoardComment> getComments();
}
