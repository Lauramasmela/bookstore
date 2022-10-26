package com.example.bookstore.controller;


import com.example.bookstore.model.Author;
import com.example.bookstore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/author")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(path = "/list")
    public List<Author> getListOfAuthors(){
        return authorService.getListOfAuthors();
    }

    @PostMapping
    public void addNewAuthor(@RequestBody Author author){
        authorService.addNewAuthor(author);
    }

    @GetMapping(path = "/{id}/details")
    public Author getAuthorDetails(Author author){
        return authorService.getAuthorDetails(author);
    }

    @PutMapping(path = "/{id}")
    public void updateAuthor(
            @PathVariable("id") Long authorId,
            //@Valid
            @RequestBody String firstName,  @RequestBody String lastName, @RequestBody String address,
            @RequestBody String city, @RequestBody String zipCode, @RequestBody String email
            ){
        authorService.updateAuthor(authorId,  firstName,  lastName,  address,  city,  zipCode, email);
    }
}
