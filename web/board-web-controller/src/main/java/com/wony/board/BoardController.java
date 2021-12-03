package com.wony.board;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardWebService boardWebService;

    @GetMapping("")
    public List<BoardDto> findAll() {
        return boardWebService.findAll();
    }

    @GetMapping("/{id}")
    public BoardDto findById(@PathVariable long id) {
        return boardWebService.findById(id);
    }

    @GetMapping("/findByTitle")
    public List<BoardDto> findByTitle(@RequestParam String title) {
        return boardWebService.findAllByTitle(title);
    }

    @GetMapping("/findByTitleCustom")
    public List<BoardDto> findByTitleCustom(@RequestParam long boardId, @RequestParam String title) {
        return boardWebService.findByAllByTitleCustom(boardId, title);
    }

    @PostMapping
    public BoardDto write(@RequestBody BoardForm boardForm) {
        return boardWebService.write(boardForm);
    }
}
