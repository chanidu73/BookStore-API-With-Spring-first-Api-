package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.demo.model.BookModel;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService ;
    @Autowired
    public BookController(BookService bookService)
    {
        this.bookService = bookService;
    }
    @PostMapping
    public ResponseEntity<BookModel> createBook(@RequestBody BookModel book)
    {
        return ResponseEntity.ok(bookService.createBook(book));
    }

    @GetMapping("{id}")
    public ResponseEntity<BookModel> getBookById(@PathVariable long id)
    {
        BookModel book = bookService.getBookById(id);
        return (book!=null)? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
    }
    @GetMapping
    public ResponseEntity<List<BookModel>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }
    @PutMapping("/{id}")
    public ResponseEntity<BookModel> updateBook(@PathVariable long id , @RequestBody BookModel bookDetails)
    {
        BookModel updateBook = bookService.updateBook(id, bookDetails);
        return (updateBook !=  null) ? ResponseEntity.ok(updateBook) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable long id)
    {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }


}
