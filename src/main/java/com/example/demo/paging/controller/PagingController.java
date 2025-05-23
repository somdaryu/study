package com.example.demo.paging.controller;

import com.example.demo.paging.dto.PagingDTO;
import com.example.demo.paging.entity.Paging;
import com.example.demo.paging.service.PagingService;
import org.hibernate.engine.jdbc.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.List;


@RestController
@RequestMapping("/paging")
public class PagingController {

    private final PagingService bookService;

    public PagingController(PagingService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/save")
    public Paging saveBook(@RequestBody PagingDTO book){
        return bookService.saveBook(book);
    }

    @PostMapping("/save-all")
    public List<PagingDTO> saveAllBooks(@RequestBody List<PagingDTO> books){
        return bookService.saveAllBooks(books);
    }

    @GetMapping("/list")
    public Page<PagingDTO> getAllBooks(Pageable page, Size size){
        Pageable pageable = (Pageable) PageRequest.of(1, 5);
        Page<PagingDTO> booklist = bookService.getAllBooks(pageable);
        return booklist;
    }

    @GetMapping("/detail")
    public PagingDTO getBookById(@RequestParam(name = "id") Long id){
        PagingDTO book = bookService.getBookById(id);
        return book;
    }

    @PostMapping("/update")
    public void updateBook(@RequestParam(name = "id") Long id,@RequestBody PagingDTO updatedBook){
        bookService.updateBook(id, updatedBook);
    }

    @PostMapping("/delete")
    public void deleteBook(@RequestParam(name = "id") Long id){
        bookService.deleteBook(id);
    }

}
