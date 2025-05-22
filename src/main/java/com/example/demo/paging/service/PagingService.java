package com.example.demo.paging.service;

import com.example.demo.basic.dto.BookDTO;
import com.example.demo.basic.entity.Book;
import com.example.demo.paging.dto.PagingDTO;
import com.example.demo.paging.entity.Paging;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PagingService {
    Paging saveBook(PagingDTO paging);
    Page<PagingDTO> getAllBooks(Pageable pageable);
    PagingDTO getBookById(Long id);
    void updateBook(Long id, PagingDTO updatedPaging);
    void deleteBook(Long id);
}
