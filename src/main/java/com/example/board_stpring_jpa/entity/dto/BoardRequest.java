package com.example.board_stpring_jpa.entity.dto;

import com.example.board_stpring_jpa.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BoardRequest {
    private String title;
    private String content;
    private String author;

    public Board toEntity() {
        return Board.builder()
                .title(this.title)
                .content(this.content)
                .author(this.author)
                .build();
    }
}
