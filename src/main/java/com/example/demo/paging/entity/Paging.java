package com.example.demo.paging.entity;

import com.example.demo.basic.dto.BookDTO;
import com.example.demo.paging.dto.PagingDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Paging {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    private LocalDate publishedDate;
    private int price;

    public PagingDTO toDTO() {
        return PagingDTO.builder()
                .id(this.id)
                .title(this.title)
                .author(this.author)
                .publishedDate(String.valueOf(this.publishedDate))
                .price(this.price)
                .build();
    }
}
