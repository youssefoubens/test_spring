package org.example.testeffys;

import org.example.testeffys.entities.Book;
import org.example.testeffys.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class TestEffysApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestEffysApplication.class, args);
    }
    @Bean
    public CommandLineRunner initDatabase(BookRepository bookRepository) {
        return args -> {
            // Create and save some sample books
            Book book1 = new Book();
            book1.setTitle("The Great Gatsby");
            book1.setAuthor("F. Scott Fitzgerald");
            book1.setIsbn("978-0743273565");
            book1.setPublishedDate(LocalDate.of(1925, 4, 10));
            bookRepository.save(book1);

            Book book2 = new Book();
            book2.setTitle("To Kill a Mockingbird");
            book2.setAuthor("Harper Lee");
            book2.setIsbn("978-0061120084");
            book2.setPublishedDate(LocalDate.of(1960, 7, 11));
            bookRepository.save(book2);

            Book book3 = new Book();
            book3.setTitle("1984");
            book3.setAuthor("George Orwell");
            book3.setIsbn("978-0451524935");
            book3.setPublishedDate(LocalDate.of(1949, 6, 8));
            bookRepository.save(book3);

            Book book4 = new Book();
            book4.setTitle("Pride and Prejudice");
            book4.setAuthor("Jane Austen");
            book4.setIsbn("978-1503290564");
            book4.setPublishedDate(LocalDate.of(1813, 1, 28));
            bookRepository.save(book4);

            Book book5 = new Book();
            book5.setTitle("The Hobbit");
            book5.setAuthor("J.R.R. Tolkien");
            book5.setIsbn("978-0547928227");
            book5.setPublishedDate(LocalDate.of(1937, 9, 21));
            bookRepository.save(book5);

            System.out.println("Sample books initialized in database");
        };
    }
}
