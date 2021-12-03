package com.wony.board;

import com.wony.board.operation.adapter.BoardAdapter;
import com.wony.port.board.input.BoardInputPort;
import com.wony.port.board.output.BoardOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardWebService {
    private final BoardAdapter boardService;

    public List<BoardOutputPort> findAll() {
        return boardService.findAll();
    }

    public List<BoardOutputPort> findAllByTitle(String title) {
        return boardService.findAllByTitle(title);
    }

    public List<BoardOutputPort> findByAllByTitleCustom(long boardId, String title) {
        return boardService.findByAllByTitleCustom(boardId, title);
    }

    public BoardOutputPort findById(long id) {
        return boardService.findById(id);
    }

    public BoardOutputPort write(BoardInputPort boardForm) {
        return boardService.write(boardForm);
    }
}
