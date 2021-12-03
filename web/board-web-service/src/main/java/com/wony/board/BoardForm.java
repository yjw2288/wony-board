package com.wony.board;

import com.wony.board.service.BoardCommand;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardForm implements BoardCommand {
    private String title;
    private String contents;
}
