package com.crud.controller;

import com.crud.model.Books;
import com.crud.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
public class BooksController {

    @Autowired
    BooksService booksService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello! Spring Boot application is running.";
    }

    @GetMapping("/books")
    private List<Books> getAllBooks(){
        return booksService.getAllBooks();
    }

    @GetMapping("/books/{bookid}")
    private Books getBooks(@PathVariable("bookid") int bookid){
        return booksService.getBooksById(bookid);
    }

    @DeleteMapping("/books/{bookid}")
    private void deleteBook(@PathVariable("bookid") int bookid){
        booksService.delete(bookid);
    }

    @PostMapping("/books")
    private int saveBook(@RequestBody Books books) {
        booksService.saveOrUpdate(books);
        return books.getBookId();
    }

    @PutMapping("/books")
    private Books update(@RequestBody Books books){
        booksService.saveOrUpdate(books);
        return books;
    }

}
