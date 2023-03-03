package com.example.Student.Library.Management.System.Models;

import com.example.Student.Library.Management.System.Enums.Genre;
import com.example.Student.Library.Management.System.Enums.TransactionStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="bookTable")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int pages;

    private boolean isIssued;

    @Enumerated(value=EnumType.STRING)
    private Genre genre;

    @ManyToOne
    @JoinColumn
    private Author author;

    @ManyToOne
    @JoinColumn
    private Card card;

    //connecting transaction class
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Transactions> listOfTransactions=new ArrayList<>();

    public Book() {
    }

    public Book(int id, String name, int pages, Genre genre, Author author) {
        this.id = id;
        this.name = name;
        this.pages = pages;
        this.genre = genre;
        this.author = author;
    }

    public List<Transactions> getListOfTransactions() {
        return listOfTransactions;
    }

    public void setListOfTransactions(List<Transactions> listOfTransactions) {
        this.listOfTransactions = listOfTransactions;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
