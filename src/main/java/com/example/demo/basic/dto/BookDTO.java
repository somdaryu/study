package com.example.demo.basic.dto;

import com.example.demo.basic.entity.Book;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private String publishedDate;
    private int price;

    public Book toEntity() {
        return Book.builder()
                .title(this.title)
                .author(this.author)
                .publishedDate(LocalDate.parse(this.publishedDate))
                .price(this.price)
                .build();
    }
}
