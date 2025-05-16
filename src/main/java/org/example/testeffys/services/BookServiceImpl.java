package org.example.testeffys.services;


import org.example.testeffys.entities.Book;
import org.example.testeffys.exception.ResourceNotFoundException;
import org.example.testeffys.repositories.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
    }

    @Override
    public Book createBook(Book book) {
        // Check if ISBN already exists
        if (bookRepository.existsByIsbn(book.getIsbn())) {
            throw new IllegalArgumentException("A book with ISBN " + book.getIsbn() + " already exists");
        }
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));

        // Check if ISBN is being changed to one that already exists
        if (!book.getIsbn().equals(bookDetails.getIsbn()) &&
                bookRepository.existsByIsbn(bookDetails.getIsbn())) {
            throw new IllegalArgumentException("A book with ISBN " + bookDetails.getIsbn() + " already exists");
        }

        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setIsbn(bookDetails.getIsbn());
        book.setPublishedDate(bookDetails.getPublishedDate());

        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
        bookRepository.delete(book);
    }

    // Implement other methods
}