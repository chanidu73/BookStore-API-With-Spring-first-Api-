package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String title;

    @Column(length = 1000)
    private String description;

    private BigDecimal price;

    private LocalDate publishedDate;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorModel author;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryModel category;

    public BookModel() {
    }

    public BookModel(Long bookId, String title, String description, BigDecimal price,
                     LocalDate publishedDate, AuthorModel author, CategoryModel category) {
        this.bookId = bookId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.publishedDate = publishedDate;
        this.author = author;
        this.category = category;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public AuthorModel getAuthor() {
        return author;
    }

    public void setAuthor(AuthorModel author) {
        this.author = author;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "BookModel{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", publishedDate=" + publishedDate +
                '}';
    }
}