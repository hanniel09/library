package com.hanniel.library.models;

import com.hanniel.library.dtos.BookDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String actor;

    @Column(nullable = false)
    private Double price;

    public Book() {
    }

    public Book(String name, String actor, Double price) {
        this.name = name;
        this.actor = actor;
        this.price = price;
    }

    public Book(BookDTO data) {
        this.name = data.name();
        this.actor = data.actor();
        this.price = data.price();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
