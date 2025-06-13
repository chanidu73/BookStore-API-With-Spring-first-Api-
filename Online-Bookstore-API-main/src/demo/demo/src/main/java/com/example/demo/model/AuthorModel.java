package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class AuthorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;

    private String name;

    private String bio;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<BookModel> books;

    public AuthorModel() {
    }

    public AuthorModel(Long authorId, String name, String bio, List<BookModel> books) {
        this.authorId = authorId;
        this.name = name;
        this.bio = bio;
        this.books = books;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<BookModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookModel> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "AuthorModel{" +
                "authorId=" + authorId +
                ", name='" + name + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}
