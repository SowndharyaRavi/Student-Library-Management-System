package com.example.Student.Library.Management.System.Controllers;

import com.example.Student.Library.Management.System.DTOs.BookRequestDTO;
import com.example.Student.Library.Management.System.Models.Book;
import com.example.Student.Library.Management.System.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/addBook")
    public String createBook(@RequestBody BookRequestDTO bookRequestDTO){
        return bookService.createBook(bookRequestDTO);
    }
}
