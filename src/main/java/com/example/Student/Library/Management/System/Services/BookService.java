package com.example.Student.Library.Management.System.Services;

import com.example.Student.Library.Management.System.DTOs.BookRequestDTO;
import com.example.Student.Library.Management.System.Models.Author;
import com.example.Student.Library.Management.System.Models.Book;
import com.example.Student.Library.Management.System.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;
    public String createBook(BookRequestDTO bookRequestDTO){

        int authorId=bookRequestDTO.getAuthorId();
        Author author=authorRepository.findById(authorId).get();

        Book book=new Book();
        book.setName(bookRequestDTO.getName());
        book.setGenre(bookRequestDTO.getGenre());
        book.setPages(bookRequestDTO.getPages());

        book.setAuthor(author);

        List<Book>books=author.getBooksWritten();
        books.add(book);
        author.setBooksWritten(books);

        authorRepository.save(author);
        return "Book added successfully";
    }
}
