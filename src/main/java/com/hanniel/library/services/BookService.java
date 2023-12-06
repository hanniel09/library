package com.hanniel.library.services;

import com.hanniel.library.dtos.BookDTO;
import com.hanniel.library.exceptions.RecordNotFoundException;
import com.hanniel.library.models.Book;
import com.hanniel.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book findBookById(Long id){
        return bookRepository.findById(id).orElseThrow(() ->
                new RecordNotFoundException(id));
    }

    public Book createBook(BookDTO data){
        Book book = new Book(data);
        return bookRepository.save(book);
    }

    public Book updateBook(BookDTO data, Long id){
        Book savedBook = findBookById(id);
        Book newBook = new Book(data);
        newBook.setId(savedBook.getId());
        return bookRepository.save(newBook);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
}
