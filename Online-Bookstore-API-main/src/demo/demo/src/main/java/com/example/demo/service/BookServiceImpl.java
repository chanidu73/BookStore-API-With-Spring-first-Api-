package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.BookModel;
import com.example.demo.repository.BookRepository;
@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookModel createBook(BookModel book) {
        return bookRepository.save(book);
    }

    @Override
    public BookModel getBookById(long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<BookModel> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public BookModel updateBook(long id, BookModel book) {
        Optional<BookModel>optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()){
            BookModel bookDetails = optionalBook.get();
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setPrice(bookDetails.getPrice());
            book.setPublishedDate(bookDetails.getPublishedDate());
            return bookRepository.save(book);
        }
    }

    @Override
    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }

}
