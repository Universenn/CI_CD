package com.example.board_stpring_jpa.controller;

import com.example.board_stpring_jpa.entity.Board;
import com.example.board_stpring_jpa.entity.dto.BoardRequest;
import com.example.board_stpring_jpa.entity.dto.BoardResponse;
import com.example.board_stpring_jpa.repository.BoardRepository;
import com.example.board_stpring_jpa.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@RestController
@RequestMapping("/api/v1/boards")
@RequiredArgsConstructor
public class BoardRestController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;

    @PostMapping("")
    public BoardResponse save(@RequestBody BoardRequest boardRequest) {
        return boardService.save(boardRequest);
    }

    @GetMapping("/{id}")
    public BoardResponse findById(@PathVariable("id") Long id){
        return boardService.findId(id);
    }

    @GetMapping("/title")
    public List<Board> findByTitle(@RequestParam(required = false) String title, @RequestParam(required = false) String content){
        if (StringUtils.isEmpty(title) && StringUtils.isEmpty(content)){
//            return boardService.findAll();
            return null;
        }
        return boardRepository.findByTitleOrContent(title, content);
    }

    @GetMapping("")
    public Page<BoardResponse> findALl(@PageableDefault(size = 20, sort = "id")Pageable pageable){
        return boardService.findAll(pageable);
    }

    @DeleteMapping("/{id}")
    public BoardResponse deleteById(@PathVariable("id")Long id){
        return boardService.deleteId(id);
    }

    @PatchMapping("/{id}")
    public BoardResponse edit(@PathVariable("id") Long id, @RequestBody BoardRequest boardRequest) {
        return boardService.editId(id, boardRequest);
    }
}
