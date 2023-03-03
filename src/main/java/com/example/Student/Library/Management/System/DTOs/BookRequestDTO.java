package com.example.Student.Library.Management.System.DTOs;

import com.example.Student.Library.Management.System.Enums.Genre;

public class BookRequestDTO {

    private String name;

    private int pages;

    private Genre genre;

    private int authorId;

    public BookRequestDTO() {
    }

    public BookRequestDTO(String name, int pages, Genre genre, int authorId) {
        this.name = name;
        this.pages = pages;
        this.genre = genre;
        this.authorId = authorId;
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

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
