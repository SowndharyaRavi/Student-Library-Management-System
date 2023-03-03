package com.example.Student.Library.Management.System.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="authorTable")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int age;

    private String name;

    private String country;

    private double rating;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Book> booksWritten;

    public Author() {
        booksWritten=new ArrayList<>();
    }

    public Author(int id, int age, String name, String country, double rating, List<Book> booksWritten) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.country = country;
        this.rating = rating;
        this.booksWritten = booksWritten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<Book> getBooksWritten() {
        return booksWritten;
    }

    public void setBooksWritten(List<Book> booksWritten) {
        this.booksWritten = booksWritten;
    }
}
