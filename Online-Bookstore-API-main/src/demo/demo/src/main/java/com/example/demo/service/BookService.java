package com.example.demo.service;
import java.util.List;
import com.example.demo.model.BookModel;
public interface BookService {
    BookModel createBook(BookModel book);
    BookModel getBookById (long id);
    List<BookModel> getAllBooks();
    BookModel updateBook (long id , BookModel book);
    void deleteBook(long id);

}
