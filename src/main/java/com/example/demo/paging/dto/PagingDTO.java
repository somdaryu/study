package com.example.demo.paging.dto;

import com.example.demo.basic.entity.Book;
import com.example.demo.paging.entity.Paging;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PagingDTO {
    private Long id;
    private String title;
    private String author;
    private String publishedDate;
    private int price;

    public Paging toEntity() {
        return Paging.builder()
                .title(this.title)
                .author(this.author)
                .publishedDate(LocalDate.parse(this.publishedDate))
                .price(this.price)
                .build();
    }
}
