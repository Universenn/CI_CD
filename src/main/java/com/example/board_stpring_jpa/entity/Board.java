package com.example.board_stpring_jpa.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 8, message = "title error")
    private String title;

//    @Size(min = 2, max = 5)
//    @Column(length = 100, nullable = false)
    private String content;

//    @Column(length = 5, nullable = false)
    @Size(min = 2, max = 5)
    private String author;

    public void update(Board board) {
        updateTitle(board.getTitle());
        updateContent(board.getContent());
        updateAuthor(board.getAuthor());
    }

    private void updateTitle(String title) {
        if (title != null) {
            this.title = title;
        }
    }

    private void updateContent(String content) {
        if (content != null) {
            this.content = content;
        }
    }
    private void updateAuthor(String author) {
        if (author != null) {
            this.author = author;
        }
    }
}
