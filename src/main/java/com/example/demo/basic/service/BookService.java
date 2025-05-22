package com.example.demo.basic.service;

import com.example.demo.basic.dto.BookDTO;
import com.example.demo.basic.entity.Book;

import java.util.List;

public interface BookService {
    Book saveBook(BookDTO book);
    List<BookDTO> getAllBooks();
    BookDTO getBookById(Long id);
    void updateBook(Long id, BookDTO updatedBook);
    void deleteBook(Long id);
}
