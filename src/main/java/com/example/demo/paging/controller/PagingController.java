package com.example.demo.paging.controller;

import com.example.demo.basic.dto.BookDTO;
import com.example.demo.basic.entity.Book;
import com.example.demo.basic.service.BookService;
import com.example.demo.paging.service.PagingService;
import org.hibernate.engine.jdbc.Size;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/books")
public class PagingController {

    private final PagingService bookService;

    public PagingController(PagingService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/save")
    public Book saveBook(@RequestBody BookDTO book){
        return bookService.saveBook(book);
    }

    @GetMapping("/list")
    public List<BookDTO> getAllBooks(Pageable page, Size size){
        List<BookDTO> booklist = bookService.getAllBooks();
        return booklist;
    }

    @GetMapping("/detail")
    public BookDTO getBookById(@RequestParam(name = "id") Long id){
        BookDTO book = bookService.getBookById(id);
        return book;
    }

    @PostMapping("/update")
    public void updateBook(@RequestParam(name = "id") Long id,@RequestBody BookDTO updatedBook){
        bookService.updateBook(id, updatedBook);
    }

    @PostMapping("/delete")
    public void deleteBook(@RequestParam(name = "id") Long id){
        bookService.deleteBook(id);
    }

}
