package com.wony.board;

import java.util.List;

public interface BoardCustomRepository {
    List<BoardEntity> findByTitle(long boardId, String title);
}
