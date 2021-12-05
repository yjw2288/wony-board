package com.wony.board.operation.adapter;

import com.wony.board.operation.BoardService;
import com.wony.board.port.input.BoardInputPort;
import com.wony.board.port.output.BoardCommentOutputPort;
import com.wony.board.port.output.BoardOutputPort;
import com.wony.domain.board.Board;
import com.wony.domain.board.BoardComment;
import com.wony.util.WonyStreamUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardAdapter {
    private final BoardService boardService;

    @Transactional(readOnly = true)
    public List<BoardOutputPort> findAll() {
        return boardService.findAll()
                .stream().map(board -> BoardOutput
                        .builder()
                        .boardId(board.getBoardId())
                        .title(board.getTitle())
                        .contents(board.getContents())
                        .comments(fromBoardCommentDto(board.getComments()))
                        .build()).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<BoardOutputPort> findAllByTitle(String title) {
        return StreamSupport.stream(boardService.findByTitle(title).spliterator(), false)
                .map(this::fromBoard).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<BoardOutputPort> findByAllByTitleCustom(long boardId, String title) {
        return boardService.findByTitleCustom(boardId, title)
                .stream().map(this::fromBoard).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BoardOutputPort findById(long id) {
        return boardService.findById(id)
                .map(this::fromBoard)
                .orElseThrow();
    }

    @Transactional(readOnly = true)
    public BoardOutputPort write(BoardInputPort boardForm) {
        Board board = boardService.save(boardForm);
        return fromBoard(board);
    }

    private BoardOutputPort fromBoard(Board board) {
        return BoardOutput
                .builder()
                .boardId(board.getBoardId())
                .title(board.getTitle())
                .contents(board.getContents())
                .build();
    }

    private List<BoardCommentOutputPort> fromBoardCommentDto(List<? extends BoardComment> comments) {
        return WonyStreamUtils.of(comments)
                .map(comment -> BoardCommentOutput.builder()
                        .boardCommentId(comment.getBoardCommentId())
                        .contents(comment.getContents())
                        .build()).collect(Collectors.toList());
    }
}
