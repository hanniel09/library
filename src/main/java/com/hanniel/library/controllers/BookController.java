package com.hanniel.library.controllers;

import com.hanniel.library.dtos.BookDTO;
import com.hanniel.library.models.Book;
import com.hanniel.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping()
    public ResponseEntity<List<Book>> getBooks(){
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable Long id){
        return new ResponseEntity<>(bookService.findBookById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Book> createBook(@RequestBody BookDTO data){
        return new ResponseEntity<>(bookService.createBook(data), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody BookDTO data, @PathVariable Long id){
        return new ResponseEntity<>(bookService.updateBook(data, id), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
