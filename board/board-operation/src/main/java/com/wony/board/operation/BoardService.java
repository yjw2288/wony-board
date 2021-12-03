package com.wony.board.operation;

import com.wony.board.BoardEntity;
import com.wony.board.BoardRepository;
import com.wony.board.QBoardEntity;
import com.wony.domain.board.Board;
import com.wony.port.board.input.BoardInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public List<? extends Board> findAll() {
        return boardRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<? extends Board> findById(long id) {
        return boardRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Iterable<? extends Board> findByTitle(String title) {
        return boardRepository.findAll(QBoardEntity.boardEntity.title.eq(title));
    }

    @Transactional(readOnly = true)
    public List<? extends Board> findByTitleCustom(long boardId, String title) {
        return boardRepository.findByTitle(boardId, title);
    }

    @Transactional
    public Board save(BoardInputPort boardCommand) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setTitle(boardCommand.getTitle());
        boardEntity.setContents(boardCommand.getContents());
        return boardRepository.save(boardEntity);
    }
}
