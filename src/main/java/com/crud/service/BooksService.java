package com.crud.service;

import com.crud.model.Books;
import com.crud.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksService {

    @Autowired
    BooksRepository booksRepository;

    public List<Books> getAllBooks(){
        List<Books> books = new ArrayList<Books>();
        booksRepository.findAll().forEach(book -> books.add(book));
        return books;
    }

    public Books getBooksById(int id){
       return booksRepository.findById(id).get();
    }

    public void saveOrUpdate(Books books){
        booksRepository.save(books);
    }

    public void delete(int id){
        booksRepository.deleteById(id);
    }

    public void update(Books books, int bookid){
        booksRepository.save(books);
    }
}
