package com.wony.board.service;

import com.wony.board.BoardEntity;
import com.wony.board.BoardRepository;
import com.wony.domain.board.Board;
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

    @Transactional
    public Board save(BoardCommand boardCommand) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setTitle(boardCommand.getTitle());
        boardEntity.setContents(boardCommand.getContents());
        return boardRepository.save(boardEntity);
    }
}
