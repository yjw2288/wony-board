package com.wony.board;

import com.wony.board.port.input.BoardInputPort;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BoardForm implements BoardInputPort {
    private String title;
    private String contents;
}
