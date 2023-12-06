package com.olu.library.service;

import com.olu.library.dto.BookDto;
import com.olu.library.model.Book;
import com.olu.library.repo.BookRepo;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepo bookRepo;

    public  BookService(BookRepo bookRepo){
        this.bookRepo = bookRepo;
    }

    public Object addBook(BookDto bookDto){
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setIsbn(bookDto.getIsbn());
        return bookRepo.save(book);
    }

    public Object updateBook(BookDto bookDto, Long id){
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

                book.setTitle(bookDto.getTitle());
                book.setAuthor(bookDto.getAuthor());
                book.setIsbn(bookDto.getIsbn());

                return bookRepo.save(book);

    }

    public Object fetchBook(){
        return bookRepo.findAll();
    }

    public  Object deleteBook(Long id){
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found, Try again"));
        bookRepo.delete(book);

        return "Book deleted successfully";
    }

}
