package com.example.Student.Library.Management.System.DTOs;

import java.util.List;

public class AuthorResponseDTO {

    private String name;

    private int age;

    private String country;

    private double rating;

    private List<BookResponseDTO> booksWritten;

    public AuthorResponseDTO() {
    }

    public AuthorResponseDTO(String name, int age, String country, double rating, List<BookResponseDTO> booksWritten) {
        this.name = name;
        this.age = age;
        this.country = country;
        this.rating = rating;
        this.booksWritten = booksWritten;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public List<BookResponseDTO> getBooksWritten() {
        return booksWritten;
    }

    public void setBooksWritten(List<BookResponseDTO> booksWritten) {
        this.booksWritten = booksWritten;
    }
}
