package com.example.Student.Library.Management.System.Services;

import com.example.Student.Library.Management.System.DTOs.AuthorEntityDTO;
import com.example.Student.Library.Management.System.DTOs.AuthorResponseDTO;
import com.example.Student.Library.Management.System.DTOs.BookResponseDTO;
import com.example.Student.Library.Management.System.Models.Author;
import com.example.Student.Library.Management.System.Models.Book;
import com.example.Student.Library.Management.System.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public String createAuthor(AuthorEntityDTO authorEntityDTO){

        Author author=new Author();

        author.setName(authorEntityDTO.getName());
        author.setAge(authorEntityDTO.getAge());
        author.setCountry(authorEntityDTO.getCountry());
        author.setRating(authorEntityDTO.getRating());

        authorRepository.save(author);
        return "Author added successfully";
    }

    public AuthorResponseDTO getAuthor(int id){

        Author author = authorRepository.findById(id).get();
        AuthorResponseDTO authorResponseDTO=new AuthorResponseDTO();

        List<Book> bookList=author.getBooksWritten();
        List<BookResponseDTO> bookResponseDTOS=new ArrayList<>();

        for(Book b : bookList){
            BookResponseDTO bookResponseDTO=new BookResponseDTO();
            bookResponseDTO.setGenre(b.getGenre());
            bookResponseDTO.setPages(b.getPages());
            bookResponseDTO.setName(b.getName());

            bookResponseDTOS.add(bookResponseDTO);
        }

        authorResponseDTO.setBooksWritten(bookResponseDTOS);
        authorResponseDTO.setAge(author.getAge());
        authorResponseDTO.setCountry(author.getCountry());
        authorResponseDTO.setName(author.getName());
        authorResponseDTO.setRating(author.getRating());

        return authorResponseDTO;

    }
}
