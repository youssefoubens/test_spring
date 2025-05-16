package org.example.testeffys.services;


import org.example.testeffys.entities.Book;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public List<Book> getAllBooks() {
        return List.of();
    }

    @Override
    public Book getBookById(Long id) {
        return null;
    }

    @Override
    public Book createBook(Book book) {
        return null;
    }

    @Override
    public Book updateBook(Long id, Book book) {
        return null;
    }

    @Override
    public void deleteBook(Long id) {

    }

    // Implement other methods
}