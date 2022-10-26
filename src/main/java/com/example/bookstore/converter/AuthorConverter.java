package com.example.bookstore.converter;


import com.example.bookstore.model.Author;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
/*public class AuthorConverter {
    public Author toAuthorEntity(Long authorId, AuthorDTO authorDTO){
        Author author = new Author();
        author.setId(authorId);
        if(authorDTO.getFirstName() != null && authorDTO.getFirstName().length()>0 && !Objects.equals(author.getFirstName(), authorDTO.getFirstName())){
            author.setFirstName(authorDTO.getFirstName());
        }
        if(authorDTO.getLastName() != null && authorDTO.getLastName().length()>0 && !Objects.equals(author.getLastName(), authorDTO.getLastName())){
            author.setLastName(authorDTO.getLastName());
        }
        if(authorDTO.getAddress() != null && authorDTO.getAddress().length()>0 && !Objects.equals(author.getAddress(), authorDTO.getAddress())){
            author.setAddress(authorDTO.getAddress());
        }
        if(authorDTO.getCity() != null && authorDTO.getCity().length()>0 && !Objects.equals(author.getCity(), authorDTO.getCity())){
            author.setCity(authorDTO.getCity());
        }
        if(authorDTO.getZipCode() != null && authorDTO.getZipCode().length()>0 && !Objects.equals(author.getZipCode(), authorDTO.getZipCode())){
            author.setZipCode(authorDTO.getZipCode());
        }
        if(authorDTO.getEmail() != null && authorDTO.getEmail().length()>0 && !Objects.equals(author.getEmail(), authorDTO.getEmail())){
            author.setEmail(authorDTO.getEmail());
        }
        return author;
    }
}*/
