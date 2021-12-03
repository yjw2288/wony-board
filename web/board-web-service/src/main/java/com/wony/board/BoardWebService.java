package com.wony.board;

import com.wony.board.service.BoardService;
import com.wony.domain.board.Board;
import com.wony.domain.board.BoardComment;
import com.wony.util.WonyStreamUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardWebService {
    private final BoardService boardService;

    public List<BoardDto> findAll() {
        return boardService.findAll()
                .stream().map(board -> BoardDto
                        .builder()
                        .boardId(board.getBoardId())
                        .title(board.getTitle())
                        .contents(board.getContents())
                        .comments(fromBoardCommentDto(board.getComments()))
                        .build()).collect(Collectors.toList());
    }

    public BoardDto findById(long id) {
        return boardService.findById(id)
                .map(this::fromBoard)
                .orElseThrow();
    }

    public BoardDto write(BoardForm boardForm) {
        Board board = boardService.save(boardForm);
        return fromBoard(board);
    }

    private BoardDto fromBoard(Board board) {
        return BoardDto
                .builder()
                .boardId(board.getBoardId())
                .title(board.getTitle())
                .contents(board.getContents())
                .build();
    }

    private List<BoardCommentDto> fromBoardCommentDto(List<? extends BoardComment> comments) {
        return WonyStreamUtils.of(comments)
                .map(comment -> BoardCommentDto.builder()
                        .boardCommentId(comment.getBoardCommentId())
                        .contents(comment.getContents())
                        .build()).collect(Collectors.toList());
    }
}
