package com.example.demo.service;


import com.example.demo.model.*;
import java.util.List;

public interface AuthorService {
    AuthorModel createAuthor(AuthorModel author);
    AuthorModel getAuthorById(Long id );
    List<AuthorModel> getAllAuthors ();
    AuthorModel updateAuthor(long id, AuthorModel author);
    void deleteAuthor (Long id );
}
