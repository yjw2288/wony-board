package com.wony.board;

import com.wony.domain.board.BoardComment;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "board_comment")
public class BoardCommentEntity implements BoardComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_comment_id", nullable = false)
    private long boardCommentId;

    @Column(name = "contents", nullable = false)
    private String contents;
}
