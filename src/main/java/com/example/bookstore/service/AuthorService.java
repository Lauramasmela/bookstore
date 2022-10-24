package com.example.bookstore.service;

import com.example.bookstore.dtos.AuthorDTO;
import com.example.bookstore.model.Author;
import com.example.bookstore.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor //Ceci remplace l'Autowired
@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<Author> getListOfAuthors(){
       return authorRepository.findAll();
    }

    public void addNewAuthor(Author author){
        Optional<Author> authorOptional = authorRepository.findAuthorByEmail(author.getEmail());
        if(authorOptional.isPresent()){
            throw new IllegalStateException("This authorDTO.getEmail() already exists");
        }
        authorRepository.save(author);
        System.out.println("A new author has been saved correctly ! :)");
    }
    public Author getAuthorDetails(Author author){
        return authorRepository.findAuthorById(author.getId());
    }

    @Transactional
    public void updateAuthor(Long authorId, AuthorDTO authorDTO){
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new IllegalStateException(
                        "The author with the id "+authorId+ " doesn't exist"));
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
           Optional<Author> authorOptional = authorRepository.findAuthorByEmail(authorDTO.getEmail());
           if(authorOptional.isPresent()){
               throw new IllegalStateException("This authorDTO.getEmail() already exists");
           }
            author.setEmail(authorDTO.getEmail());
        }
        authorRepository.save(author);
    }





}
