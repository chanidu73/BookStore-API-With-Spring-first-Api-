package com.example.demo.service;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public AuthorModel createAuthor(AuthorModel author) {
        return authorRepository.save(author);
    }

    @Override
    public AuthorModel getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public List<AuthorModel> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public AuthorModel updateAuthor(long id, AuthorModel author) {
        Optional<AuthorModel> existingAuthor = authorRepository.findById(id);
        if (existingAuthor.isPresent()) {
            AuthorModel updatedAuthor = existingAuthor.get();
            updatedAuthor.setName(author.getName());
            updatedAuthor.setBio(author.getBio());
            return authorRepository.save(updatedAuthor);
        } else {
            throw new RuntimeException("Author not found with id: " + id);
        }
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}