package com.olu.library.controller;


import com.olu.library.dto.BookDto;
import com.olu.library.service.BookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping(value = "/add")
    public Object addBook(@RequestBody BookDto bookDto){
        return bookService.addBook(bookDto);
    }

    @PutMapping("/book/{id}")
    public Object updateBook(@RequestBody BookDto bookDto, @PathVariable Long id){
        return bookService.updateBook(bookDto, id);
    }

    @GetMapping("/book")
    public  Object fetchBook(){
        return bookService.fetchBook();
    }

    @DeleteMapping("/book/{id}")
    public Object deleteBook(Long id){
        return bookService.deleteBook(id);
    }

}
