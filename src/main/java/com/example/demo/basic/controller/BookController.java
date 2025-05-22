package com.example.demo.basic.controller;

import com.example.demo.basic.dto.BookDTO;
import com.example.demo.basic.entity.Book;
import com.example.demo.basic.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/save")
    public Book saveBook(@RequestBody BookDTO book){
        return bookService.saveBook(book);
    }
    @GetMapping("/list")
    public List<BookDTO> getAllBooks(){
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
