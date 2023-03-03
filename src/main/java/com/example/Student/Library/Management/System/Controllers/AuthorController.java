package com.example.Student.Library.Management.System.Controllers;

import com.example.Student.Library.Management.System.DTOs.AuthorEntityDTO;
import com.example.Student.Library.Management.System.DTOs.AuthorResponseDTO;
import com.example.Student.Library.Management.System.Models.Author;
import com.example.Student.Library.Management.System.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/addAuthor")
    public String createAuthor(@RequestBody AuthorEntityDTO authorEntityDTO){
        return authorService.createAuthor(authorEntityDTO);
    }

    @GetMapping("/getAuthor")
    public AuthorResponseDTO getAuthor(@RequestParam("id") int id){
        return authorService.getAuthor(id);
    }
}
