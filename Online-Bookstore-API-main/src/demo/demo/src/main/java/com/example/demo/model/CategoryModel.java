package com.example.demo.model;


import jakarta.persistence.*;
import java.util.List;

@Entity
public class CategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<BookModel> books;

    public CategoryModel() {
    }

    public CategoryModel(Long categoryId, String name, List<BookModel> books) {
        this.categoryId = categoryId;
        this.name = name;
        this.books = books;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookModel> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "CategoryModel{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                '}';
    }
}