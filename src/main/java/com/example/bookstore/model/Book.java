package com.example.bookstore.model;

import com.example.bookstore.model.Author;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "release_date")
    private LocalDate releasedate;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @Column(name = "price")
    private double price;

    public Book() {
    }

    public Book(String title, LocalDate releasedate, Author author, double price) {
        this.title = title;
        this.releasedate = releasedate;
        this.author = author;
        this.price = price;
    }

    public Book(Long id, String title, LocalDate releasedate, Author author, double price) {
        this.id = id;
        this.title = title;
        this.releasedate = releasedate;
        this.author = author;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(LocalDate releasedate) {
        this.releasedate = releasedate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
