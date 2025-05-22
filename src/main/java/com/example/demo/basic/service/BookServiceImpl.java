package com.example.demo.basic.service;

import com.example.demo.basic.dto.BookDTO;
import com.example.demo.basic.entity.Book;
import com.example.demo.basic.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book saveBook(BookDTO book) {
        Book entity = book.toEntity();
        return bookRepository.save(entity);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(Book::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO getBookById(Long id) {
        return bookRepository.findById(id)
                .map(Book::toDTO)
                .orElse(null);
    }

    @Override
    public void updateBook(Long id, BookDTO updatedBook) {
        Book book = bookRepository.findById(id).orElse(null);
        if(book != null) {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setPrice(updatedBook.getPrice());
            book.setPublishedDate(LocalDate.parse(updatedBook.getPublishedDate()));
            bookRepository.save(book);
        }
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
