package com.example.board_stpring_jpa.service;

import com.example.board_stpring_jpa.entity.Board;
import com.example.board_stpring_jpa.entity.dto.BoardRequest;
import com.example.board_stpring_jpa.entity.dto.BoardResponse;
import com.example.board_stpring_jpa.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {
    public static void main(String[] args) {
        String s = "asdasdasdasd";
        char[] chars = s.toCharArray();
        String.valueOf(chars[0]).toUpperCase();
    }
    private final BoardRepository boardRepository;
    public BoardResponse save(BoardRequest boardRequest) {
        Board board = boardRepository.save(boardRequest.toEntity());
        return BoardResponse.of(board);
    }

    public BoardResponse findId(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("아이디를 찾을 수 없습니다."));
        return BoardResponse.of(board);
    }

//    public List<Board> findTitle(String title) {
//        return boardRepository.findByTitle(title);
//    }
    public Page<BoardResponse> findAll(Pageable pageable){
        return boardRepository.findAll(pageable).map(BoardResponse::of);
    }

    public BoardResponse deleteId(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("아이디를 찾을 수 없습니다."));
        boardRepository.deleteById(id);
        return BoardResponse.of(board);
    }

    @Transactional
    public BoardResponse editId(Long id, BoardRequest boardRequest) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("아이디를 찾을 수 없습니다."));
        board.update(boardRequest.toEntity());
        return BoardResponse.of(board);
    }


}
