package com.example.bookstore.service;



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
            throw new IllegalStateException("This email already exists");
        }
        authorRepository.save(author);
        System.out.println("A new author has been saved correctly ! :)");
    }
    public Author getAuthorDetails(Author author){
        return authorRepository.findAuthorById(author.getId());
    }

    @Transactional
    public void updateAuthor(Long authorId, String firstName, String lastName, String address, String city, String zipCode, String email){
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new IllegalStateException(
                        "The author with the id "+authorId+ " doesn't exist"));

        if(firstName != null && firstName.length()>0 && !Objects.equals(author.getFirstName(), firstName)){
            author.setFirstName(firstName);
        }
        if(lastName != null && lastName.length()>0 && !Objects.equals(author.getLastName(),lastName)){
            author.setLastName(lastName);
        }
        if(address != null && address.length()>0 && !Objects.equals(author.getAddress(), address)){
            author.setAddress(address);
        }
        if(city != null && city.length()>0 && !Objects.equals(author.getCity(), city)){
            author.setCity(city);
        }
        if(zipCode != null && zipCode.length()>0 && !Objects.equals(author.getZipCode(), zipCode)){
            author.setZipCode(zipCode);
        }
        if(email != null && email.length()>0 && !Objects.equals(author.getEmail(), email)){
            author.setEmail(email);
        }

        authorRepository.save(author);

    }





}
